import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No18_4Sum {

  private int MINDifferent = Integer.MAX_VALUE; // 定义一个最大值，用来判断sum和target的差值

  /**
   * @param nums:
   * @param target: * @return List<List<Integer>>
   * @author ZJ
   * @description TODO 四数之和_18 排序 + 双指针 和三数之和很像，多加了一层循环而已
   * @date 2022/12/12 22:14
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>(); // 结果级
    List<List<Long>> listTemp = new ArrayList<>();
    /**
     * {1000000000，1000000000，1000000000，1000000000} 0
     * 导致了代码出现溢出错误，是因为int的只能到表示[-2147483648,2147483647] 所以new一个临时链表listTemp
     */
    if (nums == null || nums.length < 4) { // 数组为空或者长度小于4，直接返回空链表
      return list;
    }
    Arrays.sort(nums); // 排序
    int len = nums.length;
    long[] numsTemp = new long[len];
    for (int i = 0; i < len; ++i) { // 将每个int型强转成long型
      numsTemp[i] = (long) nums[i];
    }
    HashSet<List<Long>> set = new HashSet<>(); // hashset去重
    for (int i = 0; i < len; ++i) { // 第一层循环
      if (i > 0 && nums[i] == nums[i - 1]) { // 如何该数与前一个一样，直接continue
        continue;
      }
      for (int j = i + 1; j < len; ++j) { // 第二层循环
        int left = j + 1; // 左指针
        int right = len - 1; // 右指针
        while (left < right) {
          long sum = numsTemp[i] + numsTemp[j] + numsTemp[left] + numsTemp[right]; // 四数之和
          if (sum == target) { // 四数之和等于target
            List<Long> list1 = new ArrayList<>(); // 创建一个新集合，把三个元素加入
            list1.add(numsTemp[i]);
            list1.add(numsTemp[j]);
            list1.add(numsTemp[left]);
            list1.add(numsTemp[right]);
            set.add(list1); // 加入set中，去除重复集合

            while (left < right
                && numsTemp[left] == numsTemp[left + 1]) { // 后一个的元素和前面的一样，直接continue
              left++;
            }
            while (left < right
                && numsTemp[right] == numsTemp[right - 1]) { // 后一个的元素和前面的一样，直接continue
              right--;
            }
            left++;
            right--;
          } else if (sum < target) { // sum小于0，左边的右移，让sum变大
            left++;
          } else { // sum大于0，右边的左移，让sum变小
            right--;
          }
        }
      }
    }
    for (List<Long> item : set) { // 将每一个集合添加到临时链表中
      listTemp.add(item);
    }
    for (List<Long> item : listTemp) {
        /** 将临时链表中的long型变量强转回Integer */
      List<Integer> integers = new ArrayList<>();
      for (Long it : item) {
        Integer in = Long.valueOf(it).intValue();
        integers.add(in);
      }
      list.add(integers);
    }

    return list;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1000000000, 1000000000, 1000000000, 1000000000};
    No18_4Sum no18_4Sum = new No18_4Sum();
    List<List<Integer>> lists = no18_4Sum.fourSum(nums, -294967296);
    System.out.println(lists);
  }
}
