package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.instructions.base.MethodInvokeLogic;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.MethodRef;

/**
 * @ClassName Invokestatic
 * @Date
 * @Author
 * @Description TODO
 **/
public class Invokestatic extends Index16Instruction {

    @Override
    public void execute(Frame frame) {

        HeapConstantPool contantPool = frame.getMethod().getAClass().getContantPool();
        MethodRef methodRef = (MethodRef) contantPool.getConstant(index);
        Method method = methodRef.resolvedMethod();
        if (!method.isStatic()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        MethodInvokeLogic.invokeMethod(frame, method);
    }
}
