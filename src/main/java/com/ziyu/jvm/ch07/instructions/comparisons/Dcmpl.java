package com.ziyu.jvm.ch07.instructions.comparisons;

import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName lcmp
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dcmpl extends Dcmp {
    @Override
    public void execute(Frame frame) {
        dcmp(frame, false);
    }
}
