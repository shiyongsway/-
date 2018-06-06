
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class onlyTest
{

    public static void main(String[] args) throws IOException {

        System.out.println("Please input your expression only support sum");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        process(bf.readLine());


    }

    public static void process(String str)
    {
        String REGEX = "/";
        String REGEX1 ="\\+";;
        String INPUT = str;


        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        Pattern p1 =Pattern.compile(REGEX1);
        Matcher m1 = p1.matcher(INPUT);

        float numerator,denominator;
        int operatorPosition=0;
        float finalnumber=0;
        while (m1.find())
        {
            m.find();//剩余最后一个数据，需要到后面进行处理
            numerator =Integer.parseInt(INPUT.substring(operatorPosition,m.start()));
            denominator = Integer.parseInt(INPUT.substring(m.end(),m1.start()));
            finalnumber = finalnumber + numerator/denominator;

            operatorPosition=m1.end();
//            System.out.println("m.end()"+m.end());
//            System.out.println("m.start()"+m.start());
//            System.out.println("sum"+finalnumber);
//            System.out.println("numerator"+numerator);
//            System.out.println("denominator"+denominator);
        }

        if(m.find())
        {
            numerator =Integer.parseInt(INPUT.substring(operatorPosition,m.start()));
            denominator = Integer.parseInt(INPUT.substring(m.end()));
            finalnumber = finalnumber+numerator/denominator;
            System.out.println("sum"+finalnumber);
//            System.out.println("numerator"+numerator);
//            System.out.println("denominator"+denominator);

        }

    }
}
