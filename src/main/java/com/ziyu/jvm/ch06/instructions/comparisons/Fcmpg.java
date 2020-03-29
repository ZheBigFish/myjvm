package com.ziyu.jvm.ch06.instructions.comparisons;

import com.ziyu.jvm.ch06.rtda.Frame;

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
