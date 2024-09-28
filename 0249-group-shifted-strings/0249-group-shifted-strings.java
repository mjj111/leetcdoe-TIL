class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> maps = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.setLength(0);
            char[] chars = string.toCharArray();
            int shift = chars[0] - 'a'; 

            for (char c : chars) {
                int normalizedChar = (c - shift + 26) % 26;
                sb.append(normalizedChar);
            }

            String result = sb.toString();
            maps.computeIfAbsent(result, k -> new ArrayList<>()).add(string);
        }

        return new ArrayList<>(maps.values());
    }
}
