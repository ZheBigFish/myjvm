package com.ziyu.jvm.ch05.instructions.extended;

import com.ziyu.jvm.ch05.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch05.instructions.base.BranchLogic;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IfNull
 * @Date
 * @Author
 * @Description TODO
 **/
public class IfNotNull extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        if (frame.getOperandStack().popRef() != null){
            BranchLogic.branch(frame, offset);
        }
    }
}
