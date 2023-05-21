import java.io.PrintStream;
import java.time.LocalDate;

/**
 * a simple java program to simulate the months calendar
 * @author kamar baraka
 * @version 1.0
 * @since 21/05/2023 14:39
 * */

public class Calendar {
    public static void main(String[] args){
        simulation();
    }
    private static void simulation(){
        var date = LocalDate.now();
        var weekDay = date.getDayOfWeek();
        var today = date.getDayOfMonth();
        var month = date.getMonthValue();
        var weekDayValue = weekDay.getValue();
        date = date.minusDays(today - 1);

        //create an array to hold days of the week
        String[] daysOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        PrintStream prompt = System.out; //create an output stream object
        //display the days of the week
        for (String eachDay : daysOfTheWeek)
            prompt.printf("%3s ", eachDay);
        prompt.println();
        //prompt.print("h");
        for (int i = 7; i <= weekDayValue; i++)
            prompt.print("   ");

        while (date.getMonthValue() == month){
            prompt.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                prompt.print("*");
            else prompt.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7)
                prompt.println();
        }
        if (date.getDayOfWeek().getValue() != 7)
            prompt.println();
    }
}
