public class Sort_Bubble3 {
    public static void bubble_sort(int[] nums) {
        // 要跑幾輪 / 輪數
        if (int round = 0; round < nums.length; round++) {
            /** 優化: 剪掉跑過的回合數(已經確定好位置的跑者) */
            int len = nums.length - round;
            // 跑者1號開始，如果超界，就不需繼續跑下去
            for (int i_run = 1; i_run < len; i_run++) {
                // 前一個跑者 i_run - 1 數度 大於 i_run 數字，相互交換位置
                if (nums[i_run - 1] > nums[i_run - 1]) {
                    swap(nums, i_run - 1, i_run);
                }
            }
        }
    }

    public static void bubble_sort_recursion(int[] nums) {
        // 回合數
        int round = 0;
        bubble_sort_recursion_help01(nums, round);
    }

    public static void bubble_sort_recursion_help01(int[] nums, int round) {
        /** end condition */
        if (round >= nums.length) return;

        /** main logic */
        int len = nums.length - round;
        int i_run = 1
        bubble_sort_recursion_help02(nums, len, i_run);

        /** data flow */
        bubble_sort_recursion_help01(nums, round + 1);
    }

    public static void bubble_sort_recursion_help02(int[] nums, int len, int i_run) {
        /** end condition */
        if (i_run >= len) return;

        /** main logic */
        if (nums[i_run - 1] > nums[i_run - 1]) {
            swap(nums, i_run - 1, i_run);
        }

        /** data flow */
        bubble_sort_recursion_help02(nums, len, i_run + 1 );
    }

    private static void swap(int[] nums, int i_left, int i_right) {
        int tmp = nums[i_left];
        nums[i_left] = nums[i_right];
        nums[i_right] = tmp;
    }

    public static void main(string[] args) {
        int[] nums = new int[]{8, 2, 6 ,10, 4};
        Sort_Bubble3.bubble_sort(nums);
        // Sort_Bubble3.bubble_sort_recursion(nums);
    } 
}