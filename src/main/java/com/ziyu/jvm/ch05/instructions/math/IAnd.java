package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class IAnd extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        frame.getOperandStack().pushInt(i2 & i1);
    }
}
