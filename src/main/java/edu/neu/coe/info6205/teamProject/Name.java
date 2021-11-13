package edu.neu.coe.info6205.teamProject;


import net.sourceforge.pinyin4j.PinyinHelper;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Name {
    String name;
    String pinyin;

    public Name(){
        this.name = null;
        this.pinyin = null;
    }

    public Name(String name){
        this.name = name;
        this.pinyin = PinYinUtils.toPinYin(this.name);
    }


    public String toString(){
        return this.name;
    }

}
