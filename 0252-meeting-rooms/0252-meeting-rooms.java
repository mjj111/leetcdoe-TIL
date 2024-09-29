class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] -b[0]);
        int lowest = Integer.MAX_VALUE;
        int highst = Integer.MIN_VALUE;

        for(int i = 1; i < intervals.length; i++) {
            int beforeStart = intervals[i-1][0];
            int beforeEnd = intervals[i-1][1];

            int nowStart = intervals[i][0];
            int nowEnd = intervals[i][1];

            if(beforeEnd > nowStart) return false;
            
        }
        return true;
    }
}