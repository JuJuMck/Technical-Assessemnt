package palindromechekerpackage;


public class PalindromeChecker {

	public static boolean isPalindrome(String potentialPalindrome) {
		// Remove Spaces and case sensitivity and identify phrase length
		String toCheck = potentialPalindrome.replaceAll("\\s+", "").toLowerCase();
		int wordLength = toCheck.length();
		int firstLetter = 0;
		int lastLetter = wordLength - 1;

		// Compare the first Character to the last and move inwards
		while (lastLetter > firstLetter) {
			char firstChar = toCheck.charAt(firstLetter++);
			char lastChar = toCheck.charAt(lastLetter--);
			if (firstChar != lastChar)
				return false;
		}

		return true;
	}

	public static void main(String args[]) {
		String[] testWordsArray = { "Taco Cat", "Cat", "12321", "Jimmy", "!123321!", "qwertyuioppoiuytrewq" };

		// Testing
		if (isPalindrome("Nitin"))
			System.out.println("Entered string/number is a palindrome.");
		// Testing v2
		
		for (int i = 0; i < testWordsArray.length; i++) {
			if (isPalindrome(testWordsArray[i]))
				System.out.println(testWordsArray[i] + " is a palindrome.");
			else
				System.out.println(testWordsArray[i] + " is not a palindrome. Please try again");
		}
	}
}
