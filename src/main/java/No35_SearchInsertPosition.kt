class No35_SearchInsertPosition {
    /**
     * @param null:
     * @return null
     * @author ZJ
     * @description TODO 搜索插入位置_35 无脑二分法，详见34题解法
     * @date 2022/12/15 0:18
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        return lowerBound(nums, target)
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        val len = nums.size
        var left = 0
        var right = len - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] < target) {
                left = mid + 1 // [mid+1,right]
            } else {
                right = mid - 1 // [left,mid-1]
            }
        }
        return left
    }
}