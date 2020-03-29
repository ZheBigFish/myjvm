package com.ziyu.jvm.ch06.rtda.heap;

import com.ziyu.jvm.ch04.Slots;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;
import lombok.Data;

/**
 * @ClassName Object
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Object {

    KClass aClass;
    Slots slots;

    public Object(KClass aClass) {
        this.aClass = aClass;
        this.slots = new Slots(aClass.instanceSlotCount);
    }

    public boolean isInstanceOf(KClass kClass){
        return kClass.isAssignableFrom(kClass);
    }
}
