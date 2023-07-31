import java.util.*;
class binaryAddition
{
    static String add(String b1, String b2)
    {
        String sum=""; int carry=0;
        for(int i=0;i<(int)Math.min(b1.length(),b2.length());i++)
        {
            char c=(char)((int)b1.charAt(i)+(int)b2.charAt(i)+carry+1-(Math.max((int)b1.charAt(i),(int)b2.charAt(i))));
            if(c=='1'||c=='0')
            {sum=c+sum; carry=0;}
            else if(c=='2')
            {sum='0'+sum; carry=1;}
            else if(c=='3')
            {sum='1'+sum;carry=1;}
        }
        if(b1.length()>b2.length())
        {
            for(int i=b2.length();i<b1.length();i++)
            {
                char c=(char)((int)b1.charAt(i)+carry);
                if(c=='1'||c=='0')
                {sum=c+sum; carry=0;}
                else if(c=='2')
                {sum='0'+sum;carry=1;}
            }
        }
        else if(b1.length()<b2.length())
        {
            for(int i=b1.length();i<b2.length();i++)
            {
                char c=(char)((int)b2.charAt(i)+carry);
                if(c=='1'||c=='0')
                {sum=c+sum; carry=0;}
                else if(c=='2')
                {sum='0'+sum;carry=1;}
            }
        }
        if(carry==1) sum='1'+sum;
        return sum;
    }
    static String reverse(String b)
    {
        String r="";
        for(int i=b.length()-1;i>=0;i--)
        r+=b.charAt(i);
        return r;
    }
    static int decimal(String s)
    {
        int dec=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            dec+=(int)(Math.pow(2,i));
        }
        return dec;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two binary numbers to be added: ");
        String b1=sc.next(), b2=sc.next();
        String sum=add(reverse(b1), reverse(b2));
        System.out.println("BINARY NUMBER 1: "+b1+"\tDECIMAL: "+decimal(reverse(b1))+"\nBINARY NUMBER 2: "+b2+"\tDECIMAL: "+decimal(reverse(b2))+"\nSUM: "+sum+"\tDECIMAL: "+decimal(reverse(sum)));
        sc.close();
    }
}
