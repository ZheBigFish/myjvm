package com.ziyu.jvm.ch06.instructions.extended;

import com.ziyu.jvm.ch06.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch06.instructions.base.BranchLogic;
import com.ziyu.jvm.ch06.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName Goto
 * @Date
 * @Author
 * @Description TODO
 **/
public class GotoW extends BranchInstruction {

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.offset = bytecodeReader.readUint32();
    }

    @Override
    public void execute(Frame frame) {
        BranchLogic.branch(frame, offset);
    }

}
