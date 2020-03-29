package com.ziyu.jvm.ch06.instructions.base;

import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName NoOperandsInstruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class NoOperandsInstruction extends Instruction {
    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        // nothing to do
    }

    @Override
    public void execute(Frame frame) {

    }
}
