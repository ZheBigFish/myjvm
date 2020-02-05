package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class FNeg extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        float i1 = frame.getOperandStack().popFloat();
        frame.getOperandStack().pushFloat(-i1);
    }
}
