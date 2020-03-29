package com.ziyu.jvm.ch06.classfile;

import com.ziyu.jvm.ch06.classfile.attribute.CodeAttribute;
import lombok.Data;

import java.util.List;

@Data
public class MethodInfo extends ConstantMemberRef {

    CodeAttribute codeAttribute;

}