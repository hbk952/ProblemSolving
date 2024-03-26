package String;
//input: GEEKSFORGEEKS
//output: 4333355777733366677743333557777
//Input : HELLO WORLD
//Output : 4433555555666096667775553
public class SentenceEquivalentPhoneKeypadSequence {

	public static void main(String[] args) {
		//String sentence = "GEEKSFORGEEKS";
		String sentence = "HELLO WORLD";
		String result = "";

		String str[]= { "2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777", "8","88","888","9","99","999","9999" };
		for(char c: sentence.toCharArray()) {
			if(c == ' ') {
				result = result+0;
			}
			else {
				result = result+str[(c-'A')];
			}
		}
		System.out.println(result);

	}

}
