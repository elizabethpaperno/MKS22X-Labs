public class Recursion{
    /*Print all words that are made of the letters a-e inclusive.
    *@param length : the length of the words that are to be printed
    */
    public static void printAllWords(int length){
      printAllWords(length,"");
    }

    /*Print all words that are made of the letters a-e inclusive.
    *@param length : either how many more letters or the total length depending on implementation
    *@param word   : the partial word so far.
    */
    public static void printAllWords(int length,String word){
      //WRITE THIS METHOD
        if (length > 0){
          for (char c = 'a'; c <= 'e'; c++){
            printAllWords(length - 1, word + c);
          }
        }
        else{
          System.out.println(word);
        }
    }

    /*Print all words that are made of the characters in the array of letters.
    *There may not be consecutive equal letters, so:
    *aax is not allowed, but axa is allowed.
    *@param length : the length of the words that are to be printed
    *@param letters: the letters you should be using,
    *@precondition: letters contains at least 2 characters, and has no duplicates.
    */
    public static void printNoDoubleLetterWords(int length,char[] letters){
      printNoDoubleLetterWords(length,"",letters);
    }

    /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
    *aax is not allowed, but axa is allowed.
    *@param length : either how many more letters need to be
    *@param word   : the partial word so far.
    *@param letters: the letters you should be using
    */
    public static void printNoDoubleLetterWords(int length,String word,char[]letters){
      if(length > 0){
        for (int i = 0; i < letters.length; i++){
          if (i == 0 || word.charAt(i - 1) != letters[i]){
            printNoDoubleLetterWords(length - 1, word + letters[i], letters);
          }
        }
      }else{
        System.out.print(word);
      }
    }

    public static void main(String[] args){
      System.out.println("og method: ");
      printAllWords(3);
      System.out.println("no double method: ");
      char[] letters = {'a', 'a', 'd', 'd', 'e', 'c', 'c', 'b', 'b'};
      printNoDoubleLetterWords(3, letters);
    }
}
