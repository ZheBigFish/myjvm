package com.ziyu.jvm.ch07.instructions.control;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName Return
 * @Date
 * @Author
 * @Description TODO
 **/
public class Return extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        frame.getThread().popFrame();
    }
}
