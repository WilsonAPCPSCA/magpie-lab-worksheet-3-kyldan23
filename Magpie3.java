package Magpie_Lab3;
/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if(findKeyword(statement, "dog",0)>=0) {
			response="Tell me more about your pets.";
		}
		else if(findKeyword(statement, "Mr",0)>=0|| findKeyword(statement, "Ms",0)>=0) {
			response="What a cool teacher!";
		}
		else if(findKeyword(statement, "rock",0)>=0) {
			System.out.println("I chose paper....HA! Get covered!");
		}
		else if(findKeyword(statement, "paper",0)>=0) {
			System.out.println("I chose scissors....HA! Get cut!");
		}
		else if(findKeyword(statement, "scissors",0)>=0) {
			System.out.println("I chose rock....HA! Get smashed!");
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase(); //makes the statement input into lowercase
		goal = goal.toLowerCase(); //turns the string that it's trying to find to lowercase

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos); //starts from index "startPos" to identify the first location
											      //of goal 
		
		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0) //psn was the int variable found for the first location of goal
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0) //does not equal to 0, since 0 will automatically mean that there's 
						 //nothing that comes before the goal
			{
				before = phrase.substring(psn - 1, psn); //String before
													     //String phrase is used instead of the original statement
			}
			if (psn + goal.length() < phrase.length()) //checks to make sure that once you add the index of the 
			//first instance with the length of the goal, that it's less than the length of the whole entire input statement
		    //if it was greater than the statement, then there would be no characters or anything after the goal is found
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1); 
			//starting from the next index, jumping over the index you last started from
			

		}

		return -1; //returns -1 if the goal is not found
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}

}
