package com.ziyu.jvm.ch06.instructions.base;

import com.ziyu.jvm.ch06.rtda.Frame;

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
