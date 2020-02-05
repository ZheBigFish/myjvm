package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class IRem extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        int i2 = frame.getOperandStack().popInt();
        int i1 = frame.getOperandStack().popInt();
        if (i2 == 0) {
            throw new RuntimeException("java.lang.ArithmeticException");
        }
        frame.getOperandStack().pushInt(i1 % i2);
    }
}
