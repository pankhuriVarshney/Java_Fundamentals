import java.util.*;
class link
{
    link p;
    int a;
    static int b;
    static link push(int t, link begin)
    {
        link nn=new link();
        nn.a=t;
        nn.p=null;
        if(begin==null)
            begin=nn; 
        else if( begin.p==null)
            begin.p=nn; 
        else
        {
            link pp=new link();
            pp=begin;
            while(pp.p!=null)
            pp=pp.p;
            pp.p=nn;
        }
        return begin;
    }
    static link pop(link a)
    {
        b=a.a;
        if(a!=null)
        {
            a=a.p;
        }
        return a;
    }
    static void print(link t)
    {
        while(t!=null)
        {
            System.out.print(t.a+"\t");
            t=t.p;
        }
        System.out.println();
    }
}

class sum extends link
{
    static link ans=new link();
    static link l1=new link();
    static link l2=new link();
    static link add()
    {
        int sum=0, carry=0, b1, b2;
        while(!(l1==null||l2==null))
        {
            l1=pop(l1); b1=l1.b;
            l2=pop(l2); b2=l2.b;
            sum+=(b1+b2+carry)%10;
            carry=(b1+b2+carry)/10;
            ans=push(sum, ans);
            sum=0;            
        }
        if(l1!=null)
        while(l1!=null)
        {
            l1=pop(l1);
            sum+=(l1.b+carry)%10;
            carry=(l1.b+carry)/10;
            ans=push(sum, ans);
            sum=0;
        }
        else if(l2!=null)
        while(l2!=null)
        {
            l2=pop(l2);
            sum+=(l2.b+carry)%10;
            carry=(l2.b+carry)/10;
            ans=push(sum, ans);
            sum=0;
        }
        if(carry>0)
        ans=push(carry, ans);
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("LIST 1:\nEnter size of list one: ");
        int n1=sc.nextInt();
        l1=null;
        System.out.println("Enter elements in the list:");
        for(int i=1;i<=n1;i++)
        {
            l1=link.push(sc.nextInt(),l1);
        }
        System.out.print("LIST 2:\nEnter size of list one: ");
        int n2=sc.nextInt();
        l2=null;
        System.out.println("Enter elements in the list:");
        for(int i=1;i<=n2;i++)
        {
            l2=link.push(sc.nextInt(),l2);
        }
        System.out.print("LIST 1: ");
        print(l1);
        System.out.print("LIST 2: ");
        print(l2);
        ans=null;
        System.out.println("LIST 1 + LIST 2: ");
        ans=add();
        print(ans);
        sc.close();
    }
}