package algo;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String clean = s.strip().replaceAll("[^0-9a-zA-Z ]", "").replaceAll(" ", "").strip().toLowerCase();

        if (clean.length() <= 1) {
            return true;
        }

        int N = clean.length();
        int mid = N / 2;
        if (N % 2 == 0) {
            return pivotAroundMid(clean, mid-1, mid);
        }
        return pivotAroundMid(clean, mid, mid);
    }

    private boolean pivotAroundMid(String str, int lo, int hi) {
        while (lo >= 0 && hi < str.length()) {
            if (str.charAt(lo--) != str.charAt(hi++)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        ValidPalindrome vp = new ValidPalindrome();
        boolean b = vp.isPalindrome(str);
        System.out.println(b);
    }
}
