package com.ziyu.jvm.ch07.instructions.math;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

import java.math.BigDecimal;

/**
 * @ClassName pop
 * @Date
 * @Author
 * @Description TODO
 **/
public class DRem extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        Double i2 = frame.getOperandStack().popDouble();
        Double i1 = frame.getOperandStack().popDouble();
        double val = i1 % i2;
        BigDecimal bd = new BigDecimal(val);
        val = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        frame.getOperandStack().pushDouble(val);
    }
}
