import java.util.*;
class circularQueue
{
    static int r=-1,f=-1;
    static int n,e=0;
    static int a[];
    static void push(int t)
    {
        if(r<n-1&&r!=f)
        {
            a[++r]=t; e++;
        }
        else if(r==n-1&&f!=-1)
        {
            r=0;
            a[r]=t;
            e++;
        }
        else if(r==n-1&&f==-1)
        System.out.println("QUEUE FULL. CANNOT BE PUSHED");
        else if(r==f&&e==n)
        System.out.println("QUEUE FULL. CANNOT BE PUSHED");
        else if (r==f&&e==0)
        {
            a[++r]=t; e++;
        }
    }
    static void pop()
    {
        if(f<n-1&&f!=r)
        {a[++f]=0;e--;}
        else if(f==n-1&&r!=-1&&e!=0)
        {
            f=0;
            a[f]=0;
            e--;
        }
        else if(f==n-1&&r==-1)
        { System.out.println("QUEUE EMPTY. CANNOT BE POPPED"); r=-1;f=-1;}
        else if(r==f && e==0)
        {
            System.out.println("QUEUE EMPTY. CANNOT BE POPPED"); r=-1;f=-1;
        }
        else if (r==f&&e==n)
        {
            a[++f]=0;
            e--;
        }
    }
    static void print()
    {
        //System.out.println(Arrays.toString(a));
        if(f<r)
        {
            for(int i=f+1;i<=r;i++)
            System.out.print(a[i]+"\t");
            System.out.println();
        }
        else if(r<=f&&e!=0)
        {
            for(int i=f+1;i<n;i++)
            System.out.print(a[i]+"\t");
            for(int i=0;i<=r;i++)
            System.out.print(a[i]+"\t");
            System.out.println();
        }
        else
        System.out.println("EMPTY QUEUE");
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length of queue: ");
        n=sc.nextInt();
        a=new int[n];
        while(true)
        {
            System.out.print("Enter 1: to push\nEnter 2: to pop\nEnter 3: to print\nEnter 4: to exit\nEnter your choice: ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    System.out.print("Enter value to be pushed: ");
                    push(sc.nextInt());
                }
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    print();
                    break;
                case 4:
                    {System.exit(0); 
                    sc.close();}
                default:
                    System.out.println("Invalid Choice!");
            }
        }    

    }
}
