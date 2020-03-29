package com.ziyu.jvm.ch06.instructions.constants;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName IconstM1
 * @Date
 * @Author
 * @Description TODO
 **/
public class Lconst0 extends NoOperandsInstruction {

    public void execute(Frame frame) {
        frame.getOperandStack().pushLong(0L);
    }
}
