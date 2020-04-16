package com.ziyu.jvm.ch07.instructions.comparisons;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Lcmp extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        long i1 = frame.getOperandStack().popLong();
        long i2 = frame.getOperandStack().popLong();
        if (i2 > i1) {
            frame.getOperandStack().pushInt(1);
        }else if(i2 == i1) {
            frame.getOperandStack().pushInt(0);
        }else {
            frame.getOperandStack().pushInt(-1);
        }
    }
}
