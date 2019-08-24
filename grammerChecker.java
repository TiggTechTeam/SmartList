import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	
	
	public static boolean spellCheck(String input, String [] dic) 
	{
		String currentCheck = "";
		boolean noErrors = true;
		Scanner spellChecker = new Scanner(input);
		spellChecker.useDelimiter("\\s+");
		if(!grammerCheck(input, input.length())) {
			
			noErrors = false;

			
		}
		
		while(spellChecker.hasNext()) {
			currentCheck = spellChecker.next();
		
			
			if(!isSpecial(currentCheck)) {
				if(!checkWord(currentCheck,dic)) {
					System.out.println(currentCheck + "is spelt incorrectly ");
					noErrors = false;
				}
				
				
			}
		}
		return noErrors;
		
	}
	
	
	public static boolean isSpecial (String input) {
		
		Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(input);
		return match.find();
	}
	
public static boolean checkWord (String input, String[] dic) {
		boolean valid = false;
		int length = dic.length;
		int i = 0;
		while(!valid && i < length) {
			if(input.trim().equalsIgnoreCase(dic[i])) {
				
				valid = true;
				
				if(input.trim().equals("I")) {
					valid = true;
				}else if (input.trim().equals("i")) {
					valid = true;

				}
				
			}
			
			i++;
		}
	return valid;
		
	}
	
	public static boolean grammerCheck(String input, int length) {
		
		boolean validGrammer = true;
		int lastCharacter = length-1;
		
		
		//Es
		if(input.charAt(lastCharacter) != '.') {
			System.out.println("Missing fullstop the end of the Sententece ");
			validGrammer = false; 
		}
		if(!Character.isUpperCase(input.charAt(0))) {
			
			System.out.println("The sentece must start with an uppercase character  ");
			validGrammer = false; 

			
			
		}
		//hier kann ein Fehler stehen 
		return false;
		
		
	}


	public static void main(String[] args) {

		//Dictionary
		
		String[] wordList = new String[8];
		wordList[0] = "I";
		wordList[1] = "am";
		wordList[2] = "cool";
		wordList[3] = "guy";
		wordList[4] = "man";
		wordList[5] = "tpy";
		wordList[6] = "fallow";
		wordList[7] = ".";


		String input = "I am cool guy man tpy fallow";
		
		if(spellCheck(input, wordList)) {
			
			System.out.println("No Errors");
		}else {
			System.out.println("Error");
		}
		
		
		
		
	}

}
