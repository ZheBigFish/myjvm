package com.ziyu.jvm.ch06.instructions.comparisons;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dcmp extends NoOperandsInstruction {
    public void dcmp(Frame frame, boolean b) {
        double i1 = frame.getOperandStack().popDouble();
        double i2 = frame.getOperandStack().popDouble();
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
