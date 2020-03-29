package com.ziyu.jvm.ch06.instructions.stack;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dup extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        Slot slot = frame.getOperandStack().popSlot();
        frame.getOperandStack().pushSlot(slot);
        frame.getOperandStack().pushSlot(slot);
    }
}
