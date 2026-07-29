class Solution {

    private long LIMIT;

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int[] half = new int[26];
        int halfLen = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1) mid = (char) ('a' + i);
        }

        if (countWays(half, halfLen) < k) return "";

        StringBuilder first = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half, halfLen - pos - 1);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(first);

        if (mid != 0) ans.append(mid);

        ans.append(new StringBuilder(first).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {

        long res = 1;

        int rem = total;

        for (int i = 0; i < 26; i++) {

            int c = cnt[i];

            if (c == 0) continue;

            res = res * comb(rem, c);

            if (res > LIMIT) return LIMIT + 1;

            rem -= c;
        }

        return Math.min(res, LIMIT + 1);
    }

    private long comb(int n, int r) {

        if (r > n) return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - r + i) / i;

            if (ans > LIMIT) return LIMIT + 1;
        }

        return Math.min(ans, LIMIT + 1);
    }
}