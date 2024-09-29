class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.size(); j++) {
                if (i < words.get(j).length()) { 
                    sb.append(words.get(j).charAt(i));
                }
            }

            String tmp = sb.toString();
            if (!word.equals(tmp)) return false;
        }
        return true;
    }
}
