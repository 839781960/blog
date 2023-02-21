package 编程.算法.leetcodepp10;
//https://leetcode.cn/problems/shortest-distance-to-a-character/
// 输入：s = "loveleetcode", c = "e"
// 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
// 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
// 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
// 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
// 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
// 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
//思路

import java.util.ArrayList;
import java.util.Arrays;

class Main02 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        //Solution solution = new Solution();
        //int[] res = solution.shortestToChar(s, c);
        //System.out.println(Arrays.toString(res));
    }
}
//输出距离每个字母最近的e的下标->输入字串s,字符e。
class Solution1{
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> lst = new ArrayList<>();
        int[] rt = new int[s.length()];
        //得到arr
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                lst.add(i);
            }
        }
        //遍历一遍
        //遍历每个'e'字符3,5,611
        for (int i = 0; i < lst.size(); i++) {
            int e = lst.get(i); // 当前遍历到的'e'字符的下标
            int j = e; // 初始化j为当前'e'字符的下标
            while (j >= 0) {
                int dist = e - j; // 计算当前字符到当前'e'字符的距离
                // 如果rt[j]为0，说明当前位置之前没有出现过'e'字符，需要直接记录距离
                // 或者当前位置到当前'e'字符的距离小于rt[j]，说明当前位置到当前'e'字符更近，需要更新rt[j]
                if (rt[j] == 0 || dist < rt[j]) {
                    rt[j] = dist; // 更新rt[j]为当前位置到当前'e'字符的距离
                } else {
                    break; // 如果当前位置到当前'e'字符的距离已经不再递减，说明已经找到最近的'e'字符，可以跳出循环
                }
                j--; // 继续向左遍历字符
            }
            j = e + 1; // 将j重置为当前'e'字符下标的下一个位置
            while (j < s.length()) {
                int dist = j - e; // 计算当前字符到当前'e'字符的距离
                // 如果rt[j]为0，说明当前位置之前没有出现过'e'字符，需要直接记录距离
                // 或者当前位置到当前'e'字符的距离小于rt[j]，说明当前位置到当前'e'字符更近，需要更新rt[j]
                if (rt[j] == 0 || dist < rt[j]) {
                    rt[j] = dist; // 更新rt[j]为当前位置到当前'e'字符的距离
                } else if (dist == rt[j] && j < e) {
                    // 当距离相等时，选择左边的字符
                    rt[j] = dist;
                    break;
                } else {
                    break; // 如果当前位置到当前'e'字符的距离已经不再递增，说明已经找到最近的'e'字符，可以跳出循环
                }
                j++; // 继续向右遍历字符
            }
        }
        return rt;
    }
    
} 

class Solution2 {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> lst = new ArrayList<>();
        int [] rt = new int[s.length()];
        //得到arr
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                lst.add(i);
            }
        }
        //遍历一遍
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                rt[j++]=lst.get(i)-j;
            }
        }

        return rt;

    }
}
