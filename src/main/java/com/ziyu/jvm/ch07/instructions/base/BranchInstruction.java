package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName BranchInstruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class BranchInstruction extends Instruction {

    public int offset;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.offset = bytecodeReader.readUint16();
    }

    @Override
    public void execute(Frame frame) {

    }

}
