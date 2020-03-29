package com.ziyu.jvm.ch06.instructions.math;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName iinc
 * @Date
 * @Author
 * @Description TODO
 **/
public class IShr extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        throw new RuntimeException("该指令暂未实现:" + this.getClass());
    }

}
