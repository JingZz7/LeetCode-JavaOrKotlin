import java.util.HashMap;
import java.util.HashSet;

/** Hash table - string - Sliding window */
public class No3_LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring_1(String s) {
    if (s.length() == 1) {
      return 1;
    }

    char[] ch = s.toCharArray();

    int len = ch.length;

    String str = "";
    int max = 0;
    boolean flag = false;
    for (int i = 0; i < len - 1; i++) {
      str += ch[i];
      inner:
      for (int j = i + 1; j < len; j++) {
        flag = str.contains(s.substring(j, j + 1));
        if (flag) {
          break inner;
        }
        str += s.substring(j, j + 1);
      }
      max = Math.max(max, str.length());
      str = "";
      flag = false;
    }

    return max;
  }

  /**
   * @param s: * @return int
   * @author ZJ
   * @description TODO 无重复字符的最长子串_3
   * @date 2022/12/11 22:23
   */
  public int lengthOfLongestSubstring_2(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return s.length();
    }

    HashMap<Character, Integer> map = new HashMap<>();
    int len = s.length(); // 字符串长度
    int left = 0; // 最左边元素的位置
    int max = 0;
    for (int i = 0; i < len; ++i) {
      if (map.containsKey(s.charAt(i))) {
        left = Math.max(left, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i); // 覆盖前一个字符的位置
      max = Math.max(max, i - left + 1); // 不断更新max的长度
    }
    return max;
  }
}
