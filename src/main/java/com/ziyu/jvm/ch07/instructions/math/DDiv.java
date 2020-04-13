package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class DDiv extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        double i1 = frame.getOperandStack().popDouble();
        double i2 = frame.getOperandStack().popDouble();
        frame.getOperandStack().pushDouble(i2 / i1);
    }
}
