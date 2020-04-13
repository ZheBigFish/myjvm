package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.instructions.base.Instruction;
import com.ziyu.jvm.ch07.instructions.base.MethodInvokeLogic;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.heap.MethodLookup;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.InterfaceMethodRef;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.MethodRef;

/**
 * @ClassName invokeinterface
 * @Date
 * @Author
 * @Description TODO
 **/
public class invokeinterface extends Index16Instruction {

    short argSlotCount;
    short zero;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        super.fetchOperands(bytecodeReader);
        bytecodeReader.readInt8();
        bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        KClass currentClass = frame.getMethod().getAClass();
        HeapConstantPool contantPool = currentClass.getContantPool();
        InterfaceMethodRef methodRef = (InterfaceMethodRef) contantPool.getConstant(index);
        Method method = methodRef.resolvedInterfaceMethod();
        if (method.isStatic() || method.isPrivate()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        //获取this引用
        Object o = frame.getOperandStack().getRefFromTop(method.getArgSlotCount());
        if (o == null) {
            throw new RuntimeException("java.lang.NullPointerException");
        }
        if (o.getAClass().isImplements(methodRef.resolvedClass())) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        Method methodToBeInvoked = MethodLookup.lookUpMethodInClass(o.getAClass(), methodRef.getName(), methodRef.getDescriptor());
        if (methodToBeInvoked == null || methodToBeInvoked.isAbstract()) {
            throw new RuntimeException("java.lang.AbstractMethodError");
        }
        if (!methodToBeInvoked.isPublic()) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
    }
}
