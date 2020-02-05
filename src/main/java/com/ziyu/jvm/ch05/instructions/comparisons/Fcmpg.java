package com.ziyu.jvm.ch05.instructions.comparisons;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Fcmpg extends Fcmp {
    @Override
    public void execute(Frame frame) {
        fcmp(frame, true);
    }
}
