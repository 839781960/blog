package 编程.算法.leetcodepp10;

import java.util.Arrays;

class Main03 {
    public static void main(String[] args) {

        Customstk stk = new Customstk(3);
        
        stk.push(1);                          // 栈变为 [1]
        System.out.println(stk);
        stk.push(2);                          // 栈变为 [1, 2]
        stk.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        stk.push(2);                          // 栈变为 [1, 2]
        stk.push(3);                          // 栈变为 [1, 2, 3]
        stk.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        stk.increment(5, 100);                // 栈变为 [101, 102, 103]
        stk.increment(2, 100);                // 栈变为 [201, 202, 103]
        stk.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        stk.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        stk.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        stk.pop();  

    }
}

    class Customstk {
        int maxSize;
        int [] stk;
        int top;

        public Customstk(int maxSize) {
            this.maxSize = maxSize;
            stk = new int[maxSize];
            top = -1;
        }
        
        public void push(int x) {
            if(top<maxSize-1){
                stk[++top]=x;
                //System.out.println("push " + x + " to stk, now stk is: " + Arrays.toString(stk));
            }
        }
        
        public int pop() {
            if(top<=0){
                //System.out.println("stk is empty, can not pop, now stk is: " + Arrays.toString(stk));
                return -1;
            }else{
                int res = stk[top];
                //System.out.println("pop " + res + " from stk, now stk is: " + Arrays.toString(stk));
                top--;
                return res;
            }
        }
        
        public void increment(int k, int val) {
            int l = Math.min(k,top+1);//1 <= maxSize, x, k <= 1000 
            for(int i =0;i<l;i++){
                stk[i] = stk[i]+val;
            }
            //System.out.println("increment bottom " + k + " elements by " + val + ", now stk is: " + Arrays.toString(stk));
        }
    }


