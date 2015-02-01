package com.cwfreeman;

import java_interop.worker.IdentityStringWorker;
import com.cwfreeman.StringWorker;
import com.cwfreeman.StringEngine;

public class App 
{
    public static void main( String[] args )
    {
        StringEngine e = new StringEngine(new String[]{"Hello", ", ", " ", "World", "!"});
        System.out.println( "Output: " + e.work(new IdentityStringWorker()));
    }
}
