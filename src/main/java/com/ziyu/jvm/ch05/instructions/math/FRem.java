package com.ziyu.jvm.ch05.instructions.math;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

import java.math.BigDecimal;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class FRem extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        float i2 = frame.getOperandStack().popFloat();
        float i1 = frame.getOperandStack().popFloat();
        float val = i1 % i2;
        BigDecimal bd = new BigDecimal(val);
        val = bd.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        frame.getOperandStack().pushFloat(val);
    }
}
