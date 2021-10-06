package edu.neu.coe.info6205.assignments.others;

import java.util.Arrays;

public class Playground {


    public static void sort(int[] ind, String[] ss, String[] t){
        for(int i = 0; i < ind.length; i++){
            for(int j = i + 1; j < ind.length; j++){
                if(ind[i] > ind[j]){
                    int tempi = ind[i];
                    ind[i] = ind[j];
                    ind[j] = tempi;

                    String temps = ss[i];
                    ss[i] = ss[j];
                    ss[j] = temps;

                    String tempt = t[i];
                    t[i] = t[j];
                    t[j] = tempt;
                }
            }
        }
    }


    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        sort(indices, sources, targets);
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for(int i = 0; i < n; i++){
            sb.append(s.substring(p, indices[i]));
            p = indices[i];
            int curP = indices[i];
            int len = sources[i].length();
            if(i + 1 < n && i + len - 1 >= indices[i + 1]){
                i += 1;
                continue;

            }
            if(curP + len <= s.length() && s.substring(curP, curP + len).equals(sources[i])){
                sb.append(targets[i]);
                p+= len;
            }
        }
        if(p < s.length()){
            sb.append(s.substring(p, s.length()));
        }
        return sb.toString();
    }

//    "vmokgggqzp"
//[3,5,1]
//["kg","ggq","mo"]
//["s","so","bfr"]

    public static void main(String[] args) {
        System.out.println(findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg","ggq","mo"}, new String[]{"s","so","bfr"}));

    }
}
