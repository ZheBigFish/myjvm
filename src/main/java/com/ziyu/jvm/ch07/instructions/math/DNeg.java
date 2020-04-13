package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

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
