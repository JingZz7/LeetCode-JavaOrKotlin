class No27_RemoveElement {

    /**
     * @param null:
     * @return null
     * @author ZJ
     * @description TODO 移除元素_27 双指针
     * @date 2022/12/12 22:52
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        /**
        右指针right指向当前需要处理的元素，左指针left指向下一个将要赋值的元素
        如果nums[right]!=val,将右指针元素复制到左指针，并且left和right同时右移
         */
        val len: Int = nums.size
        var left = 0
        for (right in 0 until len) {
            if (nums[right] !== `val`) {
                nums[left] = nums[right]
                left++
            }
        }
        return left
    }

    /**
     * @param null:
     * @return null
     * @author ZJ
     * @description TODO
     * @date 2022/12/12 22:52
     */
    fun removeElement_1(nums: IntArray, `val`: Int): Int {
        /**
         * 先排序，找到数组中与val相等的个数，再把后面的元素前移countVal个单位
         * */
        nums.sort()
        var countVal: Int = 0
        for (i in nums.indices) {
            if (nums[i] == `val`) {
                countVal++
            }
        }
        val len: Int = nums.size - countVal
        var index: Int = 0;
        for (i in nums.indices) {
            if (nums[i] == `val`) {
                index = i
                for (j in i + countVal until nums.size) {
                    nums[index] = nums[j]
                    index++
                }
            }
        }
        return len
    }
}