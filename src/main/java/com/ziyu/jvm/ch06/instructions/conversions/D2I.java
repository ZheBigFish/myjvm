package com.ziyu.jvm.ch06.instructions.conversions;

import com.ziyu.jvm.ch06.instructions.base.Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class D2I extends Instruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(frame.getOperandStack().popDouble().intValue());
    }
}
