package com.ziyu.jvm.ch07.instructions.constants;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName LdcW
 * @Date
 * @Author
 * @Description TODO
 **/
public class LdcW2 extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        Object constant = frame.getMethod().getAClass().getContantPool().getConstant(index);
        if (constant instanceof Long){
            frame.getOperandStack().pushLong((Long) constant);
        }else if (constant instanceof Double){
            frame.getOperandStack().pushDouble((Double) constant);
        }else{
            throw new RuntimeException();
        }
    }

}
