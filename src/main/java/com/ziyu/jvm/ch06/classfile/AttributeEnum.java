package com.ziyu.jvm.ch06.classfile;

public enum AttributeEnum {
  // Five attributes are critical to correct interpretation of the class file by the Java Virtual Machine:
   ConstantValue("ConstantValue"),
  Code("Code"),
  StackMapTable("StackMapTable"),
  Exceptions("Exceptions"),
  BootstrapMethods("BootstrapMethods"),

  // Twelve attributes are critical to correct interpretation of the class file by the class libraries of the Java SE platform:
  InnerClasses("InnerClasses"),
  EnclosingMethod("EnclosingMethod"),
  Synthetic("Synthetic"),
  Signature("Signature"),
  RuntimeVisibleAnnotations("RuntimeVisibleAnnotations"),
  RuntimeInvisibleAnnotations("RuntimeInvisibleAnnotations"),
  RuntimeVisibleParameterAnnotations("RuntimeVisibleParameterAnnotations"),
  RuntimeInvisibleParameterAnnotations("RuntimeInvisibleParameterAnnotations"),
  RuntimeVisibleTypeAnnotations("RuntimeVisibleTypeAnnotations"),
  RuntimeInvisibleTypeAnnotations("RuntimeInvisibleTypeAnnotations"),
  AnnotationDefault("AnnotationDefault"),
  MethodParameters("MethodParameters"),

  //  Six attributes are not critical to correct interpretation of the class file by either the Java Virtual Machine or the class libraries of the Java SE platform, but are useful for tools:
  SourceFile("SourceFile"),
  SourceDebugExtension("SourceDebugExtension"),
  LineNumberTable("LineNumberTable"),
  LocalVariableTable("LocalVariableTable"),
  LocalVariableTypeTable("LocalVariableTypeTable"),
  Deprecated("Deprecated"),
  ;

    String value;

    AttributeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AttributeEnum of(String value) {
        for (AttributeEnum constantPoolInfoEnum : AttributeEnum.values()) {
            if (constantPoolInfoEnum.value.equals(value)) {
                return constantPoolInfoEnum;
            }
        }
        System.out.println("no AttributeEnum: " + value);
        return null;
    }
}