package com.ziyu.jvm.ch07.instructions.comparisons;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Fcmp extends NoOperandsInstruction {
    public void fcmp(Frame frame, boolean b) {
        float i1 = frame.getOperandStack().popFloat();
        float i2 = frame.getOperandStack().popFloat();
        if (i2 > i1) {
            frame.getOperandStack().pushInt(1);
        }else if(i2 == i1) {
            frame.getOperandStack().pushInt(0);
        }else if (i2 < i1) {
            frame.getOperandStack().pushInt(-1);
        }else if (b) {
            frame.getOperandStack().pushInt(1);
        }else {
            frame.getOperandStack().pushInt(-1);
        }
    }
}
