package com.ziyu.jvm.ch07.classfile;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Fields
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Fields {

    short fieldCount;
    List<FieldInfo> field;

}


