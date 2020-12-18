package com.sparta.rashawn.runapp;
import com.sparta.rashawn.view.Display;

public class App
{
    public static void main( String[] args )
    {

        long start = System.nanoTime();
        Display.displayTimeTakenToLoadFile();
        Display.displayTimeTakenToCheckErrors();
        Display.displayTimeTakenToInsert();
        long finish = System.nanoTime();
        long total = (finish - start) / 1_000_000_000;
        System.out.println("Time taken to run the program is: "+total+" seconds");

    }
}
