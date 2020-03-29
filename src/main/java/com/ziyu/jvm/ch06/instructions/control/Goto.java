package com.ziyu.jvm.ch06.instructions.control;

import com.ziyu.jvm.ch06.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch06.instructions.base.BranchLogic;
import com.ziyu.jvm.ch06.rtda.Frame;

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
