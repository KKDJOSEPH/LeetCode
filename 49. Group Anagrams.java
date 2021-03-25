/**
 * https://leetcode.com/problems/group-anagrams/
 * Author: KKDJoseph
 * Method: 注意数组转成字符串的方法
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    // 注意.toString()返回的是地址，是用一个string表示这个数组
    // 你可以用Arrays.toString() 或者 String.valueOf()， 后者更快
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String i : strs){
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            String tempstr = String.valueOf(temp);
            List<String> tempList = map.getOrDefault(tempstr, new ArrayList<String>());
            tempList.add(i);
            map.put(tempstr, tempList);
        }
        for(List<String> i : map.values()){
            answer.add(i);
        }
        return answer;
    }
}