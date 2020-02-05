package com.ziyu.jvm.ch05.instructions.stores;

import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.instructions.base.Index8Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class DStore extends Index8Instruction {

    public static void dStore(Frame frame, int index){
        frame.getLocalVars().setDouble(index, frame.getOperandStack().popDouble());
    }

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.index = bytecodeReader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        dStore(frame, index);
    }
}
