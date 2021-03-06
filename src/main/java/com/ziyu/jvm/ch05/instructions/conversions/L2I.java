package com.ziyu.jvm.ch05.instructions.conversions;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class L2I extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt( frame.getOperandStack().popLong().intValue());
    }
}
