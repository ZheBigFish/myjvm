package com.ziyu.jvm.ch05.instructions.comparisons;

import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dcmpg extends Dcmp {
    @Override
    public void execute(Frame frame) {
        dcmp(frame, true);
    }
}
