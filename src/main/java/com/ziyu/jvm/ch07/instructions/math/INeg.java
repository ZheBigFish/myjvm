package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class INeg extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        frame.getOperandStack().pushInt(-i1);
    }
}
