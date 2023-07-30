import java.util.*;
class reverseLink extends link
{
    static link reverse(link n)
    {
        link t1=n,t2,pp;
        t2=t1.p;
        n.p=null;
        pp=n;
        while(t2!=null)
        {
            t1=t2;
            t2=t2.p;
            t1.p=pp;
            pp=t1;
        }
        return t1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        link N=new link();
        N=null;
        System.out.print("Enter length of the list: ");
        int l=sc.nextInt();
        System.out.println("Enter elements: ");
        for(int i=1;i<=l;i++)
        N=push(sc.nextInt(), N);
        System.out.println("ORIGINAL LIST:"); print(N);
        N=reverse(N);
        System.out.println("REVERSED LIST:"); print(N);
        sc.close();
    }
}

