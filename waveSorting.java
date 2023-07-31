import java.util.*;
class wave
{
   public static void main(String args[])
   {
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter the number of elements: ");
       int n=sc.nextInt();
       int a[]=new int[n];
       System.out.println("Enter the elements of the array: ");
       for(int i=0;i<n;i++)
       a[i]=sc.nextInt();
       int temp=0;
       Arrays.sort(a);
       for(int i=0;i<a.length-1;i++)
           for(int j=i+1;j<a.length;j++)
           {
               if(i%2==0)
                 if(a[i]<=a[j])
                   {
                      temp=a[i];
                      a[i]=a[j];
                      a[j]=temp;
                   }
            }
        System.out.println("SORTED ARRAY:\t"+Arrays.toString(a));
        sc.close();
    }
}