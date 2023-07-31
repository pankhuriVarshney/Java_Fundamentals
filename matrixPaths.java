import java.util.*;
class matrixPath
{
    static void copy(char[] c1, char[] c2)
    {
        for(int i=0;i<c1.length;i++)
        c1[i]=c2[i];
    }
    static void swap(char[] c)
    {
        char t=c[0];
        for(int i=0;i<c.length-1;i++)
        c[i]=c[i+1];
        c[c.length-1]=t;
    }
    static boolean compare(char[]c1, char[] c2)
    {
        boolean flag=true;
        for(int i=0;i<c1.length;i++)
        if(c1[i]!=c2[i]){ flag=false; break;}
        return flag;
    }
    public static void main()
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter no. of rows: ");
        int n=sc.nextInt();
        System.out.print("Enter no. of columns: ");
        int m=sc.nextInt();
        int A[][]=new int[n][m];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++){
            System.out.print("a["+i+"]["+j+"]= "); A[i][j]=sc.nextInt();}
        System.out.println("MATRIX:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            System.out.print(A[i][j]+"\t");
            System.out.println();
        }
        int f=0;
        char path[]=new char[n+m-2];
        char copy[]=new char[n+m-2];
        int j=0,k=0;
        int n1=n,m1=m;
        for(int i=0;i<Math.ceil((float)n/2);i++)
        {
            for(j=0;j<n1-1;j++)
            path[j]='D';
            for(k=j;k<m1-2+n1;k++)
            path[k]='R';
            int temp=0;
            while(k<path.length)
            path[k++]=(temp++%2==0)?'D':'R';
            n1--;
            m1--;
            copy(copy,path); 
            //copy=Arrays.copyOf(path, path.length);
            int a=0,b=0; 
            do
            {
                System.out.print(A[a][b]);
                for(int h=0;h<copy.length;h++)
                if(copy[h]=='D') System.out.print("-->"+A[++a][b]);
                else System.out.print("-->"+A[a][++b]);
                f++;a=0;b=0;
                swap(copy);
                System.out.println();
            }
            while(!compare(copy,path));
        }
        System.out.println("TOTAL NUMBER OF PATHS: "+f);
        sc.close();
    }
}
