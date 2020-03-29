package com.ziyu.jvm.ch06.instructions.constants;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName IconstM1
 * @Date
 * @Author
 * @Description TODO
 **/
public class Iconst3 extends NoOperandsInstruction {

    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(3);
    }
}
