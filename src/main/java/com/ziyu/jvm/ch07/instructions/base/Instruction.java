package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;

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
