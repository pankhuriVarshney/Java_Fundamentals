import java.util.*;
class uniqueNumber
{
    static int num[];
    static int len;
    protected static int unique(int lower, int upper)
    {
        int i=lower;
        int f=0;
        while(i<=upper)
        {
            len=Integer.toString(i).length();
            num=new int[len];
            int temp=i;
            for(int a=len-1;a>=0;a--)
            {
                num[a]=temp%10;
                temp/=10;
            }
            //System.out.println(Arrays.toString(num));
            for(int t=0;t<len;t++)
            {for(int j=0;j<len-1;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    if(num[j]==num[k])
                    {
                        if(num[k]==9)
                        { nine(num, k); }                    
                        else
                        {num[k]++;}
                    }
                }
            }}
            //System.out.println(Arrays.toString(num));
            temp=0;
            for(int j=0;j<len;j++)
            {temp=temp*10+num[j];}
            //System.out.println(temp);
            i=temp+1;
            if(temp>upper) break;
            System.out.println(temp);
            f++; 
        }
        return f;
    }    
    protected static void nine(int num[], int k)
    { 
        int temp=0;
        for(int j=0;j<len;j++)
        {temp=temp*10+num[j];}
        temp+=(10*(len-1-k));
        for(int j=len-1;j>=0;j--)
        {
            num[j]=temp%10;
            temp/=10;
        }
        System.out.println("nine"+Arrays.toString(num));
    }
   public static void main(String args[])
   {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the lower limit:");
        int l=sc.nextInt();
        System.out.println("Enter the upper limit:");
        int u=sc.nextInt();
        int f=uniqueNumber.unique(l,u);
        System.out.println("FREQUENCY:  "+f);
        sc.close();
   }
}