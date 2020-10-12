
import java.util.Arrays;
public class IEEEFloatingPointNumber
{
    int signBit;
    int biasedExponent[];
    int mantissa[];
    IEEEFloatingPointNumber(int signBit,int biasedExponent[],int mantissa[])
    {
        this.signBit=signBit;
        this.biasedExponent=new int[8];
        for(int i=0;i<this.biasedExponent.length;i++)
            this.biasedExponent[i]=biasedExponent[i];

        this.mantissa=new int[23];
        for(int i=0;i<this.mantissa.length;i++)
            this.mantissa[i]=mantissa[i];
    }

    IEEEFloatingPointNumber(int signBit,int biasedExponent,String mantissa)
    {
        this.signBit=signBit;
        this.biasedExponent=new int[8];
        String be=Integer.toBinaryString(biasedExponent);
        while(be.length()<8)be="0"+be;
        for(int i=0;i<8;i++)
            this.biasedExponent[i]=be.charAt(i)-48;

        this.mantissa=new int[23];
        for(int i=0;i<23;i++)
            this.mantissa[i]=mantissa.charAt(i)-48;
    }

    IEEEFloatingPointNumber(int signBit,int biasedExponent,int mantissa[])
    {
        this.signBit=signBit;
        this.biasedExponent=new int[8];
        String be=Integer.toBinaryString(biasedExponent);
        while(be.length()<8)be="0"+be;
        for(int i=0;i<8;i++)
            this.biasedExponent[i]=be.charAt(i)-48;

        this.mantissa=new int[23];
        for(int i=0;i<this.mantissa.length;i++)
            this.mantissa[i]=mantissa[i];
    }

    static int compareExponents(IEEEFloatingPointNumber X,IEEEFloatingPointNumber Y)
    {        
        for(int i=0;i<8;i++)
        {
            if(X.biasedExponent[i]>Y.biasedExponent[i])return 1;
            if(X.biasedExponent[i]<Y.biasedExponent[i])return -1;
        }
        return 0;
    }

    static int compareMantissa(IEEEFloatingPointNumber X,IEEEFloatingPointNumber Y)
    {        
        for(int i=0;i<8;i++)
        {
            if(X.mantissa[i]>Y.mantissa[i])return 1;
            if(X.mantissa[i]<Y.mantissa[i])return -1;
        }
        return 0;
    }

    static int absCompare(IEEEFloatingPointNumber X,IEEEFloatingPointNumber Y)
    {        
        if(compareExponents(X,Y)==0)return compareMantissa(X,Y);
        else return compareExponents(X,Y);
    }

    static int compare(IEEEFloatingPointNumber X,IEEEFloatingPointNumber Y)
    {        
        if(X.signBit==0 && Y.signBit==0)
        {
            if(compareExponents(X,Y)==0)return compareMantissa(X,Y);
            else return compareExponents(X,Y);
        }
        else if(X.signBit==1 && Y.signBit==1)
        {
            if(compareExponents(X,Y)==0)return -compareMantissa(X,Y);
            else return -compareExponents(X,Y);
        }
        else
        {
            if(X.signBit==0)return 1;
            else return -1;
        }
    }

    static IEEEFloatingPointNumber getIEEERepresentation(double num)
    {
        if(num==0.0)
        {
            return new IEEEFloatingPointNumber(0,new int[8],new int[23]);
        }
        int signBit=0;
        if(num<0)
        {
            signBit=1;
            num=Math.abs(num);
        }
        String binary="";
        int integralPart=(int)num;
        double fractionalPart=num-integralPart;
        binary=Integer.toBinaryString(integralPart);
        int precision=23,flag=0;        
        int indexOfFirstOne=binary.indexOf('1');
        if(indexOfFirstOne>=0)
        {
            precision-=binary.substring(indexOfFirstOne+1).length();
            flag=1;
        }
        binary+=".";
        while(precision > 0)
        {
            fractionalPart*=2;
            int fractionBit=(int)fractionalPart;
            binary+=fractionBit;
            if(flag==1)
            {                
                if(fractionBit==1)
                {
                    fractionalPart-=fractionBit;
                }
                precision--;
            }
            else
            {                
                if(fractionBit==1)
                {
                    fractionalPart-=fractionBit;
                    flag=1;
                }
            }
        }
        indexOfFirstOne=binary.indexOf('1');
        int indexOfDecimal=binary.indexOf('.');
        String mantissa=binary.substring(indexOfFirstOne+1).replace(".","");        
        int trueExponent=indexOfDecimal-indexOfFirstOne;
        if(indexOfDecimal>indexOfFirstOne)
        {
            trueExponent-=1;
        }        
        int biasedExponent=trueExponent+127;
        IEEEFloatingPointNumber fn=new IEEEFloatingPointNumber(signBit,biasedExponent,mantissa);
        return fn;
    }

