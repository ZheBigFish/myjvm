package com.ziyu.jvm.ch07.classfile.classpath;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CompositeEntry Entry组合
 * @Date
 * @Author
 * @Description TODO
 **/
public class CompositeEntry extends Entry {

    List<Entry> entries;

    public CompositeEntry(String pathList) {
        String[] split = pathList.split(pathListSeparator);
        List<Entry> entries = new ArrayList<>();
        for (String s : split) {
            Entry entry = newEntry(s);
            entries.add(entry);
        }
        this.entries = entries;
    }

    @Override
    byte[] readClass(String className) {
        for (Entry entry : this.entries) {
            byte[] bytes = entry.readClass(className);
            if (bytes != null){
                return bytes;
            }
        }
        return null;
    }
}
