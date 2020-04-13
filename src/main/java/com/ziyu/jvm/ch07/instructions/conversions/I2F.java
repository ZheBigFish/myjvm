package com.ziyu.jvm.ch07.instructions.conversions;

import com.ziyu.jvm.ch07.instructions.base.Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class I2F extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushFloat((float) frame.getOperandStack().popInt());
    }
}
