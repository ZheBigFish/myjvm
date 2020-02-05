package com.ziyu.jvm.ch05.instructions.comparisons;

import com.ziyu.jvm.ch05.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch05.instructions.base.BranchLogic;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IFIcmpgt
 * @Date
 * @Author
 * @Description TODO
 **/
public class IfIcmpeq extends BranchInstruction {

    @Override
    public void execute(Frame frame){
        int i1 = frame.getOperandStack().popInt();
        int i2 = frame.getOperandStack().popInt();
        if (i2 == i1) {
            BranchLogic.branch(frame, offset);
        }
    }

}
