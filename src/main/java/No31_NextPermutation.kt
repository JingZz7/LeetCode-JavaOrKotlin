import java.util.Arrays

class No31_NextPermutation {
    /**
     * @param null:
     * @return null
     * @author ZJ
     * @description TODO 下一个排列_31 排序
     * @date 2022/12/12 23:36
     */
    fun nextPermutation(nums: IntArray) {
        /**
         * 我们可以看到，如果此时排列已经是最大的，下一个排列要变成最小的，所以可以设置一个计数器，看看这个排列是否是最大的，
         * 如果前一个比后一个大就加一，如果计数器最后等于长度减去1，则为最大排列，直接排序即可
         * 如果不是最大的排列，想要找到下一个排列，就必须找到可以变大的那个位置。
         * 从后往前遍历，如果后面的数比前面的数小，说明这一串数字已经不能变大了，例如：2，3，2，1。
         * 后面三位：3，2，1 已经是最大的了，所以如果后面的数比前面大，说明这个位置之后的数有**“提升空间”**，记下有
         * “提升空间” 的数字的值，然后对后面那一串数字从小到大排序，找到比 “提升空间” 大的数字，前面的后移一位，
         * 再把那个数字插入到 “提升空间” 数字的那个位置即可
         *
         * 详见图解 resources/img/31.png
         * */
        var sum = 0
        val len = nums.size
        for (i in 0 until len - 1) {//遍历所有
            if (nums[i] > nums[i + 1]) {
                sum++
            }
        }
        if (sum == len - 1) {//sum最后等于长度减去1，则为最大排列，直接排序即可
            Arrays.sort(nums)
        } else {
            var index = 0 //“提升空间”数字的下标
            var num = 0 //提升空间数字的值
            var indexNum = 0
            for (i in len - 1 downTo 1) { //从后往前遍历
                if (nums[i] > nums[i - 1]) {
                    index = i - 1
                    num = nums[i - 1]
                    break
                }
            }
            Arrays.sort(nums, index, len) //只排序[index,len)的部分
            var indexI = 0
            for (i in index until len) { //从前往后遍历
                if (nums[i] > num) { //找到一个最小的大于“提升空间”的数字
                    indexNum = nums[i] //最小的大于“提升空间”的数字的值
                    indexI = i //最小的大于“提升空间”的数字的下标
                    break
                }
            }
            for (i in indexI downTo index + 1) { //从后往前遍历
                nums[i] = nums[i - 1] //将(包括)“提升空间” 到 最小的大于“提升空间”的数字 之前的数，后移一位
            }
            nums[index] = indexNum //将“提升空间”数字的位置，让给 最小的大于“提升空间”的数字
        }
    }
}