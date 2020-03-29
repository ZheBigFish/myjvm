package com.ziyu.jvm.ch06.instructions.stack;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

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
