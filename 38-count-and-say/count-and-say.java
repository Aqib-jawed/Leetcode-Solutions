class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;

            while (j < result.length()) {
                char ch = result.charAt(j);
                int count = 0;

                // Count consecutive same digits
                while (j < result.length() && result.charAt(j) == ch) {
                    count++;
                    j++;
                }

                next.append(count).append(ch);
            }

            result = next.toString();
        }

        return result;
    }
}