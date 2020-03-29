package com.ziyu.jvm.ch06.instructions.base;

import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName Index8Instruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class Index8Instruction extends Instruction {

    public int index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readUint8();
    }

    @Override
    public void execute(Frame frame) {

    }
}
