// the goal is to 
//   have half the smaller elements on the right sie,
//   and rest half the greater elements on theright side
//   lets say left half-> 1,2,3
//   right half-> 4,5

//   here the median is left half max element, so we take maxheap for left 
//   abnd min heap for right side, as for even elements as 1,2,3 -> 4,5,6 3 and 4 both are required.

//   keep the difference size always one,
//   eg
//    first eement =4 , pushed to leftmaxheap,
//   then came 5, greater than leftmaxheap so pushed to rightminheap
//   4||5
//   then came 3
//   3,4||5
//   then came 2
//   becomes 2,3,4||5
//   but this wont give median so we balance the size thaht leftmax heap should be only having 1 element more
//   poping the max element from leftmax heap
//   2,3||4,5
//   now meadin is maaxpop+minpop/2.
//   same goes for vice versa
//   first came 4
//   leftheap
//   then came 5
//   4||5,
//   then came 6
//   4||5,6
//   then the size of the minheap is more thaht leftmaxheap, it should always be less as answer is in maxheap
//   so we pop
//   4,5||6
//   now meadina is maxheap.pop.
  
public class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap; // max heap
    private PriorityQueue<Integer> rightMinHeap; // min heap

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes equal
        if ((leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even number of elements
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }

        // odd number of elements
        return leftMaxHeap.peek();
    }
}
