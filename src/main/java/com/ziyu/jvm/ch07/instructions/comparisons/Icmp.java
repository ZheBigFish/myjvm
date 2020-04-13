package com.ziyu.jvm.ch07.instructions.comparisons;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Icmp extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        if (i2 > i1) {
            frame.getOperandStack().pushInt(1);
        }else if(i2 == i1) {
            frame.getOperandStack().pushInt(0);
        }else {
            frame.getOperandStack().pushInt(-1);
        }
    }
}
