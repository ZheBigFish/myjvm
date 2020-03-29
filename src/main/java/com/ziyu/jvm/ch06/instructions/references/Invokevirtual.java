package com.ziyu.jvm.ch06.instructions.references;

import com.ziyu.jvm.ch06.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.OperandStack;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.MethodRef;

/**
 * @ClassName Invokevirtual
 * @Date
 * @Author
 * @Description TODO
 **/
public class Invokevirtual extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        MethodRef methodRef = (MethodRef) frame.getMethod().getAClass().getContantPool().getConstant(index);
        if (methodRef.getName().equals("println")) {
            OperandStack operandStack = frame.getOperandStack();
            switch (methodRef.getDescriptor()) {
                case "(Z)V":
                    System.out.println(operandStack.popInt() != 0);
                    break;
                case "(C)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(B)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(S)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(I)V":
                    System.out.println(operandStack.popInt());
                    break;
                case "(J)V":
                    System.out.println(operandStack.popLong());
                    break;
                case "(F)V":
                    System.out.println(operandStack.popFloat());
                    break;
                case "(D)V":
                    System.out.println(operandStack.popDouble());
                    break;
                default:
                    System.out.println("println: " + methodRef.getDescriptor());
            }
            operandStack.popRef();
        }
    }
}
