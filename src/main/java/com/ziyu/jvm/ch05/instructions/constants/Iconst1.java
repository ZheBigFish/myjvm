package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IconstM1
 * @Date
 * @Author
 * @Description TODO
 **/
public class Iconst1 extends NoOperandsInstruction {

    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(1);
    }
}
