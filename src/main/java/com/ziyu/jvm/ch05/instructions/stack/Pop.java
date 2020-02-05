package com.ziyu.jvm.ch05.instructions.stack;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class Pop extends NoOperandsInstruction {
    public void execute(Frame frame) {
        frame.getOperandStack().popSlot();
    }
}
