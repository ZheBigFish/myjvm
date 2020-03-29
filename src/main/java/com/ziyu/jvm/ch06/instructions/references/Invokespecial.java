package com.ziyu.jvm.ch06.instructions.references;

import com.ziyu.jvm.ch06.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName Invokespecial
 * @Date
 * @Author
 * @Description TODO
 **/
public class Invokespecial extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().popRef();
    }
}
