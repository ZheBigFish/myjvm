package com.ziyu.jvm.ch07.rtda.heap.kclass;

import com.ziyu.jvm.ch07.classfile.ClassFile;
import com.ziyu.jvm.ch07.classfile.FieldInfo;
import com.ziyu.jvm.ch07.classfile.attribute.ConstantValue;
import com.ziyu.jvm.ch07.rtda.Slot;
import com.ziyu.jvm.ch07.rtda.heap.Object;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Fields
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Field extends ClassMember {

    public int slotId;
    public int constValueIndex;
    public Slot[] slots;

    public static List<Field> newFields(KClass aClass, ClassFile classFile){

        List<FieldInfo> fields = classFile.getFields().getField();
        List<Field> fields1 = new ArrayList<>();
        fields.forEach(a -> {
            Field field = new Field();
            field.aClass = aClass;
            field.copyMemberInfo(a);
            field.copyAttributes(aClass.contantPool, a);
            fields1.add(field);
        });

        return fields1;

    }

    public void copyAttributes(HeapConstantPool contantPool, FieldInfo field){
        ConstantValue constantValue = field.constantValueAttribute(contantPool);
        if (constantValue != null) {
            this.constValueIndex = constantValue.getConstantValueIndex();
        }
    }

    public void setInt(int index, int val){
        this.slots[index].num = val;
    }

    public int getInt(int index){
        return slots[index].num;
    }

    public void setFloat(int index, Float val){
        this.slots[index].num = val.intValue();
    }

    public Float getFloat(int index){
        return Float.parseFloat(String.valueOf(slots[index].num));
    }

    public void setLong(int index, Long val){
        slots[index].num = (int) (val & 0x000000ffffffffL);
        slots[index + 1].num = (int) (val >> 32);
    }

    public Long getLong(int index){
        int low = slots[index].num;
        int high = slots[index + 1].num;

        return (long) ((high & 0x000000ffffffffL) << 32 | low & 0x00000000ffffffffL);
    }

    public void setDouble(int index, Double val){
        setLong(index, new Double(val).longValue());
    }

    public Double getDouble(int index){
        return (double) getLong(index);
    }

    public void setRef(int index, Object val){
        slots[index].ref = val;
    }

    public Object getRef(int index){
        return slots[index].ref;
    }

}
