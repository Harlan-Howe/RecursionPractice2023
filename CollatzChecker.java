
public class CollatzChecker
{

	public int checkValue(int val)
	{
		System.out.println(val);
		if (val == 1)
			return 1;

		if (val%2 == 0)
			return checkValue(val/2)+1;
		else
			return checkValue(3*val + 1)+1;
		
	}
	
}
