package com.ziyu.jvm.ch07.instructions.stores;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.Index8Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class AStore extends Index8Instruction {

    public static void aStore(Frame frame, int index){
        frame.getLocalVars().setRef(index, frame.getOperandStack().popRef());
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        aStore(frame, index);
    }
}
