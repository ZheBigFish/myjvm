package com.ziyu.jvm.ch05.instructions.extended;

import com.ziyu.jvm.ch05.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch05.instructions.base.BranchLogic;
import com.ziyu.jvm.ch05.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch05.rtda.Frame;

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
