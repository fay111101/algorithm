package leetcode.array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class _4_findMedianSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        double mid = 0.0;
        int m = A.length;
        int n = B.length;
        if (A == null || B == null || m + n == 0) {
            return mid;
        }
        int[] C = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                k++;
                i++;
            } else {
                C[k] = B[j];
                k++;
                j++;
            }
        }
        while (j < n) {
            C[k] = B[j];
            k++;
            j++;
        }
        while (i < m) {
            C[k] = A[i];
            k++;
            i++;
        }
        int midIndex = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            mid = (C[midIndex - 1] + C[midIndex]) * 0.5;
        } else {
            mid = C[midIndex] * 1.0;
        }
        return mid;
    }
}
