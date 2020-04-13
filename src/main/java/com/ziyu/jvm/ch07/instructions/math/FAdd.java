package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class FAdd extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        float i1 = frame.getOperandStack().popFloat();
        float i2 = frame.getOperandStack().popFloat();
        frame.getOperandStack().pushFloat(i1 + i2);
    }
}
