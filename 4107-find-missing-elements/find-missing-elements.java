
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = minVal; i <= maxVal; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}