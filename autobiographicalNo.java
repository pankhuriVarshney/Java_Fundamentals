import java.util.*;
class autobiographicalNo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int copy=n;
        int count=0;
        while(copy>0)
        {
            count++;
            copy/=10;
        }
        int arr[]=new int[count];
        for(int i=count-1;i>=0;i--)
        {
            arr[i]=n%10;
            n/=10;
        }
        int c;
        boolean flag=true;
        for(int i=0; i<=9&&i<count;i++)
        {
            c=0;
            for(int j=0;j<count;j++)
            {
                if(arr[j]==i)
                c++;
            }
            if(!(c==arr[i]))
            {flag=false; break;}
        }
        if(flag)
        System.out.println("It is an autobiographical number");
        else
        System.out.println("It is not an autobiographical number");
        sc.close();
    }
}
