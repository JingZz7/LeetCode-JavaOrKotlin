import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15_3Sum {
  /**
   * @param nums: * @return List<List<Integer>>
   * @author ZJ
   * @description TODO 三数之和_15 排序 + 双指针
   * @date 2022/12/12 0:16
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>(); // 结果集
    if (nums.length < 3) { // 长度小于3，返回一个空集合
      return list;
    }
    int len = nums.length;
    Arrays.sort(nums); // 排序
    for (int i = 0; i < len; ++i) {
      if (nums[i] > 0) { // 第一个元素大于0，后面肯定都大于0了
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) { // 后一个的元素和前面的一样，直接continue
        continue;
      }
      int left = i + 1; // 左指针
      int right = len - 1; // 右指针
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> list1 = new ArrayList<>(); // 创建一个新集合，把三个元素加入
          list1.add(nums[i]);
          list1.add(nums[left]);
          list1.add(nums[right]);
          list.add(list1); // 将三个元素的List加入结果集

          while (left < right && nums[left] == nums[left + 1]) { // 后一个的元素和前面的一样，直接continue
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) { // 后一个的元素和前面的一样，直接continue
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) { // sum小于0，左边的右移，让sum变大
          left++;
        } else { // sum大于0，右边的左移，让sum变小
          right--;
        }
      }
    }
    return list;
  }
}
