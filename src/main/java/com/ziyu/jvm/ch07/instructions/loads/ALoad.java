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
public class ALoad extends Index8Instruction {

    public static void aLoad(Frame frame, int index){
        frame.getOperandStack().pushRef(frame.getLocalVars().getRef(index));
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        aLoad(frame, index);
    }
}
