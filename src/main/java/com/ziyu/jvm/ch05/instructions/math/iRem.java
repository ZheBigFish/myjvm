package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class iRem extends Instruction {

    @Override
    public void execute(Frame frame) {
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        if (i2 == 0) {
            System.out.println("java.lang.ArithmeticException");
            System.exit(0);
        }
        frame.getOperandStack().pushInt(i1 % i2);
    }
}
