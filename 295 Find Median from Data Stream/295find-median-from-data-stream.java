// Brute force

// class MedianFinder {

//     ArrayList<Integer> list;

//     public MedianFinder() {
//         list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int n = list.size();

//         if(n % 2 == 0) {
//             return (list.get(n/2) + list.get((n/2) - 1)) / 2.0;
//         } else {
//             return list.get(n / 2);
//         }
//     }
// }




// Optimal Solution

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        // Balance the heaps if needed
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() != minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}




/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */