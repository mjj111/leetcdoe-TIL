class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        
        int totalDiff = arr[n - 1] - arr[0];
        int expectedDiff = totalDiff / n;

        for (int i = 0; i < n - 1; i++) {
            int currentDiff = arr[i + 1] - arr[i];
            if (currentDiff != expectedDiff) {
                return arr[i] + expectedDiff;
            }
        }

        if (expectedDiff == 0) {
            return arr[0];
        }

        return -1;
    }
}