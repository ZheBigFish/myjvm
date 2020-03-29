package com.ziyu.jvm.ch06.instructions.references;

import com.ziyu.jvm.ch06.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.Slot;
import com.ziyu.jvm.ch06.rtda.Slots;
import com.ziyu.jvm.ch06.rtda.heap.Object;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.FieldRef;

/**
 * @ClassName PutField
 * @Date
 * @Author
 * @Description TODO
 **/
public class PutField extends Index16Instruction {

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
        if (field.isFinal()){
            if (currentClass != aClass || !currentMethod.getName().equals("<init>")){
                throw new RuntimeException();
            }
        }
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Object object = frame.getOperandStack().popRef();
        if (object == null){
            throw new RuntimeException("NullPoint");
        }
        // TODO: 2020/3/29  目前实例变量没有初始化Slots，在这里先判空处理
        if (object.getAClass().getFields().get(slotId).slots == null) {
            object.getAClass().getFields().get(slotId).slots = Slots.newSlots(object.getAClass().getInstanceSlotCount()).getSlotArray();
        }
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                object.getAClass().getFields().get(slotId).setInt(0, frame.getOperandStack().popInt());
                break;
            case "F":
                object.getAClass().getFields().get(slotId).setFloat(0, frame.getOperandStack().popFloat());
                break;
            case "J":
                object.getAClass().getFields().get(slotId).setLong(0, frame.getOperandStack().popLong());
                break;
            case "D":
                object.getAClass().getFields().get(slotId).setDouble(0, frame.getOperandStack().popDouble());
                break;
            case "L":
                object.getAClass().getFields().get(slotId).setRef(0, frame.getOperandStack().popRef());
                break;

        }
    }
}
