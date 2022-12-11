public class No11_ContainerWithMostWater {

  /**
   * @param height: a * return int
   * @author ZJ
   * @description TODO 底固定，容器容积取决于短板的长度
   * @date 2022/12/11 23:32
   */
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = -1;
    while (left < right) {
      max = Math.max(max, (right-left) * Math.min(height[left], height[right])); // 底*短板的高
      if (height[left] > height[right]) { // 左边长，右边左移
        right--;
      } else { // 右边长，左边右移
        left++;
      }
    }
    return max;
  }
}
