
public class ChanceOfCrit 
{
	public static final int TRIALS = 20;
	public static final int RUN_TIMES = 1000;
	public static final int MAX_TRIALS = 30000;
	public static final int CRIT = 20;
	//public static final int MAX_TRIALS = 30000;
	
	//public int BinomialArray[] = new int[MAX_TRIALS];
	public int GeometricArray[] = new int[MAX_TRIALS];
	public int NegitiveGeometricArray[] = new int [MAX_TRIALS];
	
	public static void main(String[] args)
	{
		makeBinomialGraph();
		makeGeometricGraph();
		makeNegativeGeometricGraph();
	}
	
	public static int rollD20()
	{
		double roll = Math.random() * 20 + 1;
		return (int) roll;
	}
	
	public static void makeBinomialGraph()
	{
		int numberOfSuccesses[] = new int[TRIALS+1];
		int result, success;
		
		for (int i =0; i < RUN_TIMES; i++)
		{
			success = 0;
			for (int j = 0; j < TRIALS; j++)
			{
				result = rollD20();
				if (result == CRIT)
					success++;
			}
			numberOfSuccesses[success]++;
		}
		
//		for(int i = 0; i <= 20; i++)
//		{
//			System.out.println("Number " + i + " : " + numberOfSuccesses[i]);
//		}
	}
	public static void makeGeometricGraph()
	{
		int runsUntilSuccess[] = new int[MAX_TRIALS];
		int result, runCount;
		
		for (int i =0; i < RUN_TIMES; i++)
		{
			runCount = 1;
			result = 0;
			while(result != CRIT && runCount < MAX_TRIALS)
			{
				runCount++;
				result = rollD20();
			}
			if(runCount < MAX_TRIALS)
				runsUntilSuccess[runCount]++;
			else
			{
				runsUntilSuccess[0]++;
				System.out.println("Error: Amount of trials before first success exceded array bounds.");
			}
		}
		
//		for(int i = 0; i <= 100; i++)
//		{
//			System.out.println("Number " + i + " : " + runsUntilSuccess[i]);
//		}
	}
	public static void makeNegativeGeometricGraph()
	{
		int runsUntilThirdSuccess[] = new int[MAX_TRIALS];
		int result, runCount, successCount;
		
		for (int i =0; i < RUN_TIMES; i++)
		{
			runCount = 1;
			result = 0;
			successCount = 0;
			while(successCount < 3 && runCount < MAX_TRIALS)
			{
				runCount++;
				result = rollD20();
				if (result == CRIT)
				{
					successCount++;
				}
			}
			if(runCount < MAX_TRIALS)
				runsUntilThirdSuccess[runCount]++;
			else
			{
				runsUntilThirdSuccess[0]++;
				System.out.println("Error: Amount of trials before first success exceded array bounds.");
			}
		}
			
//			for(int i = 0; i <= 100; i++)
//			{
//				System.out.println("Number " + i + " : " + runsUntilThirdSuccess[i]);
//			}
	}
}
