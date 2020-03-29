package com.ziyu.jvm.ch06.instructions.references;

import com.ziyu.jvm.ch06.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.heap.Object;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.FieldRef;

/**
 * @ClassName GetField
 * @Date
 * @Author
 * @Description TODO
 **/
public class GetField extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        HeapConstantPool contantPool = frame.getMethod().getAClass().getContantPool();
        FieldRef fieldRef = (FieldRef) contantPool.getConstant(this.index);
        Method currentMethod = frame.getMethod();
        KClass currentClass = currentMethod.getAClass();
        Field field = fieldRef.resolvedField();
        KClass aClass = field.getAClass();
        if (field.isStatic()){
            throw new RuntimeException();
        }
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Object object = frame.getOperandStack().popRef();
        if (object == null){
            throw new RuntimeException("NullPoint");
        }
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                frame.getOperandStack().pushInt(object.getAClass().getFields().get(slotId).getInt(0));
                break;
            case "F":
                frame.getOperandStack().pushFloat(object.getAClass().getFields().get(slotId).getFloat(0));
                break;
            case "J":
                frame.getOperandStack().pushLong(object.getAClass().getFields().get(slotId).getLong(0));
                break;
            case "D":
                frame.getOperandStack().pushDouble(object.getAClass().getFields().get(slotId).getDouble(0));
                break;
            case "L":
                frame.getOperandStack().pushRef(object.getAClass().getFields().get(slotId).getRef(0));
                break;

        }
    }
}
