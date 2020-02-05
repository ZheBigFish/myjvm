package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class DSub extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        double i1 = frame.getOperandStack().popDouble();
        double i2 = frame.getOperandStack().popDouble();
        frame.getOperandStack().pushDouble(i2 - i1);
    }
}
