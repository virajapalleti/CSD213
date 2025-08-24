
/*Write a program that displays current time in GMT in the format
hour:minute:second such as 1:45:19*/

package lab01;

public class CurrentTime {
    public static void main(String[] args) {
        long totalms = System.currentTimeMillis();

        long totalSecs = totalms / 1000;
        long currentSec = totalSecs % 60;

        long totalMins = totalSecs / 60;
        long currentMin = totalMins % 60;

        long totalHrs = totalMins / 60;
        long currentHr = totalHrs % 24;

        System.out.println("Current time (GMT): " + currentHr + ":" + currentMin + ":" + currentSec);
    }
}
