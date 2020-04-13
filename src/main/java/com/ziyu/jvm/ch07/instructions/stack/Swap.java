package com.ziyu.jvm.ch07.instructions.stack;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class Swap extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        Slot slot1 = frame.getOperandStack().popSlot();
        Slot slot2 = frame.getOperandStack().popSlot();
        frame.getOperandStack().pushSlot(slot1);
        frame.getOperandStack().pushSlot(slot2);
    }
}
