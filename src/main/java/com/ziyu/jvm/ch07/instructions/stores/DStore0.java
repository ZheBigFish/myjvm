package com.ziyu.jvm.ch07.instructions.stores;

import com.ziyu.jvm.ch07.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch07.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class DStore0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        DStore.dStore(frame, 0);
    }
}
