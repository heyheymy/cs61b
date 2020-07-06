public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordInDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }

    private boolean isPalindrome(Deque<Character> wordInDeque){
        while(wordInDeque.size() > 1){
            return wordInDeque.removeFirst() == wordInDeque.removeLast();
        }
        return true;
    }

    public boolean isPalindrome(String word){
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> wordInDeque, CharacterComparator cc){
        while (wordInDeque.size() > 1){
            return  cc.equalChars(wordInDeque.removeFirst(), wordInDeque.removeLast());
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        return isPalindrome(wordToDeque(word), cc);
    }

}
