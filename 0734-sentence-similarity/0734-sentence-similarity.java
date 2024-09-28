class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Set<String> similarSet = new HashSet<>();
        for (List<String> pair : similarPairs) {
            String p1 = pair.get(0);
            String p2 = pair.get(1);
            similarSet.add(p1 + "," + p2);  
            similarSet.add(p2 + "," + p1);  
        }

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if(word1.equals(word2)) continue;
            if (!similarSet.contains(word1 + "," + word2)) {
                return false;
            }
        }

        return true;
    }
}
