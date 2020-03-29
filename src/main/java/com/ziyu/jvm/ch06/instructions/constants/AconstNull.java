package com.ziyu.jvm.ch06.instructions.constants;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

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
