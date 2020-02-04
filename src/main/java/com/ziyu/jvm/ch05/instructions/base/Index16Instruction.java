package com.ziyu.jvm.ch05.instructions.base;

import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName Index16Instruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class Index16Instruction extends Instruction {

    int index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readUint16();
    }

    @Override
    public void execute(Frame frame) {

    }
}
