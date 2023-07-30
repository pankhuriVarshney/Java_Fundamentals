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
            boolean flag=true;
            for(int a=len-1;a>=0;a--)
            {
                num[a]=temp%10;
                temp/=10;
            }
            for(int t=0;t<len;t++)
            {for(int j=0;j<len-1;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    if(num[j]==num[k])
                    {
                        if(num[k]==9)
                        { flag=nine(k);
                            if(!flag) break; }                    
                        else
                        {num[k]++;}
                    }
                }
            }}
            temp=0;
            for(int j=0;j<len;j++)
            {temp=temp*10+num[j];}
            i=temp+1;
            if(temp>upper) break;
            else if(!flag) continue;
            System.out.println(temp);
            f++; 
        }
        return f;
    }    
    protected static boolean nine(int k)
    { 
        boolean flag=false;
        for(int j=0;j<len;j++)
        if(num[j]!=9) {flag=true; break;}
        if(flag)
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
        return true;
        }
        else return false;
    }
   public static void main(String args[])
   {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the lower limit: ");
        int l=sc.nextInt();
        System.out.print("Enter the upper limit: ");
        int u=sc.nextInt();
        int f=uniqueNumber.unique(l,u);
        System.out.println("FREQUENCY:  "+f);
        sc.close();
   }
}