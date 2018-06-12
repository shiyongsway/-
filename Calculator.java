import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        float c,d;
        double temp=0,sum=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // String b=" 3+8*8-9/8 ";
       String b=br.readLine();
        b=b.replaceAll("[\\s,=]","");
        String[] a =b.split("[+,\\-,*,/]");

        Stack<String> stackNum = new Stack<String>();
        Stack<Character> stackOper = new Stack<Character>();
        for (int i =0 ; i<a.length; i++) {
            {
                System.out.println(a[i]);
                stackNum.push(a[i]);
            }
        }
        for (int i =0 ; i<b.length(); i++) {
            {


                if (b.charAt(i) == '+' || b.charAt(i) == '-' || b.charAt(i) == '*' || b.charAt(i) == '/')
                {
                    stackOper.push(b.charAt(i)); //压栈
                }
            }
        }
        while (!stackNum.empty()) {
            char content=' ';
            if(!stackOper.isEmpty())
            {
                content = stackOper.pop();
            }else{
                if(!stackNum.isEmpty())
                {
                    sum = sum+Double.parseDouble(stackNum.pop()) ;
                }
            }

            if (content=='+')
            {
                sum = sum+Double.parseDouble(stackNum.pop());
            }else if (content=='-')
            {
                sum =sum-(Double.parseDouble(stackNum.pop()));
                System.out.println("sum111"+sum);
            }else if(content=='*'||content=='/')
            {
                if(content=='*')
                {
                    temp = (Double.parseDouble(stackNum.pop()))*(Double.parseDouble(stackNum.pop()));
                }else{
                    Double f =Double.parseDouble(stackNum.pop());
                    Double g =Double.parseDouble(stackNum.pop());
                    temp =g/f;
                    System.out.println("fff"+f);
                    System.out.println("ggg"+g);
                    System.out.println("CCC"+temp);
                }
                while (!stackOper.empty())
                {
                    content = stackOper.pop();
                    if (content=='+'||content=='-')
                    {
                        if(content=='+')
                        {
                            break;
                        }
                        else if(content=='-')
                        {
                            temp =-temp;
                            break;
                        }
                    }
                    else if(content=='*')
                    {
                        temp = (Double.parseDouble(stackNum.pop()))*temp;
                    }
                    else if (content=='/'){
                        temp = (Double.parseDouble(stackNum.pop()))/temp;
                    }
                }
                sum = sum+temp;
            }
            System.out.println("temp"+temp);
            System.out.println("sum"+sum);

        }

        System.out.println(sum);

    }
}


















