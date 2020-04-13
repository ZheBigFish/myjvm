package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.instructions.base.MethodInvokeLogic;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.heap.MethodLookup;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.MethodRef;

/**
 * @ClassName Invokespecial
 * @Date
 * @Author
 * @Description 调用超类构造方法，实例初始化方法，私有方法
 **/
public class Invokespecial extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        KClass currentClass = frame.getMethod().getAClass();
        HeapConstantPool contantPool = currentClass.getContantPool();
        MethodRef invokeMethodRef = (MethodRef) contantPool.getConstant(index);
        Method invokeMethod = invokeMethodRef.resolvedMethod();
        KClass invokeKClass = invokeMethodRef.resolvedClass();
        if ("<init>".equals(invokeMethod.name) && invokeMethod.getAClass() != invokeKClass) {
            throw new RuntimeException("java.lang.NoSuchMethodError");
        }
        if (invokeMethod.isStatic()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        //获取this引用
        Object o = frame.getOperandStack().getRefFromTop(invokeMethod.getArgSlotCount());
        if (o == null) {
            throw new RuntimeException("java.lang.NullPointerException");
        }
        //确保protected方法只能被声明该方法的类或子类调用
        if (invokeMethod.isProtected() && invokeMethod.getAClass().isSubClassOf(currentClass)
                && invokeMethod.getAClass().getPackageName() != currentClass.getPackageName()
                && o.getAClass() != currentClass && !o.getAClass().isSubClassOf(currentClass)) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        Method methodToBeInvoked = invokeMethod;
        if (currentClass.isSuper() && invokeKClass.isSubClassOf(currentClass) && !"<init>".equals(invokeMethod.name)) {
            methodToBeInvoked = MethodLookup.lookUpMethodInClass(currentClass.superClass, invokeMethod.getName(), invokeMethod.getDescriptor());
        }
        if (methodToBeInvoked == null || methodToBeInvoked.isAbstract()) {
            throw new RuntimeException("java.lang.AbstractMethodError");
        }
        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
    }
}
