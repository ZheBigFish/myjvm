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
public class LLoad extends Index8Instruction {

    public static void lLoad(Frame frame, int index){
        frame.getOperandStack().pushLong(frame.getLocalVars().getLong(index));
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        lLoad(frame, index);
    }
}
