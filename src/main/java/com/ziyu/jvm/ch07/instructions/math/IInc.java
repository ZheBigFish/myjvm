package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName iinc
 * @Date
 * @Author
 * @Description TODO
 **/
public class IInc extends Instruction {

    int val;
    int index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader){
        this.index = bytecodeReader.readInt8();
        this.val = bytecodeReader.readInt8();
    };

    @Override
    public void execute(Frame frame){
        int anInt = frame.getLocalVars().getInt(index);
        anInt += val;
        frame.getLocalVars().setInt(index, anInt);
    };

}
