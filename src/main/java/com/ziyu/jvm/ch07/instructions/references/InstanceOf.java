package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.ClassRef;

/**
 * @ClassName instanceOf
 * @Date
 * @Author
 * @Description TODO
 **/
public class InstanceOf extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        Object object = frame.getOperandStack().popRef();
        if (object == null){
            frame.getOperandStack().pushInt(0);
        }
        ClassRef classRef = (ClassRef) frame.getMethod().getAClass().getContantPool().getConstant(this.index);
        KClass kClass = classRef.resolvedClass();
        if (object.isInstanceOf(kClass)){
            frame.getOperandStack().pushInt(1);
        }else{
            frame.getOperandStack().pushInt(0);
        }
    }
}
