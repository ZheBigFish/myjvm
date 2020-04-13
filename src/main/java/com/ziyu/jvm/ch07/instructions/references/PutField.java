package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slots;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.FieldRef;

import javax.lang.model.util.ElementScanner6;

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
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                int val = frame.getOperandStack().popInt();
                Object object = frame.getOperandStack().popRef();
                common(object, slotId);
                object.getAClass().getFields().get(slotId).setInt(0, val);
                break;
            case "F":
                Float aFloat = frame.getOperandStack().popFloat();
                object = frame.getOperandStack().popRef();
                common(object, slotId);
                object.getAClass().getFields().get(slotId).setFloat(0, aFloat);
                break;
            case "J":
                Long aLong = frame.getOperandStack().popLong();
                object = frame.getOperandStack().popRef();
                common(object, slotId);
                object.getAClass().getFields().get(slotId).setLong(0, aLong);
                break;
            case "D":
                Double aDouble = frame.getOperandStack().popDouble();
                object = frame.getOperandStack().popRef();
                common(object, slotId);
                object.getAClass().getFields().get(slotId).setDouble(0, aDouble);
                break;
            case "L":
                Object object1 = frame.getOperandStack().popRef();
                object = frame.getOperandStack().popRef();
                common(object, slotId);
                object.getAClass().getFields().get(slotId).setRef(0, object1);
                break;
            default:
                frame.getOperandStack().popSlot();
                frame.getOperandStack().popSlot();
        }
    }

    public void common(Object object, int slotId) {
        if (object == null){
            throw new RuntimeException("NullPoint");
        }
        // TODO: 2020/3/29  目前实例变量没有初始化Slots，在这里先判空处理
        while (object.getAClass().getFields().size() <= slotId) {
            object.getAClass().getFields().add(new Field());
        }
        if (object.getAClass().getFields().get(slotId).slots == null) {
            object.getAClass().getFields().get(slotId).slots = Slots.newSlots(object.getAClass().getInstanceSlotCount()).getSlotArray();
        }
    }
}
