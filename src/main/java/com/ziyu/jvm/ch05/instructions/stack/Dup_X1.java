package com.ziyu.jvm.ch05.instructions.stack;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description 复制操作数栈栈顶的值， 并将此值入栈到操作数栈顶以下两个值之后
 *
 *操作数栈:      … ， value2, value1—►  pop后
 *操作数栈:      … value1 value2, value1
 **/
public class Dup_X1 extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        Slot slot1 = frame.getOperandStack().popSlot();
        Slot slot2 = frame.getOperandStack().popSlot();
        frame.getOperandStack().pushSlot(slot1);
        frame.getOperandStack().pushSlot(slot2);
        frame.getOperandStack().pushSlot(slot1);
    }
}
