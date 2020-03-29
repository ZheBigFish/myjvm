package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class LSub extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        long i1 = frame.getOperandStack().popLong();
        long i2 = frame.getOperandStack().popLong();
        frame.getOperandStack().pushLong(i2 - i1);
    }
}
