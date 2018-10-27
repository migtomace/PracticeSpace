public class MedianOfTwoArrays {

    //There are two sorted arrays nums1 and nums2 of size m and n respectively.
    //Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    //You may assume nums1 and nums2 cannot be both empty.

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double d;
        int[] arr = new int[m+n];
        arr = createSingleArray(nums1, nums2, 0, 0, 0, arr);
        int index = arr.length/2;

        if(arr.length%2 == 0){
            d = (double)(arr[index] + arr[index-1])/2;
        } else {
            d = (double) arr[index];
        }


        return d;
    }

    public int[] createSingleArray(int[] nums1, int[] nums2, int left, int right, int index, int[] arr){


        if(index < nums1.length + nums2.length && left != nums1.length && right != nums2.length){
            if(nums1[left] < nums2[right]){
                arr[index] = nums1[left];
                index++;
                left++;
                return createSingleArray(nums1, nums2, left, right, index, arr);
            } else {
                arr[index] = nums2[right];
                index++;
                right++;
                return createSingleArray(nums1, nums2, left, right, index, arr);
            }
        }
        if(right >= nums2.length && index < nums1.length+nums2.length){
            for(int i = index; i < nums1.length+nums2.length; i++){
                arr[index] = nums1[left];
                left++;
                index++;
            }
        } else if(left >= nums1.length && index < nums1.length+nums2.length){
            for(int i = index; i < nums1.length+nums2.length; i++){
                arr[index] = nums2[right];
                right++;
                index++;
            }
        }

        return arr;
    }

}
