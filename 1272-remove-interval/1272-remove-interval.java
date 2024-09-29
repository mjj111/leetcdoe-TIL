class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int removedStart = toBeRemoved[0];
        int removedEnd = toBeRemoved[1];

        Set<int[]> answer = new HashSet<>();
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // 안에 존재 
            if(removedStart <= start && removedEnd >= end) {
                continue;
            }

            //왼쪽에서 걸처 존재
            if(removedStart > start && removedStart < end && removedEnd >= end) {
                answer.add(new int[]{start, removedStart});
                continue;
            }

            //오른쪽 걸처 존재 
            if(removedEnd < end && removedEnd > start && removedStart <= start) {
                answer.add(new int[]{removedEnd, end});
                continue;
            }

            // 보다 클때 
            if(start < removedStart && end > removedEnd) {
                answer.add(new int[]{start, removedStart});
                answer.add(new int[]{removedEnd, end});
                continue;
            }

            answer.add(new int[]{start,end});
        }
        List<List<Integer>> tmpAnswer= new ArrayList<>();
        for(int[] a : answer) {
            tmpAnswer.add(List.of(a[0], a[1]));
        }
        Collections.sort(tmpAnswer, (a,b) -> a.get(0) - b.get(0));
        return tmpAnswer;
    }
}