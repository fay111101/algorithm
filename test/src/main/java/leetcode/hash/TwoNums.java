package leetcode.hash;
/* Given an array of integers, find two numbers such that they add up to a
specific target number.

The function twoSum should return indices of the two numbers such that they
add up to the target, where index1 must be less than index2. Please note that
 your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/
import java.util.HashMap;

public class TwoNums {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        if(numbers==null||numbers.length==0){
            return res;
        }
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=1;i<=numbers.length;i++){
            map.put(numbers[i-1],i);
        }
        int num=0;
        for(int i=1;i<=numbers.length;i++){
            num=target-numbers[i-1];
            if(map.containsKey(num)&&i!=map.get(num)){
                if(i<map.get(num)){
                    res[0]=i;
                    res[1]=map.get(num);
                }else{
                    res[0]=map.get(num);
                    res[1]=i;
                }
            }
        }
        return res;
    }
}
