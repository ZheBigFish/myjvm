package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class IOr extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        frame.getOperandStack().pushInt(i2 | i1);
    }
}
