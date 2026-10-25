class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       int left = 0;
       int right = n-1;

       while(left < right){
        int l = s.charAt(left);
        int r = s.charAt(right);

        if(!Character.isLetterOrDigit(l)){
            left++;
        }else if(!Character.isLetterOrDigit(r)){
            right--;
        }else{
            if(Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            }
            left++;
            right--;
        }
       }
       return true;
    }
}