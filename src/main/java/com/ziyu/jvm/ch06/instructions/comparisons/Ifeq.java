package com.ziyu.jvm.ch06.instructions.comparisons;

import com.ziyu.jvm.ch06.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch06.instructions.base.BranchLogic;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName Ifeq
 * @Date
 * @Author
 * @Description TODO
 **/
public class Ifeq extends BranchInstruction {
    @Override
    public void execute(Frame frame) {
        if (frame.getOperandStack().popInt() == 0) {
            BranchLogic.branch(frame, offset);
        }
    }
}
