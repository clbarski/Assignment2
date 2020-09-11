import java.util.*;

public class Assignment2
{

	//Function to sort the array
	public static void selectSort(int arr[])
	{
		int n = arr.length;

		//Nested for loop to compare the 2 positions and determine which is smallest
		for(int i = 0; i<n-1; i++)
		{
			int smallest = i;
			for(int j = i+1; j<n; j++)
			{
				if(arr[j] < arr[smallest])
				{
					smallest = j;
				}
			}

			//At the end of the 2nd loop, makes the change needed
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
		}
	}

	//Array to find the 2 positions that add to the target sum
	public static int[] twoSum(int arr[], int target)
	{
		int n = arr.length;

		//Nested for loop to compare the two positions in the array and see if they sum to the target
		for(int i = 0; i<n-1; i++)
		{
			int current = i;

			//If what is at the index is greater than the target, then the sum does not exist
			if(arr[i] > target)
			{
				break;
			}
			for(int j = i+1; j<n; j++)
			{
				//If the numbers are the same, return -1
				if(arr[current] == arr[j])
				{
					return new int[] {-1};
				}
				
				int sum = arr[current] + arr[j];

				//Since the array is sorted, if the sum is larger than the target, the break out of the 2nd loop
				if(sum > target)
				{
					break;
				}
				//If the sum equals the target, return their positions
				else if(sum == target)
				{
					return new int[] {i, j};
				}
			}
		}

		//If no sum is found, return -1
		return new int[] {-1};
	}

	//Function to print the array
	public static void printArray(int arr[])
	{
		int n = arr.length;
		for(int i = 0; i<n; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	//Main function
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		int[] arr = {24,3,16,11,9,4,19,30};

		System.out.print("The array: ");
		printArray(arr);
		System.out.print("\nThe array sorted: ");
		selectSort(arr);
		printArray(arr);

		System.out.print("\nEnter the target sum: ");
		int target = input.nextInt();

		int[] sumArr = twoSum(arr,target);
		System.out.print("\nThe output is: ");
		for(int i = 0; i<sumArr.length; i++)
		{
			System.out.print(sumArr[i]+" ");
		}

	}

}