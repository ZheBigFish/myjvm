package com.ziyu.jvm.ch07.instructions.loads;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName ILoad1
 * @Date
 * @Author
 * @Description TODO
 **/
public class FLoad0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FLoad.fLoad(frame, 0);
    }
}
