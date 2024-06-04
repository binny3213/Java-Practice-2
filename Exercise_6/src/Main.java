import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		Rational r1 = new Rational();
		Rational r2 = new Rational();
		boolean errorInInput = true;
		while(errorInInput)
		{
			int r1Numerator = getUserInteger("Enter 1st rational number numerator:", true);
			int r1Denominator = getUserInteger("Enter 1st rational number denominator:", false);
			int r2Numerator = getUserInteger("Enter 2st rational number numerator:", true);
			int r2Denominator = getUserInteger("Enter 2st rational number denominator:", false);


			try
			{
				r1 = new Rational(r1Numerator,r1Denominator);
				r2 = new Rational(r2Numerator,r2Denominator);
				errorInInput = false;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Denominator is zero, enter again");
			}

		}

		comperisonResultString("= ",r1,r2,r1.equals(r2));
		comperisonResultString("> ",r1,r2,r1.greaterThan(r2));
		
		Rational resultedRational = new Rational(r1);
		resultedRational.plus(r2);
		operationResultString("+ ", r1,r2, resultedRational);
		
		resultedRational = new Rational(r1);
		resultedRational.minus(r2);
		operationResultString("- ", r1,r2, resultedRational);
		
		resultedRational = new Rational(r1);
		resultedRational.multiply(r2);
		operationResultString("x ", r1,r2, resultedRational);
		
		resultedRational = new Rational(r1);
		try
		{
			resultedRational.devide(r2);
			operationResultString("/ ", r1,r2, resultedRational);
		}
		catch(ArithmeticException e)
		{
			System.err.println("Devide by zero error while calculating: " + r1 + "/" + r2);
		}
	}
	
		public static void operationResultString(String operation, Rational r1, Rational r2, Rational operationResult)
		{
			System.out.println(r1 + operation + r2 + "= " + operationResult);
		}
		public static void comperisonResultString(String comperison, Rational r1,Rational r2,boolean comperisononResult)
		{
			System.out.println(r1 + comperison + r2 + "is" + (comperisononResult?"":" not") + " true");
		}

		public static int getUserInteger(String message, boolean zeroIsAllowed)
		{
			System.out.println(message);
			int result = 1;
			while(true)// loop untill legal value is entered
			{
				String resultStr = "";
				BufferedReader reader;
				try
				{
					reader = new BufferedReader(new InputStreamReader(System.in));
					resultStr = reader.readLine();
				}
				catch(IOException e)
				{
					System.err.println("Can not read user input");
				}
				try
				{
					result = Integer.parseInt(resultStr);
				}
				catch(NumberFormatException e)
				{
					System.err.println("Error: Input is not an integer");
					result = Integer.MAX_VALUE;
				}

				if(!zeroIsAllowed && (0 == result))
				{
					System.err.println("Error: denominator can not be zero");
					result = Integer.MAX_VALUE;
				}

				if(Integer.MAX_VALUE!= result)
				{
					break;
				}
			}
			
			return result;

		}

}
