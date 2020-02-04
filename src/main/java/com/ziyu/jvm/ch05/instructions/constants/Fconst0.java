package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName Dconst0
 * @Date
 * @Author
 * @Description TODO
 **/
public class Fconst0 extends Instruction{

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushFloat(0f);
    }
}
