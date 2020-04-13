package com.ziyu.jvm.ch07.rtda.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName methodDescriptorParser
 * @Date
 * @Author
 * @Description 参数、返回值解析
 **/
public class MethodDescriptorParser {

    public static MethodDescriptor parseMethodDescriptor(String descriptor) {
        String[] chars = descriptor.split("");
        List<String> parameterTypes = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        String returnType = null;
        //todo 暂不考虑数组
        for (int i = 1; i < chars.length; i++) {
            if (")".equals(chars[i])) {
                returnType = parseReturnType(i + 1, chars);
                break;
            }
            if ("[".equals(chars[i])) {
                temp.append("[");
                continue;
            }
            if ("L".equals(chars[i])) {
                String substring = descriptor.substring(i, descriptor.length());
                String[] split = substring.split(";");
                temp.append(split[0]).append(";");
                parameterTypes.add(temp.toString());
                i += temp.length() - 1;
                temp = new StringBuffer();
            } else {
                parameterTypes.add(String.valueOf(chars[i]));
            }
        }
        String[] objects = new String[0];
        if (parameterTypes.size() > 0) {
            java.lang.Object[] objects1 = parameterTypes.toArray();
            objects = new String[objects1.length];
            for (int i = 0; i < objects1.length; i++) {
                objects[i] = objects1[i].toString();
            }
        }
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.parameterTypes = objects;
        methodDescriptor.returnType = returnType;
        return methodDescriptor;
    }

    public static String parseReturnType(int i, String[] chars) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i1 = i; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }

}
