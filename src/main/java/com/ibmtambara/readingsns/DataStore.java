package com.ibmtambara.readingsns;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class DataStore {
    String filename;
    List<String> lines;

    public DataStore(String filename){
        this.filename = filename;
        lines = readLines(filename);
    }
    
    public List<Article> getArticles(){
        return lines.stream().map(line -> parseLine(line)).toList();
    }

    private List<String> readLines(String filename) {
            List<String> ret = null;
        
            try {
                ret = Files.lines(Path.of(filename)).toList();
            } catch (IOException e) {
                // Do nothing
            }

            return ret;
    }

    private Article parseLine(String line){
        var col = line.split(",");

        var a = new Article();
        a.setUser(col[0], col[1]);
        a.setBook(col[2], col[3]);
        a.setMessage(col[4], col[5]);

        return a;

    }
}
