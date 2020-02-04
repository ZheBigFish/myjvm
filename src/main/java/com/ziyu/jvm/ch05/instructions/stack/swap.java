package com.ziyu.jvm.ch05.instructions.stack;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class swap extends Instruction {
    public void execute(Frame frame) {
        Slot slot1 = frame.getOperandStack().popSlot();
        Slot slot2 = frame.getOperandStack().popSlot();
        frame.getOperandStack().pushSlot(slot1);
        frame.getOperandStack().pushSlot(slot2);
    }
}
