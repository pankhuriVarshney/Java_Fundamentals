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
            for(int t=1;t<=len;t++)
            {for(int j=0;j<len-1;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    if(num[j]==num[k])
                    {
                        if(num[k]==9)
                        { num[k-1]++;   num[k]=0;   break;}                    
                        else
                        {num[k]++;}
                    }
                }
            }}
            temp=0;
            for(int j=0;j<len;j++)
            temp=temp*10+num[j];
            System.out.println(temp);
            f++; 
        }
        return f;
    }
    }
   public static void main(String args[])
   {
        
   }

}