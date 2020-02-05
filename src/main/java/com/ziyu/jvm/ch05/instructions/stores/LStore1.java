package com.ziyu.jvm.ch05.instructions.stores;

import com.ziyu.jvm.ch05.instructions.base.NoOperandsInstruction;
import com.ziyu.jvm.ch05.rtda.Frame;

/**
 * @ClassName IStore
 * @Date
 * @Author
 * @Description TODO
 **/
public class LStore1 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        LStore.lStore(frame, 1);
    }
}
