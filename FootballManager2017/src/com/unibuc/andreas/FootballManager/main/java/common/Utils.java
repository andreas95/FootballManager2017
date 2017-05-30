package com.unibuc.andreas.FootballManager.main.java.common;

/**
 * @author andreas
 * Created by antoneandreas on 5/29/17.
 */
public class Utils {

    public static boolean isNumeric(String str)
    {
        try
        {
            byte b = Byte.parseByte(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
