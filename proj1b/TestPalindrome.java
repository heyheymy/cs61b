import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome("madam"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("dog"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertTrue(palindrome.isPalindrome("AaA"));
        assertFalse(palindrome.isPalindrome("ACDC"));

    }

    @Test
    public void testIsPalindromeCc() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("zyzy", obo));
        assertTrue(palindrome.isPalindrome("yyxz", obo));
        assertTrue(palindrome.isPalindrome("yyyxz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("xyz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("zxzx", obo));
    }
}
