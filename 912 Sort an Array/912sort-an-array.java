// Quick Sort

// class Solution {
//     public int[] sortArray(int[] nums) {
//         int n = nums.length;
//         quickSort(nums, 0, n-1);
//         return nums;
//     }

//     public void quickSort(int[] arr, int low, int high) {
//         if(low < high) {
//             int pIdx = partition(arr, low, high);
//             quickSort(arr, low, pIdx-1);
//             quickSort(arr, pIdx+1, high);
//         }
//     }

//     public int partition(int[] arr, int low, int high) {
//         int pivot = arr[low];
//         int i = low+1, j = high;

//         while(i <= j) {
//             while(i <= high && arr[i] <= pivot) {
//                 i++;
//             }

//             while(j >= low+1 && arr[j] > pivot) {
//                 j--;
//             }

//             if(i < j) {
//                 swap(arr, i, j);
//             }
//         }

//         swap(arr, low, j);     // Place pivot at its correct place
//         return j;
//     }

//     public void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }





// Merge Sort

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }

    public void mergeSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];

        int left = low;
        int right = mid+1;
        int idx = 0;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        while(left <= mid) {
            temp[idx++] = arr[left++];
        }

        while(right <= high) {
            temp[idx++] = arr[right++];
        }

        for(int i=0; i<temp.length; i++) {
            arr[low+i] = temp[i];
        }
    }
} 