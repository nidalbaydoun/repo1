package Demo.DemoProj;

public class StringSplit {
	public String EvaluateString(String InputString) {
		String [] stringArray  = InputString.split(" ");
		boolean denvPresent = false;
		boolean denvis0 = false;
		String sDgroup = "";
		String sDenv = "";
		
		// -Denv not present --> smoke
		for (int i =0; i<stringArray.length; i++)
		{
			String [] subsplit = stringArray[i].split("=");
			if (subsplit[0].equals("-Denv"))
			{
				denvPresent = true;
				sDenv = subsplit[1];
				if(subsplit[1].equals("0")){
					denvis0 = true;
				}
				break;
			}
		}
		boolean dgroupsPresent = false;
		boolean dgroupsissmoke = false;
		if (denvPresent)
		{
			// -Dgroups not present

			for (int i =0; i<stringArray.length; i++)
			{
				String [] subsplit = stringArray[i].split("=");
				if (subsplit[0].equals("-Dgroups"))
				{
					dgroupsPresent = true;
					sDgroup = subsplit[1];
					if (subsplit[1].equals("smoke"))
					{
						dgroupsissmoke = true;
					}
					break;
				}
				
			}
			if (!dgroupsPresent)
			{
				return "smoke";
			}
		}
		else
		{
			return "null";
		}

		// -Dgroups present, -Denv=0 and -Dgroups=smoke
		if(dgroupsPresent && denvis0 && dgroupsissmoke)
		{
			return "smoke";
		}
		if(dgroupsPresent && denvis0 && !dgroupsissmoke)
		{
			return "null";
		}
		if(dgroupsPresent && denvPresent && !denvis0)
		{
			return sDgroup;
		}
		// 
		return "null";
	}
	
	public static void main(String[] args) {
		StringSplit sp = new StringSplit();
		String testCase0 = "execute  -Dtest=abc.test";
		String testCase1 = "execute -Denv=40 -Dtest=abc.test";
		String testCase2 = "execute -Dgroups=smoke -Denv=0 -Dtest=abc.test";
		String testCase3 = "execute -Dgroups=Nsmoke -Denv=0 -Dtest=abc.test";
		String testCase4 = "execute -Dgroups=Nsmoke -Denv=1 -Dtest=abc.test";
		
		
		//System.out.println(sp.EvaluateString(testCase0));
		//System.out.println(sp.EvaluateString(testCase1));
		//System.out.println(sp.EvaluateString(testCase2));
		//System.out.println(sp.EvaluateString(testCase3));
		System.out.println(sp.EvaluateString(testCase4));

	}
}
