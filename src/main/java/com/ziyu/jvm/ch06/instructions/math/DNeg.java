package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class DNeg extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        Double i1 = frame.getOperandStack().popDouble();
        frame.getOperandStack().pushDouble(-i1);
    }
}
