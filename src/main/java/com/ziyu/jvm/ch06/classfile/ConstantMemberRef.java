package com.ziyu.jvm.ch06.classfile;

import com.ziyu.jvm.ch06.classfile.attribute.ConstantValue;
import com.ziyu.jvm.ch06.classfile.cp.Utf8Info;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ConstantMemberRef
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ConstantMemberRef {

    short accessFlags;
    String accessFlagsString;
    String name;
    String descriptorIndex;
    short attributesCount;
    List<Attribute> attributeInfo;

    public ConstantValue constantValueAttribute(HeapConstantPool contantPool){
        ConstantValue constantValue = null;
        if (attributesCount > 0) {
            for (int i = 0; i < this.attributeInfo.size(); i++) {
                Attribute attribute = this.attributeInfo.get(i);
                if (attribute instanceof ConstantValue) {
                    constantValue = (ConstantValue) attribute;
                }
            }
        }
        return constantValue;
    }

}
