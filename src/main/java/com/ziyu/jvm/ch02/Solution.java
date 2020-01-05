package com.ziyu.jvm.ch02;

public class Solution {
    public int removeElement(int[] nums, int val) {

        if(nums.length == 0){
            return 0;
        }
        int l = nums.length - 1;
        while(nums[l] == val){
            l--;
            if(l <= 0){
                return 0;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val && i < l){
                exch(nums, i, l);
                l--;
            }
        }
        return nums.length - (nums.length - 1 - l);
        
    }

    public void exch(int[] nums, int x, int y){
        int c = nums[y];
        nums[y] = nums[x];
        nums[x] = c;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}