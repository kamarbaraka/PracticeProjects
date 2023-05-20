import java.util.*;

/**
 * a simple console lottery program to draw numbers and win on combination
 * @author kamar baraka
 * @version 1.0
 * @since 20/05/20203 16:00
 * */

public class LotteryDrawing {
    public static void main(String[] args){
        DataCollection collection = new DataCollection();
        var result = new ResultComputation(collection);
    }
}

class DataCollection {
    int numbersToDraw, highestNumber;
    public DataCollection(){
        //create a scanner and attach the input stream to get user input
        Scanner input = new Scanner(System.in);
        var prompt = System.out;
        prompt.println("how many number do you need to draw? ");
        numbersToDraw = input.nextInt();
        prompt.println("what is the highest number you can draw");
        highestNumber = input.nextInt();
    }
}

class ResultComputation{
    /**@param data a DataCollection object.*/
    public ResultComputation(DataCollection data){
        //create an array to hold the numbers to draw from
        int[] numbers = new int[data.highestNumber];
        //fill the array
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 1;

        //create an array to hold the combination result of the user
        int[] result = new int[data.numbersToDraw];

        //define a random offset to draw the values from the numbers
        int randomIndex = (int) (Math.random() * data.highestNumber);

        //fill the result array with random numbers drawn from the numbers
        for (int i = 0; i < result.length; i++){
            result[i] = numbers[randomIndex];
            //move the used number so it cant be repeated
            numbers[randomIndex] = numbers[data.highestNumber -1];
            data.highestNumber--;
        }
        //sort the result combination and print it
        Arrays.sort(result);
        System.out.println("your result is : ");
        for (Object item : result)
            System.out.printf("%s ", item);
    }
}
