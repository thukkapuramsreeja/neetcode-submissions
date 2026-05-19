

public class Solution {

    // Encode list of strings to one string
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    // Decode string back to list
    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find separator #
            while (str.charAt(j) != '#') {
                j++;
            }

            // Length of string
            int length = Integer.parseInt(str.substring(i, j));

            // Move to actual string
            j++;

            // Extract string
            String word = str.substring(j, j + length);

            result.add(word);

            // Move to next encoded part
            i = j + length;
        }

        return result;
    }
}