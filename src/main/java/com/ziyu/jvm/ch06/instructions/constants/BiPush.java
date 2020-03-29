package com.ziyu.jvm.ch06.instructions.constants;

import com.ziyu.jvm.ch06.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName BiPush
 * @Date
 * @Author
 * @Description TODO
 **/
public class BiPush extends NoOperandsInstruction {

    int val;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        val = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(val);
    }
}
