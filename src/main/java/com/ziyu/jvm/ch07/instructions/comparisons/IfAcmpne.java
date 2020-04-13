package com.ziyu.jvm.ch07.instructions.comparisons;

import com.ziyu.jvm.ch07.instructions.base.BranchInstruction;
import com.ziyu.jvm.ch07.instructions.base.BranchLogic;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName IFIcmpgt
 * @Date
 * @Author
 * @Description TODO
 **/
public class IfAcmpne extends BranchInstruction {

    @Override
    public void execute(Frame frame){
        Object i1 = frame.getOperandStack().popRef();
        Object i2 = frame.getOperandStack().popRef();
        if (i2 != i1) {
            BranchLogic.branch(frame, offset);
        }
    }

}
