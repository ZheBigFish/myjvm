package com.ziyu.jvm.ch06.rtda;

import com.ziyu.jvm.ch06.rtda.heap.Object;
import lombok.Data;

@Data
public class Slots {
    Slot[] slotArray;

    public static Slots newSlots(int count){
        Slots slots = new Slots();
        slots.slotArray = new Slot[count];
        for (int i = 0; i < slots.slotArray.length; i++) {
            slots.slotArray[i] = new Slot();
        }
        return slots;
    }

    public void setInt(int index, int val){
        this.slotArray[index].num = val;
    }

    public int getInt(int index){
        return slotArray[index].num;
    }

    public void setFloat(int index, Float val){
        this.slotArray[index].num = val.intValue();
    }

    public Float getFloat(int index){
        return Float.parseFloat(String.valueOf(slotArray[index].num));
    }

    public void setLong(int index, Long val){
        slotArray[index].num = (int) (val & 0x000000ffffffffL);
        slotArray[index + 1].num = (int) (val >> 32);
    }

    public Long getLong(int index){
        int low = slotArray[index].num;
        int high = slotArray[index + 1].num;

        return (long) ((high & 0x000000ffffffffL) << 32 | low & 0x00000000ffffffffL);
    }

    public void setDouble(int index, Double val){
        setLong(index, new Double(val).longValue());
    }

    public Double getDouble(int index){
        return (double) getLong(index);
    }

    public void setRef(int index, Object val){
        slotArray[index].ref = val;
    }

    public Object getRef(int index){
        return slotArray[index].ref;
    }

}

