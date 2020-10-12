
public class Binary
{
    static String toBinaryString(int bin[])
    {
        String binary="";
        for(int i=0;i<bin.length;i++)binary+=bin[i];
        return binary;
    }

    static int[] toBinaryArray(String bin)
    {
        int binary[]=new int[bin.length()];
        for(int i=0;i<binary.length;i++)binary[i]=bin.charAt(i)-48;
        return binary;
    }
    
    static int toInteger(int bin[])
    {
        int dec=0,n=bin.length;
        for(int i=0;i<n;i++)
        {
            if(bin[i]==1)dec+=bin[i]*Math.pow(2,n-i-1);
        }
        return dec;
    }
    
    static boolean isZero(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==1)return false;
        }
        return true;
    }

    static String logicalShiftRight(String bin)
    {
        return "0"+bin.substring(0,bin.length()-1);
    }
    
    static void logicalShiftRight(int a[])
    {
        for(int i=a.length-1;i>0;i--)
        {
            a[i]=a[i-1];
        }
        a[0]=0;
    }

    static String arithmeticShiftRight(String bin)
    {
        return bin.charAt(0)+bin.substring(0,bin.length()-1);
    }
    
    static void arithmeticShiftRight(int a[])
    {
        for(int i=a.length-1;i>0;i--)
        {
            a[i]=a[i-1];
        }
    }
    
    static void logicalShiftLeft(int a[])
    {
        for(int i=0;i<a.length-1;i++)
        {
            a[i]=a[i+1];
        }
        a[a.length-1]=0;
    }
    
    static int[] twosComplement(int binary[])
    {
        int nbits=binary.length;
        int comp[]=new int[nbits];
        for(int i=0;i<nbits;i++)
        {
            if(binary[i]==0)comp[i]=1;
            else comp[i]=0;
        }
        for(int i=nbits-1;i>=0;i--)
        {
            if(comp[i]==1)comp[i]=0;
            else 
            {
                comp[i]=1;
                break;
            }
        }
        return comp;
    }
    
    static String twosComplement(String a)
    {
        String comp="";
        int i=a.length();
        do
        {
            i--;            
            comp=a.charAt(i)+comp;
        }while(a.charAt(i)-48==0);
        i--;
        
        while(i>=0)
        {
            if(a.charAt(i)-48==0)comp="1"+comp;
            else comp="0"+comp;
            i--;
        }
        
        return comp;
    }

    static String addBinary(String a,String b)
    {
        String result="";
        if(a.indexOf('.')==-1 && b.indexOf('.')==-1)//Both without decimal
        {
            while(a.length()>b.length())b="0"+b;
            while(a.length()<b.length())a="0"+a;
            int n=a.length(),sum=0,carry=0;
            for(int i=n-1;i>=0;i--)
            {
                sum=(a.charAt(i)-48)+(b.charAt(i)-48)+carry;
                if(sum==3)
                {
                    result="1"+result;
                    carry=1;
                }
                else if(sum==2)
                {
                    result="0"+result;
                    carry=1;
                }
                else
                {
                    result=sum+result;
                    carry=0;
                }
            }
            if(carry==1)result=carry+result;            
        }
        else if(a.indexOf('.')!=-1 && b.indexOf('.')!=-1)//both with decimal
        {            
            while(a.indexOf('.')>b.indexOf('.'))b="0"+b;
            while(a.indexOf('.')<b.indexOf('.'))a="0"+a;
            while(a.substring(a.indexOf('.')+1).length()>b.substring(b.indexOf('.')+1).length())b+="0";
            while(a.substring(a.indexOf('.')+1).length()<b.substring(b.indexOf('.')+1).length())a+="0";
            int n=a.length(),sum=0,carry=0;
            for(int i=n-1;i>=0;i--)
            {
                if(a.charAt(i)=='.')
                {
                    result="."+result;
                    continue;
                }
                sum=(a.charAt(i)-48)+(b.charAt(i)-48)+carry;
                if(sum==3)
                {
                    result="1"+result;
                    carry=1;
                }
                else if(sum==2)
                {
                    result="0"+result;
                    carry=1;
                }
                else
                {
                    result=sum+result;
                    carry=0;
                }
            }
            if(carry==1)result=carry+result;  
        }
        else
        {
            if(a.indexOf('.')!=-1)//a has decimal
            {
                result=addBinary(a.substring(0,a.indexOf('.')),b);
                result+=a.substring(a.indexOf('.'));
            }
            else //b has decimal
            {
                result=addBinary(a,b.substring(0,b.indexOf('.')));
                result+=b.substring(b.indexOf('.'));
            }
        }
        return result;
    }
    
    static int[] addBinary(int a[],int b[])
    {
        int carry=0,sum=0;
        int n=a.length;
        int result[]=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            sum=a[i]+b[i]+carry;
            if(sum==3)
            {
                result[i+1]=1;
                carry=1;
            }
            else if(sum==2)
            {
                result[i+1]=0;
                carry=1;
            }
            else
            {
                result[i+1]=sum;
                carry=0;
            }
        }
        result[0]=carry;
        return result;
    }
    
    static String subtractBinary(String a,String b)
    {
        int max=(a.length()>b.length())?a.length():b.length();
        while(a.length()<max)a="0"+a;
        while(b.length()<max)b="0"+b;
        b=twosComplement(b);
        String result=addBinary(a,b);
        if(result.length()==max)//carry is 0, answer is in 2's complement and negative
        {
            result=twosComplement(result);
            while(result.charAt(0)=='0')result=result.substring(1);
            result="-"+result;
        }
        else if(result.length()==max+1)//carry is 1, answer is in its true form and positive
        {
            result=result.substring(1);
            while(result.charAt(0)=='0')result=result.substring(1);
        }
        return result;
    }
    
    static String difference(String a,String b)
    {
        int max=(a.length()>b.length())?a.length():b.length();
        while(a.length()<max)a="0"+a;
        while(b.length()<max)b="0"+b;
        b=twosComplement(b);
        String result=addBinary(a,b);
        if(result.length()==max)//carry is 0, answer is in 2's complement and negative
        {
            result=twosComplement(result);
            while(result.charAt(0)=='0')result=result.substring(1);            
        }
        else if(result.length()==max+1)//carry is 1, answer is in its true form and positive
        {
            result=result.substring(1);
            while(result.charAt(0)=='0')result=result.substring(1);
        }
        return result;
    }
    
    static int[] difference(int a[],int b[])
    {
        int bComp[]=twosComplement(b);
        int tmpResult[]=addBinary(a,bComp);
        int result[]=new int[a.length];
        for(int i=0;i<result.length;i++)
        {
            result[i]=tmpResult[i+1];
        }
        if(tmpResult[0]==0)//no carry generated,answer is in twos complement
        {
            return twosComplement(result);
        }
        else//carry generated,discard carry
        {
            return result;
        }
    }

}