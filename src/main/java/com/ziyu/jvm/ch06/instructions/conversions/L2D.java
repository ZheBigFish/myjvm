package com.ziyu.jvm.ch06.instructions.conversions;

import com.ziyu.jvm.ch06.instructions.base.Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class L2D extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushDouble( frame.getOperandStack().popLong().doubleValue());
    }
}
