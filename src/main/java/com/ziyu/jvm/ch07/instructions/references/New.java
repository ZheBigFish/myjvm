package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.ClassRef;

/**
 * @ClassName New
 * @Date
 * @Author
 * @Description TODO
 **/
public class New extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        HeapConstantPool contantPool = frame.getMethod().getAClass().getContantPool();
        ClassRef constant = (ClassRef) contantPool.getConstant(this.index);
        KClass kClass = constant.resolvedClass();
        if (kClass.isInterface() || kClass.isAbstract()) {
            throw new RuntimeException("java.lang.InstantiationError");
        }
        frame.getOperandStack().pushRef(kClass.newObject());
    }
}
