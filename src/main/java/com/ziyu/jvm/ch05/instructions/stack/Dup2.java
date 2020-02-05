package com.ziyu.jvm.ch05.instructions.stack;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class Dup2 extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        throw new RuntimeException("该指令暂未实现:" + this.getClass());
    }
}
