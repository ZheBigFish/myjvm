package com.ziyu.jvm.ch06.instructions.constants;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName Dconst0
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dconst1 extends NoOperandsInstruction {

    public void execute(Frame frame) {
        frame.getOperandStack().pushDouble(1.0);
    }
}
