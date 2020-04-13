package com.ziyu.jvm.ch07.instructions.stack;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slot;
import org.springframework.beans.BeanUtils;

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
        Slot slot1 = new Slot();
        BeanUtils.copyProperties(slot, slot1);
        frame.getOperandStack().pushSlot(slot);
        frame.getOperandStack().pushSlot(slot1);
    }
}
