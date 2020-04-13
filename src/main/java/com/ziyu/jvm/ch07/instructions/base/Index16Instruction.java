package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName Index16Instruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class Index16Instruction extends Instruction {

    public int index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readUint16();
    }

    @Override
    public void execute(Frame frame) {

    }
}
