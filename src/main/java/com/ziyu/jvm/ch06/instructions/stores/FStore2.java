package com.ziyu.jvm.ch06.instructions.stores;

import com.ziyu.jvm.ch06.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class FStore2 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FStore.fStore(frame, 2);
    }
}
