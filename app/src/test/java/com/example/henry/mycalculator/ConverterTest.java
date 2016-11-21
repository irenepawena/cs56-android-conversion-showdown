package com.example.henry.mycalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by UMARU on 7/26/2016.
 */
public class ConverterTest {
    @Before
    public  void setUp() throws Exception{
    }

    //decimal to..
    @Test
    public void testToHex() throws Exception {
        Converter convertor = new Converter("10", 10);
        assertEquals( "a", convertor.toHex() );
    }

    @Test
    public void testToOct() throws Exception {
        Converter convertor = new Converter("10", 10);
        assertEquals( "12", convertor.toOct() );
    }

    @Test
    public void testToDec() throws Exception {
        Converter convertor = new Converter("10", 10);
        assertEquals( "10", convertor.toDec() );
    }

    @Test
    public void testToBin() throws Exception {
        Converter convertor = new Converter("10", 10);
        assertEquals( "1010", convertor.toBin() );
    }

    //
    @Test
    public void testToHex2() throws Exception {
        Converter convertor = new Converter("11010", 2);
        assertEquals( "1a", convertor.toHex());
    }
    @Test
    public void testToOct2() throws Exception {
        Converter convertor = new Converter("11010", 2);
        assertEquals( "32", convertor.toOct() );
    }

    @Test
    public void testToDec2() throws Exception {
        Converter convertor = new Converter("11010", 2);
        assertEquals( "26", convertor.toDec() );
    }

    @Test
    public void testToBin2() throws Exception {
        Converter convertor = new Converter("11010", 2);
        assertEquals( "11010", convertor.toBin() );
    }
}