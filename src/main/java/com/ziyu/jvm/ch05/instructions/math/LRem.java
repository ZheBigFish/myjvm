package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class LRem extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        long i2 = frame.getOperandStack().popLong();
        long i1 = frame.getOperandStack().popLong();
        if (i2 == 0) {
            throw new RuntimeException("java.lang.ArithmeticException");
        }
        frame.getOperandStack().pushLong(i1 % i2);
    }
}
