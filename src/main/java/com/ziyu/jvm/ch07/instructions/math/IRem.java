package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class IRem extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        int i2 = frame.getOperandStack().popInt();
        int i1 = frame.getOperandStack().popInt();
        if (i2 == 0) {
            throw new RuntimeException("java.lang.ArithmeticException");
        }
        frame.getOperandStack().pushInt(i1 % i2);
    }
}
