import org.omg.CORBA.IRObject;
import sun.misc.LRUCache;

import java.util.ArrayList;

public class No34_FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * @param nums:
   * @param target: * @return int
   * @author ZJ
   * @description TODO 在排序数组中查找元素的第一个和最后一个位置_34 双指针，暴力判断，效率极低，建议二分查找
   * @date 2022/12/14 23:58
   */
  public int[] searchRange(int[] nums, int target) {
    int len = nums.length;
    if (nums == null || len == 0) {
      return new int[] {-1, -1};
    }
    int left = 0;
    int right = len - 1;
    int[] ints = new int[2];
    ints[0] = -1;
    ints[1] = -1;
    while (left <= right) {
      if (left == 0 && nums[left] == target) {
        ints[0] = left;
      }
      if (right == len - 1 && nums[right] == target) {
        ints[1] = right;
      }
      if (nums[left] > target || nums[right] < target) {
        return new int[] {-1, -1};
      }
      if (ints[0] != -1 && ints[1] != -1) {
        break;
      }
      if (left != 0 && nums[left] != nums[left - 1] && nums[left] == target) {
        ints[0] = left;
      }
      if (right != len - 1 && nums[right] != nums[right + 1] && nums[right] == target) {
        ints[1] = right;
      }
      if (nums[left + 1] != target && nums[left] == target) {
        ints[1] = left;
        break;
      }
      if (nums[right - 1] != target && nums[right] == target) {
        ints[0] = right;
        break;
      }
      if (left != 0
          && ints[0] != -1
          && ints[1] == -1
          && nums[left - 1] == target
          && nums[left] > target) {
        ints[1] = left - 1;
        break;
      }
      if (right != len - 1
          && ints[1] != -1
          && ints[0] == -1
          && nums[right + 1] == target
          && nums[right] < target) {
        ints[0] = right + 1;
        break;
      }
      left++;
      right--;
    }
    return ints;
  }

  /**
   * @param nums:
   * @param target: * @return int
   * @author ZJ
   * @description TODO 二分法，详见
   *     https://blog.csdn.net/qq_52374468/article/details/128323893?spm=1001.2014.3001.5502
   * @date 2022/12/15 0:13
   */
  public int[] searchRange1(int[] nums, int target) {
    int start = lowerBound(nums, target);
    if (start == nums.length || nums[start] != target) {
      return new int[] {-1, -1};
    }
    int end = lowerBound(nums, target + 1) - 1;
    return new int[] {start, end};
  }

  private int lowerBound(int[] nums, int target) {
    int len = nums.length;
    int left = 0;
    int right = len - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] < target) {
        left = mid + 1; // [mid+1,right]
      } else {
        right = mid - 1; // [left,mid-1]
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] ints = new int[] {5, 7, 7, 8, 8, 10};
    No34_FindFirstAndLastPositionOfElementInSortedArray
        no34_findFirstAndLastPositionOfElementInSortedArray =
            new No34_FindFirstAndLastPositionOfElementInSortedArray();

    int[] ints1 = no34_findFirstAndLastPositionOfElementInSortedArray.searchRange(ints, 8);
    System.out.println(ints1);
  }
}
