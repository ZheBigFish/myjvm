package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slots;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.FieldRef;

/**
 * @ClassName GetStatic
 * @Date
 * @Author
 * @Description TODO
 **/
public class GetStatic extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        HeapConstantPool contantPool = frame.getMethod().getAClass().getContantPool();
        FieldRef fieldRef = (FieldRef) contantPool.getConstant(this.index);
        Field field = fieldRef.resolvedField();
        if (!field.isStatic()){
            throw new RuntimeException();
        }
        Slots staticVars = field.getAClass().getStaticVars();
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                frame.getOperandStack().pushInt(staticVars.getInt(slotId));
                break;
            case "F":
                frame.getOperandStack().pushFloat(staticVars.getFloat(slotId));
                break;
            case "J":
                frame.getOperandStack().pushLong(staticVars.getLong(slotId));
                break;
            case "D":
                frame.getOperandStack().pushDouble(staticVars.getDouble(slotId));
                break;
            case "Ljava/io/PrintStream;":
            case "L":
                frame.getOperandStack().pushRef(staticVars.getRef(slotId));
                break;

        }
    }
}
