import java.awt.font.NumericShaper;
import java.util.Arrays;

public class No16_3SumClosest {

  private int MINDifferent = Integer.MAX_VALUE; // 定义一个最大值，用来判断sum和target的差值

  /**
   * @param nums:
   * @param target: * @return int
   * @author ZJ
   * @description TODO 最接近的三数之和_16 排序 + 双指针 和第15题有点类似
   * @date 2022/12/12 21:30
   */
  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) { // 数组为空或长度小于3，不符合条件，直接返回0
      return 0;
    }
    Arrays.sort(nums); // 排序
    int len = nums.length;
    int min = 0; // 和target值最接近的数，结果数
    outer:
    for (int i = 0; i < len; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) { // 如果元素和前一个一样，直接continue
        continue;
      }
      int left = i + 1; // 左指针
      int right = len - 1; // 右指针
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right]; // 三数之和
        int diff = Math.abs(target - sum); // 差值
        int minTemp = MINDifferent; // 差值的临时变量
        MINDifferent = Math.min(MINDifferent, diff); // 改变差值
        if (MINDifferent != minTemp) { // 如果差值改变，说明有更接近的sum值了，给min重新赋值
          min = sum;
        }
        if (sum == target) { // 相等，直接break
          break outer;
        } else if (sum < target) { // 三数之和小于target，左边的右移，让sum变大
          left++;
        } else { // 三数之和大于target，右边的左移，让sum变小
          right--;
        }
      }
    }
    return min;
  }
}
