package com.ziyu.jvm.ch07.instructions.constants;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName AconstNull
 * @Date
 * @Author
 * @Description TODO
 **/
public class AconstNull extends NoOperandsInstruction {

    public void execute(Frame frame) {
        frame.getOperandStack().pushRef(null);
    }
}
