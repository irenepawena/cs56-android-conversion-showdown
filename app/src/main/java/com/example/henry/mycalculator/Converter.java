package com.example.henry.mycalculator;

/**
 * Created by UMARU on 7/27/2016.
 */
public class Converter {
    Integer num = -1 ;
    boolean isValid = true;
    public Converter(String s , int base) throws IntOverFlow {
        if (!MyUtils.sanity_check(s, base)) {
            isValid = false;
            return;
        }
        num = Integer.parseInt( s , base);
    }


    public String toHex(){
        return Integer.toHexString( num );
    }

    public String toOct(){
        return Integer.toOctalString( num );
    }

    public String toDec(){
        return num.toString();
    }

    public String toBin(){
        return Integer.toBinaryString( num );
    }

    public String toBase(int base){
        switch(base){
            case(2):
                return toBin();
            case(8):
                return toOct();
            case(10):
                return toDec();
            case(16):
                return toHex();
        }
        return null;
    }

    public boolean isValid(){
        return isValid;
    }

}
