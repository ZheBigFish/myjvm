package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;

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
        if (this instanceof Return) {
            frame.getThread().popFrame();
        }
    }
}
