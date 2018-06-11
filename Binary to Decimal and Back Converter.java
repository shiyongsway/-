import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class alarm {
    public static void main(String[] args) throws IOException {
        String value = "";
        String input = "";
        double sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        if (input.charAt(input.length()-1) == 'b') {
            input = input.substring(0,input.length()-1);
            for (int i = 0; i <= input.length() -1; i++) {
                sum = (input.charAt(i) - 48) * Math.pow(2, input.length()-i-1) + sum;

            }
            System.out.println(sum);
        } else {
            int number = Integer.parseInt(input);
            do {
                value = number % 2 + value + "";
                number = number / 2;
            } while (number != 0);
            System.out.println(value);
        }
    }
}