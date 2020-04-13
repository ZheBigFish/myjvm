package com.ziyu.jvm.ch07.instructions.constants;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName BiPush
 * @Date
 * @Author
 * @Description TODO
 **/
public class SiPush extends NoOperandsInstruction {

    int val;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        val = bytecodeReader.readUint16();
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(val);
    }
}
