package com.ziyu.jvm.ch06.instructions.stack;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

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
