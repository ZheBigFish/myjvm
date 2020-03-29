package com.ziyu.jvm.ch06.instructions.base;

import com.ziyu.jvm.ch06.rtda.Frame;

/**
 * @InterfaceName instruction
 * @Date
 * @Author
 * @Description TODO
 **/
public class Instruction {

    public void fetchOperands(BytecodeReader bytecodeReader){};
    public void execute(Frame frame){};

}
