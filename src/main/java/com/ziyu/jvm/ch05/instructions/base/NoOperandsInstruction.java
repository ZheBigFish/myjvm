package com.ziyu.jvm.ch05.instructions.base;

import com.ziyu.jvm.ch05.rtda.Frame;

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
