
import java.util.Scanner;

public class kapreka {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number: ");
    int number = input.nextInt();

    System.out.println("For the input: "+number);
    int step = 0;
    while (number != 6174 && step != 10) {
      int[] arr = Arr(number);
      int[] smallArr = sortArr(arr, "small");
      int[] highArr = sortArr(arr, "high");

      int smallNum = num(smallArr);
      int highNum = num(highArr);
      number = highNum - smallNum; 
      if((number+"").length() == 3) number*=10; // To avoid a large number of missing 0
      step++;

      System.out.println(step+". "+highNum +" - "+smallNum+" = "+number); 
    }
    
    System.out.println("Total steps: "+step);

  }

  public static int num(int[] arr) {
    int num = 0;
    for(int i=pow(10, arr.length-1), k=0; k<arr.length; i/=10, k++) num+=arr[k]*i;
    return num;
  }

  public static int[] sortArr(int[] arr, String smallorhigh) {
    int[] temp = arr.clone();
    for(int i=0; i<arr.length-1; i++) {
      int preNum = temp[i];
      int othNum = temp[i+1];
      if(preNum > othNum && "small".equals(smallorhigh) || preNum < othNum && "high".equals(smallorhigh)) { // Compare number to number on its right with the number itself.
        temp[i] = othNum;
        temp[i+1] = preNum;
      }
    }

    for(int i=0;i<temp.length;i++) if(temp[i] != arr[i]) return sortArr(temp, smallorhigh); // This function needs to run repeatedly because it shifts the numbers "one by one".
    return temp;
  }

  public static int[] Arr(int number) {
    int length = (number+"").length();
    int[] numberArr = new int[length];

    for(int i=0; i<length; i++) {
      numberArr[i] = number%10;
      number/=10;
    }

    return numberArr;
  }

  public static int pow(int a, int b) {
    int res = 1;
    for(int i=0; i<b; i++) res*=a;
    return res;
  }
}
