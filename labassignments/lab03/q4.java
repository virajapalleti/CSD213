
package lab03;
import java.util.*;

//display number of objs of  class
class CountObj{
    static int count = 0;
    public CountObj() {
        count++;
    }
    static void result() {
        System.out.println("no. of objs: " + count);
    }
}

public class q4 {
    public static void main(String[] args) {
        CountObj object = new CountObj();
        CountObj object02 = new CountObj();
        CountObj.result();
    }
}