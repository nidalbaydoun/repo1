package Demo.DemoProj;

public class StringMatch {
	public boolean verifyTitleMatch(String actual, String expected) {
		if (actual.equals(expected)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyTitleContains(String actual, String expected) {
		if (expected.contains(actual)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyTitle(String key1, String key2, String key3, String actual) 
	{
		if ((
				(actual.startsWith(key1) && actual.endsWith(key2))
				||
				(actual.equals(key3))
			)
			&&
			!(
				(actual.startsWith(key1) && actual.endsWith(key2))
				&&
				(actual.equals(key3))
			))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		StringMatch sm = new StringMatch();
		if (sm.verifyTitleMatch("abc", "abc2"))
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equal");
		}
		//
		if (sm.verifyTitleContains("abc3", "abc2"))
		{
			System.out.println("Contains");
		}
		else
		{
			System.out.println("Does not contain");
		}
		
		String [][] testCases = {
				{"Face", "book", "Facebook", "Facebook"},
				{"Face", "chat", "Facebook", "Facebook"},
				{"Face", "book", "twitter", "Facebook"},
				{"head", "chat", "twitter", "Facebook"}
		};
		
		//
		//if (sm.verifyTitle("Face", "book", "Facebook", "Facebook"))
		//if (sm.verifyTitle("Face", "chat", "Facebook", "Facebook"))
		//if (sm.verifyTitle("Face", "book", "twitter", "Facebook"))
		if (sm.verifyTitle("head", "chat", "twitter", "Facebook"))
		{
			System.out.println("verifyTitle: True");
		}
		else
		{
			System.out.println("verifyTitle: False");
		}
	}
}
