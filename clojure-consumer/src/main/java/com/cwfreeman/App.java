package com.cwfreeman;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import com.cwfreeman.StringWorker;
import com.cwfreeman.StringEngine;

public class App 
{
    static Class<StringWorker> getWorkerClass() throws Exception {
        StringWorker sw = makeWorker();
        System.out.println("Getting class of worker: " + sw.getClass().getName());
        /*
        return (Class<StringWorker>)sw.getClass();
        */
        IFn require = Clojure.var("clojure.core", "require");
        IFn ns_map = Clojure.var("clojure.core", "ns-map");
        System.out.println("Namespace Map: " + ns_map.invoke(Clojure.read("java-interop.core")));
        IFn deref = Clojure.var("clojure.core", "deref");
        require.invoke(Clojure.read("java-interop.core"));
        IFn isw = Clojure.var("java-interop.core", "IdentityStringWorker");
        Object o = deref.invoke(isw);
        /*
        IFn clazz = Clojure.var("java_interop.core", "->IdentityStringWorker");
        Object o = deref.invoke(clazz);
        */
        if( o instanceof Class ) {
            return (Class<StringWorker>)o;
        } else {
            throw new RuntimeException("Got wrong thing!: " + o.toString() + o.getClass().getName());
        }
    }

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
        try {
            Class<StringWorker> wc = getWorkerClass();
            System.out.println( "Output: " + e.work(wc));
        } catch(Exception ex) {
            System.err.println("Well, that didn't work.");
            System.err.println(ex.getMessage());
        }
    }
}
