package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

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
