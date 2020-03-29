package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class IDiv extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        frame.getOperandStack().pushInt(i2 / i1);
    }
}
