class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        // 用于存储最终的答案
        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        L[0] = 1; // 对于索引 0，左侧没有元素，乘积为 1
        for (int i = 1; i < length; i++) {
            // L[i] 是 L[i-1] 与 nums[i-1] 的乘积
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        R[length - 1] = 1; // 对于最后一个元素，右侧没有元素，乘积为 1
        for (int i = length - 2; i >= 0; i--) {
            // R[i] 是 R[i+1] 与 nums[i+1] 的乘积
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 构建答案数组，answer[i] 是 L[i] 与 R[i] 的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}