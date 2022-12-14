import org.omg.CORBA.IRObject;
import sun.misc.LRUCache;

import java.util.ArrayList;

public class No34_FindFirstAndLastPositionOfElementInSortedArray {

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

  public static void main(String[] args) {
    int[] ints = new int[] {5, 7, 7, 8, 8, 10};
    No34_FindFirstAndLastPositionOfElementInSortedArray
        no34_findFirstAndLastPositionOfElementInSortedArray =
            new No34_FindFirstAndLastPositionOfElementInSortedArray();

    int[] ints1 = no34_findFirstAndLastPositionOfElementInSortedArray.searchRange(ints, 8);
    System.out.println(ints1);
  }
}
