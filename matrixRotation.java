import java.util.*;
class matrixRot
{
    static int a[][],n,r;
    static void clockwise()
    {
        int n1=n;
        while(r>0)
        {
            for(int i=0,t=1;i<n1/2;i++,t--)
            {
                int temp1=a[i][i], temp2=a[n-1][n-1];
                int f1,f2;
                for(int j=i+1;j<n;j++)
                {
                    f1=a[i][j];
                    a[i][j]=temp1;
                    temp1=f1;
                    f2=a[n-1][n-j-t];
                    a[n-1][n-j-t]=temp2;
                    temp2=f2;
                }
                for(int k=i+1;k<n;k++)
                {
                    f1=a[k][n-1];
                    a[k][n-1]=temp1;
                    temp1=f1;
                    f2=a[n-k-t][i];
                    a[n-k-t][i]=temp2;
                    temp2=f2;
                }
                n--;
            }
            n=n1;
            r--;
        }
    }
    static void anticlockwise()
    {
        int n1=n;
        while(r>0)
        {
            for(int i=0,t=1;i<n1/2;i++,t--)
            {
                int temp1=a[i][n-1], temp2=a[n-1][i];
                int f1,f2;
                for(int j=i+1;j<n;j++)
                {
                    f1=a[i][n-j-t];
                    a[i][n-j-t]=temp1;
                    temp1=f1;
                    f2=a[n-1][j];
                    a[n-1][j]=temp2;
                    temp2=f2;
                }
                for(int k=i+1;k<n;k++)
                {
                    f1=a[k][i];
                    a[k][i]=temp1;
                    temp1=f1;
                    f2=a[n-k-t][n-1];
                    a[n-k-t][n-1]=temp2;
                    temp2=f2;
                }
                n--;
            }
            n=n1;
            r--;
        }
    }
    static void print()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)            System.out.print(a[i][j]+"\t");
            System.out.println();
        }
    }

    public static void main()
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter size of the matrix: ");
        n=sc.nextInt();
        a=new int[n][n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            System.out.print("a["+i+"]["+j+"]= "); a[i][j]=sc.nextInt();}
        System.out.print("Enter the rotation factor: ");
        r=sc.nextInt();
        System.out.print("Enter 1: for clockwise rotation\nEnter 2: for anti-clockwise rotation\nEnter your choice: ");
        int ch=sc.nextInt();
        System.out.println("ORIGINAL MATRIX:");
        matrixRot.print();
        switch(ch)
        {
            case 1: 
                matrixRot.clockwise();
                break;
            case 2: 
                matrixRot.anticlockwise();
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("MATRIX AFTER ROTATION: ");
        matrixRot.print();
        sc.close();
    }
}
