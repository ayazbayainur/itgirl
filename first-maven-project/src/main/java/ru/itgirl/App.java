package ru.itgirl;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan =  new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println( Weekdays.valueOf(input));
    }
}
