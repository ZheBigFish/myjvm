package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class DAdd extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        double i1 = frame.getOperandStack().popDouble();
        double i2 = frame.getOperandStack().popDouble();
        frame.getOperandStack().pushDouble(i1 + i2);
    }
}
