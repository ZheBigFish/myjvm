package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.instructions.base.MethodInvokeLogic;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.OperandStack;
import com.ziyu.jvm.ch07.rtda.heap.MethodLookup;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.MethodRef;

/**
 * @ClassName Invokevirtual
 * @Date
 * @Author
 * @Description TODO
 **/
public class Invokevirtual extends Index16Instruction {

    @Override
    public void execute(Frame frame) {

//        frame.getOperandStack().popRef();
        KClass currentClass = frame.getMethod().getAClass();
        HeapConstantPool contantPool = currentClass.getContantPool();
        MethodRef methodRef = (MethodRef) contantPool.getConstant(index);

        if (methodRef.getName().equals("println")) {
            OperandStack operandStack = frame.getOperandStack();
            switch (methodRef.getDescriptor()) {
                case "(Z)V":
                    System.out.println(operandStack.popInt() != 0);
                    break;
                case "(C)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(B)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(S)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(I)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(J)V":
                    System.out.println(operandStack.popLong());
                    break;
                case "(F)V":
                    System.out.println(operandStack.popFloat());
                    break;
                case "(D)V":
                    System.out.println(operandStack.popDouble());
                    break;
                default:
                    System.out.println("println: " + methodRef.getDescriptor());
            }
            operandStack.popRef();
        }

        Method method = methodRef.resolvedMethod();
        KClass kClass = methodRef.resolvedClass();
        if ("<init>".equals(method) && method.getAClass() != kClass) {
            throw new RuntimeException("java.lang.NoSuchMethodError");
        }
        if (method.isStatic()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        //获取this引用
        Object o = frame.getOperandStack().getRefFromTop(method.getArgSlotCount());
        if (o == null) {
            throw new RuntimeException("java.lang.NullPointerException");
        }
        //确保protected方法只能被声明该方法的类或子类调用
        if (method.isProtected() && method.getAClass().isSubClassOf(currentClass)
                && method.getAClass().getPackageName() != currentClass.getPackageName()
                && o.getAClass() != currentClass && !o.getAClass().isSubClassOf(currentClass)) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }

        Method methodToBeInvoked = MethodLookup.lookUpMethodInClass(currentClass, methodRef.getName(), methodRef.getDescriptor());
        if (methodToBeInvoked == null || methodToBeInvoked.isAbstract()) {
            throw new RuntimeException("java.lang.AbstractMethodError");
        }
        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);

    }
}
