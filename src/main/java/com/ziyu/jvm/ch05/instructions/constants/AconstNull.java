package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

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
