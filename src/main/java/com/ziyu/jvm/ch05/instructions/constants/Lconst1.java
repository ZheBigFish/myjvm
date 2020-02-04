package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IconstM1
 * @Date
 * @Author
 * @Description TODO
 **/
public class Lconst1 extends Instruction{

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushLong(1L);
    }
}
