package com.ziyu.jvm.ch05.instructions.loads;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Index8Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName ILoad
 * @Date
 * @Author
 * @Description TODO
 **/
public class FLoad extends Index8Instruction {

    public static void fLoad(Frame frame, int index){
        frame.getOperandStack().pushFloat(frame.getLocalVars().getFloat(index));
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        fLoad(frame, index);
    }
}
