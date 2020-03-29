package com.ziyu.jvm.ch06.instructions.stores;

import com.ziyu.jvm.ch06.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch06.instructions.base.Index8Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class FStore extends Index8Instruction {

    public static void fStore(Frame frame, int index){
        frame.getLocalVars().setFloat(index, frame.getOperandStack().popFloat());
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        fStore(frame, index);
    }
}
