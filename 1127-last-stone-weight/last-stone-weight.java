class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int s : stones) {
            maxHeap.add(s);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            if (y != x) {
                maxHeap.add(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}