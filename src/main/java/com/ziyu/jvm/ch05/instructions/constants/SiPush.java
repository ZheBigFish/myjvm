package com.ziyu.jvm.ch05.instructions.constants;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

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
