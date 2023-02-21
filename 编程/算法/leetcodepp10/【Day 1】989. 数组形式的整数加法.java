package 编程.算法.leetcodepp10;
// Input: num = [1,2,0,0], k = 34
// Output: [1,2,3,4]
// Explanation: 1200 + 34 = 1234

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Main01 {
    public static void main(String[] args) {
        int [] num = {9,9,9,9,9,9,9,9,9,9};
        int k=1;
        Solution solution = new Solution();
        List<Integer> rt = solution.addToArrayForm(num, k);
        System.out.println(rt);
    }
}

class Solution3 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>(); // 创建一个空的结果列表
        int i = num.length - 1; // 从最高位开始处理
        while (i >= 0 || k > 0) { // 如果num数组没有处理完或者k不为0
            if (i >= 0) { // 如果num数组还有数
                k += num[i]; // 将num[i]加到k中
                i--; // 指向下一个num的下标
            }
            list.add(0, k % 10); // 将k的最低位添加到结果列表的最前面
            k /= 10; // 去掉k的最低位
        }
        return list; // 返回结果列表
    }
}


class Solution2 {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        StringBuffer sb = new StringBuffer(); // 创建一个可变的字符串缓冲区
        for (int i=0;i<num.length;i++) { // 遍历num数组
            sb.append(num[i]); // 将num数组中的数添加到字符串缓冲区中
        }
        BigDecimal bg = new BigDecimal(sb.toString()).add(new BigDecimal(k)); // 将字符串缓冲区中的数和k相加
        String countStr = bg.toString(); // 将相加的结果转换为字符串
        List<Integer> list = new ArrayList<>(); // 创建一个空的结果列表
        for (int i=0;i<countStr.length();i++) { // 遍历相加后的结果字符串
            list.add(Integer.parseInt(String.valueOf(countStr.charAt(i)))); // 将结果字符串中的数添加到结果列表中
        }
        return list; // 返回结果列表
    }
}
//cpp
// 思路：

// ​ 拿到题目最初的想法是将num数组转换为十进制的整数，然后直接与k相加，但是看到题目中条件数组的长度最大可以是$10^4$，排除这种做法，因为无论是int还是long long int 都够呛存下来。

// ​ 因此，因该考虑逐位相加，但是这种方法我感觉又有些麻烦，所以参考了官方题解的另一种思路，并尝试实现。

// ​ 将整数k与num数组最后一位相加，用temp暂时存下相加的结果，对temp取余得到最终结果的最后一位，然后再对temp整除10，将得到的结果与num数组倒数第二位相加，重复前面的步骤，整体的算法思路就是这样。

// ​ 但是，要注意一些小问题，比如最终结果需要往前进位怎么办，整数k的长度 > 数组长度怎么办。

// ​ 可以发现如果出现上面的两种情况，在跳出第一个for之后，temp肯定不为0，所以这时只需要将temp逐位插入到最终的数组中即可。

// ​ 此外，对于整数k的长度远小于数组长度的测试用例，可以通过检查temp是否为0来提前终止循环，减少运行时间，算是一点小优化。

// 代码：C++

// class Solution {
// public:
//     vector<int> addToArrayForm(vector<int>& num, int k) {
//         int nsize = num.size();
//         int temp = k;
//         for (int i = nsize - 1; i >= 0; i--) {
//             //小改进
//             if(temp == 0)
//                 break;
//             temp = num[i] + temp;
//             num[i] = temp % 10;
//             temp = temp / 10;
//             //如果最高位出现进位
            
//         }
//         while( temp != 0) {
//             num.insert(num.begin(), temp % 10);
//             temp = temp / 10;
//         }
//         return num;

//     }
// };

// 复杂度分析：

// ​ 时间复杂度： 取决于整数k和数组的长度，所以应该是O(max(num.size(),logk));

// ​ 空间复杂度：由于没有创建新的数组，应该为O(1);