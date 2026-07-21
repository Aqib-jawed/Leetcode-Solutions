class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int active = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                active++;
            }
        }

        int answer = active;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '0') {
                i++;
                continue;
            }

            int left = i;
            while (i < n && s.charAt(i) == '1') {
                i++;
            }
            int right = i - 1;

            if (left > 0 && right < n - 1 &&
                s.charAt(left - 1) == '0' &&
                s.charAt(right + 1) == '0') {

                int leftZero = 0;
                int j = left - 1;
                while (j >= 0 && s.charAt(j) == '0') {
                    leftZero++;
                    j--;
                }

                int rightZero = 0;
                j = right + 1;
                while (j < n && s.charAt(j) == '0') {
                    rightZero++;
                    j++;
                }

                int oneLength = right - left + 1;
                answer = Math.max(answer, active + leftZero + rightZero);
            }
        }

        return answer;
    }
}