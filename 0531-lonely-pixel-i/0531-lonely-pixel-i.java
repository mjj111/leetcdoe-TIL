class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n  = picture.length;
        int m = picture[0].length;
        int[] row = new int[n];
        int[] column = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B') {
                    row[i] += 1;
                    column[j] += 1;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if (row[i] >=  2) continue;
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B' && column[j] == 1) answer += 1;
            }
        }
        return answer;
        //B를 찾아서 있는 곳에
        //해당 행에 개수 1 추가, 해당 열에 개수 1 추가 

        // 행에 한 개만 있는 행으로 반복문
        // 만약 열 개수 만큼 접근하는데 열에 1 이하 있다면 answer += 1 

    }
}