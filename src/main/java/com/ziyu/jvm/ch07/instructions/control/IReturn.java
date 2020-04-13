package com.ziyu.jvm.ch07.instructions.control;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Thread;

/**
 * @ClassName Return
 * @Date
 * @Author
 * @Description TODO
 **/
public class IReturn extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.getThread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        int i = currentFrame.getOperandStack().popInt();
        invokerFrame.getOperandStack().pushInt(i);
    }
}
