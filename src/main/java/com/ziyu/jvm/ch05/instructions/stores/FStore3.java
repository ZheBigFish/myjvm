package com.ziyu.jvm.ch05.instructions.stores;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class FStore3 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FStore.fStore(frame, 3);
    }
}
