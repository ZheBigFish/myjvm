package com.ziyu.jvm.ch07.instructions.constants;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName Nop
 * @Date
 * @Author
 * @Description TODO
 **/
public class Nop extends NoOperandsInstruction {
    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    public void execute(Frame frame) {

    }
}
