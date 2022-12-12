/***
 * 因为 IDEA 中没有 ListNode 的实现类，导致爆红，所以就把以下代码注释掉了，把注释去掉即可
 * */

/// ** recursion - Linked list - mathematics */
// public class No2_AddTwoNumbers {
//
//  /**
//   * Definition for singly-linked list. public class ListNode { int val; //值 ListNode next; //下一节点
//   * ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) {
// this.val
//   * = val; this.next = next; } }
//   */
//
//  /**
//   * @param l1:
//   * @param l2: * @return ListNode
//   * @author ZJ
//   * @description TODO 两数相加_2 链表 维护一个进位变量sum
//   * @date 2022/12/11 22:15
//   */
//  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    ListNode pre = new ListNode(0); // 构造一个新的链表，val为0
//    ListNode curr = pre;
//    int sum = 0; // 同位相加的变量
//    while (l1 != null || l2 != null || sum != 0) {
//      if (l1 != null) {
//        sum += l1.val;
//        l1 = l1.next; // 指向下一个
//      }
//      if (l2 != null) {
//        sum += l2.val;
//        l2 = l2.next; // 指向下一个
//      }
//      curr.next = new ListNode(sum % 10); // 取模，不然sum可能大于10
//      sum /= 10; // 如果sum大于10，要进位
//      curr = curr.next;
//    }
//    return pre.next; // 返回pre的next，去掉初始化的0
//  }
// }
