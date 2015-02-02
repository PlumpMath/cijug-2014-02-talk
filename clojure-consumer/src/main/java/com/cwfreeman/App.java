package com.cwfreeman;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import com.cwfreeman.StringWorker;
import com.cwfreeman.StringEngine;

public class App 
{
    static StringWorker makeWorker() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("java-interop.core"));
        IFn constructor = Clojure.var("java-interop.core", "->IdentityStringWorker");
        Object o = constructor.invoke();
        if( o instanceof StringWorker ) {
            return (StringWorker)o;
        } else {
            throw new RuntimeException("Could not call factory method for IdentityStringWorker");
        }
    }
    public static void main( String[] args )
    {
        StringEngine e = new StringEngine(new String[]{"Hello", ", ", " ", "World", "!"});
        StringWorker w = makeWorker();
        System.out.println( "Output: " + e.work(w));
    }
}
