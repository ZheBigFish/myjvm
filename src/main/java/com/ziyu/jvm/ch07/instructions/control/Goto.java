package com.ziyu.jvm.ch07.instructions.control;

import com.ziyu.jvm.ch07.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch07.instructions.base.BranchLogic;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName Goto
 * @Date
 * @Author
 * @Description TODO
 **/
public class Goto extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        BranchLogic.branch(frame, offset);
    }

}
