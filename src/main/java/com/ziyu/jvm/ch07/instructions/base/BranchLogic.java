package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName BranchLogic
 * @Date
 * @Author
 * @Description TODO
 **/
public class BranchLogic {

    public static void branch(Frame frame, int offset){
        int pc = frame.getThread().getPc();
        pc = pc + offset;
        frame.setNextPC(pc);
    }

}
