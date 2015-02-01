package com.cwfreeman;

public class StringEngine {
    String[] data;
    public StringEngine(String[] data) {
        this.data = data;
    }

    public String work(StringWorker w) {
        String[] mappedData = new String[data.length];
        for( int i = 0; i < data.length; i++ ) {
            mappedData[i] = w.map(data[i]);
        }
        return w.reduce(mappedData);
    }

    public String work(java.lang.Class<StringWorker> clazz) throws Exception {
        return work(clazz.newInstance());
    }
}
