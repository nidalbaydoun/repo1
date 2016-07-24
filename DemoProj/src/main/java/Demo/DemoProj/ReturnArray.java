package Demo.DemoProj;


public class ReturnArray {
	
	public String [] convert(Integer [] IntAarray) {
		//Boxing
		String [] a = new String [IntAarray.length];
		
		for (int i = 0; i < IntAarray.length; i++) {
			IntAarray[i] += 80;
			a[i] = IntAarray[i].toString();
		}
		
		return a;
	}

	public String [][] convert2(Integer [] IntAarray, int v) {
		String [][] a = new String [IntAarray.length][2];
		
		for (int i = 0; i < IntAarray.length; i++) {
			if (v == 1)
			{
				IntAarray[i] += 100;
				a[i][1] = "True";
			}
			else
			{
				a[i][1] = "False";
			}
			a[i][0] = IntAarray[i].toString();
		}
		return a;
	}
	
	public static void main(String[] args) {
		// Instantiate the ReturnArray object
		ReturnArray r = new ReturnArray();
		
		// Call the simple convert method
		Integer [] x = {1,2,3};
		String [] ra = r.convert(x);	
		for (int i = 0; i < x.length; i++) {
			System.out.println(ra[i]);
		}

		// Call with 0 to print False
		Integer [] x2 = {1,2,3};
		String [][] ra2 = r.convert2(x2, 0);
		for (int i = 0; i < x2.length; i++) {
			System.out.println(ra2[i][0] +", " + ra2[i][1]);
		}
		
		// Call with 1 to add 100 and print True
		Integer [] x3 = {1,2,3};
		String [][] ra3 = r.convert2(x3, 1);
		for (int i = 0; i < x3.length; i++) {
			System.out.println(ra3[i][0] +", " + ra3[i][1]);
		}
	}

}