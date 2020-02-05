package com.ziyu.jvm.ch05.instructions.stack;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;
import com.ziyu.jvm.ch05.rtda.Slot;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description 复制操作数栈栈顶的值， 并将此值入栈到操作数栈顶以下两个值之后
 *
 *操作数栈:      … ， value2, value1—►  pop后
 *操作数栈:      … value1 value2, value1
 **/
public class Dup_X2 extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        throw new RuntimeException("该指令暂未实现:" + this.getClass());
    }
}
