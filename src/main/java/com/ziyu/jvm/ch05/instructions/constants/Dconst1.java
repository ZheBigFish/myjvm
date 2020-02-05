package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

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
