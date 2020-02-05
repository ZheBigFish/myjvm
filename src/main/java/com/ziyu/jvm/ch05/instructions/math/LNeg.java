package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class LNeg extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        long i1 = frame.getOperandStack().popLong();
        frame.getOperandStack().pushLong(-i1);
    }
}