    static IEEEFloatingPointNumber add(IEEEFloatingPointNumber X,IEEEFloatingPointNumber Y)
    {
        int significandX[]=new int[24];
        int significandY[]=new int[24];
        if(Binary.isZero(X.biasedExponent) && Binary.isZero(X.mantissa))return Y;
        if(Binary.isZero(Y.biasedExponent) && Binary.isZero(Y.mantissa))return X;
        for(int i=0;i<23;i++)
        {
            significandX[i+1]=X.mantissa[i];
            significandY[i+1]=Y.mantissa[i];
        }
        significandX[0]=1;
        significandY[0]=1;
        int expX=Binary.toInteger(X.biasedExponent);
        int expY=Binary.toInteger(Y.biasedExponent);
        int maxExp=(expX>expY)?expX:expY;
        //Make Exponents Equal
        while(expX<expY)
        {
            Binary.logicalShiftRight(significandX);
            expX++;
            if(Binary.isZero(significandX))return Y;
        }
        while(expY<expX)
        {
            Binary.logicalShiftRight(significandY);
            expY++;
            if(Binary.isZero(significandY))return X;
        }
        //Now Exponents are equal
        if(X.signBit==Y.signBit)
        {
            int resAddition[]=Binary.addBinary(significandX,significandY);//25 bits
            if(resAddition[0]==1)//Significand Overflow Case
            {
                Binary.logicalShiftRight(resAddition);//Normalizing Result                
                maxExp++;
                if(maxExp>254)//Exponent Overflow Case
                {
                    //throw new Exception("Exponent Overflow Occured");
                }
            }
            return new IEEEFloatingPointNumber(X.signBit,maxExp,Arrays.copyOfRange(resAddition,2,25));            
        }
        else
        {
            int rSignBit=0;
            if(absCompare(X,Y)==1)rSignBit=X.signBit;
            else if(absCompare(X,Y)==-1)rSignBit=Y.signBit;
            else //signs are different,magnitude is same,answer is 0
            {
                return new IEEEFloatingPointNumber(0,new int[8],new int[23]);
            }
            int resDifference[]=Binary.difference(significandX,significandY);//24 bits
            while(resDifference[0]==0)
            {
                Binary.logicalShiftLeft(resDifference);
                maxExp--;
                if(maxExp<1)//Exponent Underflow Case
                {
                    //throw new Exception("Exponent Underflow Occured");
                }
            }            
            return new IEEEFloatingPointNumber(rSignBit,maxExp,Arrays.copyOfRange(resDifference,1,24));
        }
    }

    void printNumber()
    {        
        System.out.println(getIEEEFormatString());
    }
    
    String getIEEEFormatString()
    {
        return signBit+"-"+Binary.toBinaryString(biasedExponent)+"-"+Binary.toBinaryString(mantissa);
    }
    
    double getNumber()
    {
        double num=0;
        for(int i=0;i<23;i++)
        {
            if(mantissa[i]==1)
            {
                num+=Math.pow(2,-1-i);                
            }
        }
        num+=1;
        int biasedExp=Binary.toInteger(biasedExponent);        
        num*=Math.pow(2,biasedExp-127);
        if(signBit==1)num=-num;
        return num;
    }
}