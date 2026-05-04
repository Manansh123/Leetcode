class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a, b) -> b-a);
        for(int i : stones) {
            maxheap.add(i);
        }
        while (maxheap.size()>1) {
            int x=maxheap.poll();
            int y=maxheap.poll();
            if (x!=y) maxheap.add(x-y);
        }
        return (maxheap.isEmpty()) ? 0 : maxheap.peek();
    }
}