package com.ziyu.jvm.ch05.instructions.conversions;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class L2F extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushFloat( frame.getOperandStack().popLong().floatValue());
    }
}
