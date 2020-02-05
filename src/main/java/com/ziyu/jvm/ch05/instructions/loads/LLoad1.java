package com.ziyu.jvm.ch05.instructions.loads;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName ILoad1
 * @Date
 * @Author
 * @Description TODO
 **/
public class LLoad1 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        LLoad.lLoad(frame, 1);
    }
}
