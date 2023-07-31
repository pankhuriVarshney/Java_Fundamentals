import java.util.*;
class kaprekarMysteryNo
{
    static void sort(int[] a, char c)
    {
        int temp;
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if((c=='D')?(a[j]>a[i]):(a[j]<a[i]))
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    static int integer(int a[])
    {
        int n=0;
        for(int i=0;i<a.length;i++)
        n=(n*10)+a[i]; 
        return n;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the number of digits (3 or 4): ");
        int n=sc.nextInt();
        if(!(n==3||n==4))
        {
            System.out.println("KAPREKAR'S MYSTERY NUMBER DOES NOT EXIST FOR "+n+" DIGITS.");
            System.exit(0);
        }
        int number[]=new int[n];
        for(int i=0;i<n;i++)
        number[i]=i+1;
        int copy[];
        int d=0, pd=1;
        do
        {
            pd=d;
            copy=Arrays.copyOf(number, n);
            sort(copy,'D');
            sort(number,'A');
            d=integer(copy)-integer(number);
            int temp=d;
            for(int i=n-1;i>=0;i--)
            {
                number[i]=temp%10;
                temp/=10;
            }
        }
        while(d!=pd);      
        System.out.println("KAPREKAR'S MYSTERY NUMBER: "+d);
        sc.close();
    }
}
