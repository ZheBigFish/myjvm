package com.ziyu.jvm.ch07.instructions.constants;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName IconstM1
 * @Date
 * @Author
 * @Description TODO
 **/
public class Lconst1 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushLong(1L);
    }
}
