package edu.neu.coe.info6205.teamProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Initalize {

    public static void init(List<Name> names){
        try(BufferedReader inLine = new BufferedReader(new FileReader("src/main/java/edu/neu/coe/info6205/teamProject/shuffledChinese.txt"));){
            String in = null;

            while((in = inLine.readLine()) != null) {
                names.add(new Name(in));
            }
        }catch(Exception e) {
            System.out.println("Caught an ERROR!");
            e.printStackTrace();
        }
    }

}
