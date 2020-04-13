package com.ziyu.jvm.ch07.instructions.loads;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.Index8Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName ILoad
 * @Date
 * @Author
 * @Description TODO
 **/
public class DLoad extends Index8Instruction {

    public static void dLoad(Frame frame, int index){
        frame.getOperandStack().pushDouble(frame.getLocalVars().getDouble(index));
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        dLoad(frame, index);
    }
}
