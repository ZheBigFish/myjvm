package com.ziyu.jvm.ch07.classfile;

import com.ziyu.jvm.ch07.classfile.attribute.CodeAttribute;
import lombok.Data;

@Data
public class MethodInfo extends ConstantMemberRef {

    CodeAttribute codeAttribute;

}