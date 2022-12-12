public class No26_RemoveDuplicatesfromSortedArray {

  /**
   * @param nums: * @return int
   * @author ZJ
   * @description TODO 删除有序数组中的重复项_26 遍历，然后找不同直接插入到指定位置即可
   * @date 2022/12/12 22:31
   */
  public int removeDuplicates(int[] nums) {
    /** O(1)的额外空间，所以不能new数组，不能new hashset */
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int index = 0; // 指定位置
    int pos = index + 1; // 指定位置的下一个位置，如果不重复，插入到此处
    int length = 1; // 新的长度
    for (int i = 1; i < len; ++i) {
      if (nums[i] == nums[index]) { // 当前元素和指定位置元素相同，continue
        continue;
      } else {
        nums[pos] = nums[i];
        pos++;
        length++;
        index = i;
      }
    }
    return length;
  }
}
