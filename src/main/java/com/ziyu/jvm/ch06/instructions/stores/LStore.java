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
public class LStore extends Index8Instruction {

    public static void lStore(Frame frame, int index){
        frame.getLocalVars().setLong(index, frame.getOperandStack().popLong());
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        lStore(frame, index);
    }
}
