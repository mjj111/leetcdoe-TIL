class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int minTime = Integer.MAX_VALUE; 
        int maxTime = Integer.MIN_VALUE;

        Map<Integer, List<int[]>> startTimes = new HashMap<>();
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];

            if(!startTimes.containsKey(startTime)) {
                startTimes.put(startTime, new ArrayList<>());
            }
            startTimes.get(startTime).add(new int[]{startTime, endTime});

            minTime = Math.min(minTime, startTime);
            maxTime = Math.max(maxTime, endTime);
        }

        int answer = 0;
        int roomCount = 0;
        int now = minTime;
        
        Map<Integer, Integer> endTimes = new HashMap<>();
        while (now <= maxTime) {
            if (endTimes.containsKey(now)) {
                roomCount -= endTimes.get(now);
                endTimes.remove(now); 
            }

            if (startTimes.containsKey(now)) {
                List<int[]> times = startTimes.get(now);
                roomCount += times.size();
                for (int[] time : times) {
                    int end = time[1];
                    endTimes.put(end, endTimes.getOrDefault(end, 0) + 1);
                }
                answer = Math.max(roomCount, answer);
            }
            now++;
        }
        return answer;
    }
}