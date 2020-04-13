package com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch07.classfile.MemberRefInfo;
import lombok.Data;

/**
 * @ClassName MemberRef
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class MemberRef extends Symref {

    String name;
    String descriptor;

    public void copyMemberRefInfo(MemberRefInfo constantMemberRef){
        String[] split = constantMemberRef.nameAndDescriptor().split("~");
        this.name = split[0];
        this.className = constantMemberRef.className();
        this.descriptor = split[1];
    }

}
