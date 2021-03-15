package com.lin.p4;

public class Solution4_2 {

  public static void main(String[] args) {
    int[] num1 = new int[]{1, 2, 3, 5, 7, 9};
    int[] num2 = new int[]{1, 2, 3, 5, 7, 9};
    System.out.println(findMedianSortedArrays(num1, num2));
  }


  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    // l == r
    int l = (len1 + len2 + 1) >> 1;
    int r = (len1 + len2 + 2) >> 1;

    int i = 0;
    int j = 0;
    int cur = 0;

    int n = nums1[0];
    int m = nums2[0];

    while (true) {
      if (cur >= r) {
        break;
      }

      if (i <= len1) {
        n = nums1[i];
      }

      if (j <= len2) {
        m = nums2[j];
      }
      // n m
      if (n < m) {
        cur++;
        i++;
      } else {
        j++;
      }

    }


    return getK(nums1, 0, nums2, 0, l) + getK(nums1, 0, nums2, 0, r) / 2.0;
  }

  public static int getK(int[] num1, int i, int[] num2, int j, int k) {
    // 开始的边界
    if (i >= num1.length) {
      return num2[j + k - 1];
    }
    if (j >= num2.length) {
      return num1[i + k - 1];
    }
    if (k == 1) {
      return Math.min(num1[i], num2[j]);
    }
    // 右值
    int n = (i + k / 2 - 1) > num1.length ? num1[i + k / 2 - 1] : Integer.MAX_VALUE;
    int m = (i + k / 2 - 1) > num2.length ? num2[i + k / 2 - 1] : Integer.MAX_VALUE;
    if (n < m) {
      return getK(num1, i + k / 2, num2, j, k - k / 2);
    } else {
      return getK(num1, i, num2, j + k / 2, k - k / 2);
    }
  }


}
