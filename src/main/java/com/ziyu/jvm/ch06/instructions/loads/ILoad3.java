package com.ziyu.jvm.ch06.instructions.loads;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName ILoad1
 * @Date
 * @Author
 * @Description TODO
 **/
public class ILoad3 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        ILoad.iLoad(frame, 3);
    }
}
