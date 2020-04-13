package com.ziyu.jvm.ch07.instructions.conversions;

import com.ziyu.jvm.ch07.instructions.base.Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class F2L extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushLong(frame.getOperandStack().popFloat().longValue());
    }
}
