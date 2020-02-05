package com.ziyu.jvm.ch05.instructions.conversions;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName d2x
 * @Date
 * @Author
 * @Description TODO
 **/
public class I2S extends Instruction {
    @Override
    public void execute(Frame frame) {
        throw new RuntimeException("该指令暂未实现:" + this.getClass());
    }
}
