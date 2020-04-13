package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName iinc
 * @Date
 * @Author
 * @Description TODO
 **/
public class IShl extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame){
        int i2 = frame.getOperandStack().popInt();
        int i1 = frame.getOperandStack().popInt();
        i1 = i1 << i2;
        frame.getOperandStack().pushInt(i1);
    };

}
