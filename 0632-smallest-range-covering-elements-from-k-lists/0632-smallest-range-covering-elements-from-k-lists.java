import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 최소 힙(우선순위 큐) 설정: (값, 리스트 인덱스, 해당 리스트의 값 인덱스)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);

            minHeap.offer(new int[]{value, i, 0});
            max = Math.max(max, value);
        }


        int minDistance =  Integer.MAX_VALUE;
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        while (!minHeap.isEmpty()) {
            int[] now = minHeap.poll(); 
            int min = now[0];
            int listIndex = now[1];
            int elementIndex = now[2];

            //범위 갱신
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // 다음 값을 힙에 추가 (리스트를 벗어나면 종료)
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);

                minHeap.offer(new int[]{nextValue, listIndex, elementIndex + 1});

                max = Math.max(max, nextValue);
            } 
            else {
                break; 
            }
        }

        return new int[]{start, end};
    }
}
