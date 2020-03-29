package com.ziyu.jvm.ch06.instructions.references;

import com.ziyu.jvm.ch06.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.heap.Object;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.ClassRef;

/**
 * @ClassName CheckCast
 * @Date
 * @Author
 * @Description TODO
 **/
public class CheckCast extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        Object object = frame.getOperandStack().popRef();
        frame.getOperandStack().pushRef(object);
        if (object == null){
            frame.getOperandStack().pushInt(0);
        }
        ClassRef classRef = (ClassRef) frame.getMethod().getAClass().getContantPool().getConstant(this.index);
        KClass kClass = classRef.resolvedClass();
        if (!object.isInstanceOf(kClass)){
            throw new RuntimeException("");
        }
    }
}
