package com.ziyu.jvm.ch07.instructions.stack;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

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
