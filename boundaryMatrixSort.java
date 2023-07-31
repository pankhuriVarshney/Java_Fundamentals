import java.util.*;
class boundarySort
{
    static int a[][];
    static int n, m;
    static void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        m=sc.nextInt();
        System.out.print("Enter number of columns:");
        n=sc.nextInt();
        a=new int[m][n];
        System.out.println("Enter the elements:");
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        a[i][j]=sc.nextInt();
        sc.close();
    }
    static void output()
    {
        for(int i=0;i<m;i++){
        for(int j=0;j<n;j++)
        System.out.print(a[i][j]+"\t");
        System.out.println();}
    }
    public static void main(String args[])
    {
        input();
        System.out.println("ORIGINAL MATRIX:");
        output();
        int temp[]=new int[m*n-2];
        int index1=0;
        for(int i=0;i<m;i++)
        {
            if(i==0||i==m-1)
            for(int j=0;j<n;j++)
            {
                temp[index1++]=a[i][j];
            }
            else
            {temp[index1++]=a[i][0];
             temp[index1++]=a[i][n-1];
            }
        }
        Arrays.sort(temp);
        index1=0;
        int index2=m*n-3;
        for(int i=0;i<m;i++)
        {
            if(i==0||i==m-1)
            for(int j=0;j<n;j++)
            {
                if(i==0)
                a[i][j]=temp[index1++];
                else
                a[i][j]=temp[index2--];
            }
            else
            {
                a[i][0]=temp[index2--];
                a[i][n-1]=temp[index1++];
            }
        }
        System.out.println("SORTED MATRIX:");
        output();
    }
}
 
    
