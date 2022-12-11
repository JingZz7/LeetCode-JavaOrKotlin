import java.util.HashMap;

/** array - hashmap */
public class No1_TwoSum {

  /**
   * @param nums:
   * @param target: * @return int
   * @author ZJ
   * @description TODO 两数之和_1 两次遍历
   * @date 2022/12/11 21:15
   */
  public int[] twoSum_0(int[] nums, int target) {
    int[] ints = new int[2];
    int len = nums.length;
    outer:
    for (int i = 0; i < len; ++i) {
      ints[0] = -1;
      ints[1] = -1;
      // 因为要求两个整数，遍历到最后一个直接continue
      if (i == len - 1) {
        continue;
      }
      ints[0] = i;
      for (int j = i + 1; j < len; ++j) {
        if (nums[i] + nums[j] == target) {
          ints[1] = j;
          break outer;
        }
      }
    }
    return ints;
  }

  /**
   * @param nums:
   * @param target: a * @return int
   * @author ZJ
   * @description TODO 两数之和_1 哈希表解法
   * @date 2022/12/11 21:45
   */
  public int[] twoSum_1(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(); // map，key存值，value存下标
    int len = nums.length;
    for (int i = 0; i < len; ++i) {
      int diff = target - nums[i]; // 差值
      if (map.containsKey(diff)) { // map存在差值
        return new int[] {i, map.get(diff)}; // 直接返回两个整数
      } else { // 不存在差值，则将nums[i]存入map中
        map.put(nums[i], i);
      }
    }
    return new int[0]; // 因为这道题一定有解，所以最后返回一个空数组就行了
  }
}
