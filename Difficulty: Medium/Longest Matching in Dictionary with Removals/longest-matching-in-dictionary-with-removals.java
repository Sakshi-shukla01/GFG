class Solution {
    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length())
                return b.length() - a.length();

            return a.compareTo(b);
        });

        for (String word : d) {

            int i = 0;
            int j = 0;

            while (i < s.length() && j < word.length()) {

                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }

                i++;
            }

            if (j == word.length()) {
                return word;
            }
        }

        return "";
    }
}