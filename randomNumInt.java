//Note: Randomizer function has been created but hasn't been implemented anywhere yet. It is used in main function
//	to give a test output. It has no impact on the generated number yet.
import java.util.Calendar;
import java.util.Scanner;

public class randomNumInt {
	
	static int randomTime;
	
	//DateFactor Function
	static int dateFactor()
	{
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.YEAR) + 10000 * cal.get(Calendar.MONTH) + 1000000 * cal.get(Calendar.DATE) +10000;
		return (date*10);
	}
	
	//TimeFactor function
	static int timeFactor()
	{
	    randomTime = (int)System.currentTimeMillis();
		return(randomTime);
	}
	
	static int reverseTimeFactor()
	{
		int reverseTime = randomTime;
		int reverse=0;
		while(reverseTime != 0)
	      {
	          reverse = reverse * 10;
	          reverse = reverse + reverseTime%10;
	          reverseTime = reverseTime/10;
	      }
		return (reverse);
		
	}
	
	static int inputMin()
	{
		@SuppressWarnings("resource")
		Scanner ip = new Scanner(System.in);
		int inputMin = ip.nextInt();
		return(inputMin);
	}
	
	static int inputMax()
	{
		@SuppressWarnings("resource")
		Scanner ip = new Scanner(System.in);
		int inputMax = ip.nextInt();
		return (inputMax);
	}
	
	static int rangeDivideOverTen(int randomNum, int min, int max)
	{
		do
		{
			randomNum = randomNum / 10;
			if (randomNum < min)
				while (randomNum <= min)
					randomNum += 10;
		} while (randomNum > max);
		return (randomNum);
	}
	static int rangeDivideUnderTen(int randomNum, int min, int max)
	{
		do
		{
			randomNum = randomNum / 10;
			if (randomNum < min)
				while (randomNum <= min)
					randomNum += 10;
		} while (randomNum > max *10);
		
		while (randomNum > max)
			randomNum = randomNum - (max - min);
		return (randomNum);
	}
	static int randomizer(int randomNum)
	{
		int lastDigit = randomNum % 10;
		int tempRandomNum = randomNum;
		if(lastDigit == 0)
		{
			return(lastDigit);
		}
		else
		{
			while(tempRandomNum / 10 != 0)
			{
				lastDigit *= 10;
				tempRandomNum /= 10;
			}
		
			System.out.println("tempRandomNum = " +tempRandomNum);
			System.out.println("lastDigit = " +lastDigit);
			System.out.println("randomNum = " +randomNum);
			return(lastDigit);
		}
	}
	
	//Main function begins here
	public static void main(String[] args)
	{
		int randomNum = (timeFactor() - reverseTimeFactor() * dateFactor());
		
		System.out.println("Enter the minimum number");
		int min = inputMin() - 1;
		System.out.println("Enter the maximum number");
		int max = inputMax();
		randomizer(randomNum);
		
		if(min >= 0 && randomNum < 0)
			randomNum = randomNum * (-1);
		
		if (min+1 == max)
		{
			System.out.println("Invalid Range.");
			System.exit(0);
		}
		
		if (min > max)
		{
			System.out.println("Minimum number must not be greater than maximum number");
			System.exit(0);
		}
		
		if (max > 10)
		{
			randomNum = rangeDivideOverTen(randomNum, min, max);
		}
		
		else
		{
			randomNum = rangeDivideUnderTen(randomNum, min, max);
		}

		System.out.println(randomNum);
	}
}
