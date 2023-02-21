package 编程.算法.leetcodepp10;

import java.util.ArrayList;

public class test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int [] num = {1,2,0,0};

      for (int i = 0; i < num.length; i++) {
        arrayList.add(0, num[i]);
        
      }

      for(int b =0;b<arrayList.size();b++){
        System.out.println(arrayList.get(b));
      }
 

    }
    
}
