package quebrabarreira.models;

import java.io.File;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class FileHandle {

    public List<List<String>> readCsvFile(String fileName) {
        /*
         * Opens 'fileName' CSV file
         * returns a list of string lists with the ';' separated values
        */
        File file = new File(fileName);

        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                String[] values = line.split(";");
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return lines;
    }

    public void writeCsvFile(String fileName, List<List<String>> lines) {
        /*
         * Writes to fileName the contents of the list of string lists 'lines'
        */
        
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for(List<String> line: lines) {
                writer.println(String.join(";", line));
            }
            
            writer.close();
        
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
    }

    public List<HashMap<String, String>> getCsv(String fileName) {
        /*
         * Returns the content of fileName CSV file 
         * on the form of a list of HashMaps with the correct header
        */

        List<List<String>> lines = this.readCsvFile(fileName);
        List<HashMap<String, String>> csvResults = new ArrayList<>();

        List<String> header = lines.get(0);
        for(List<String> line: lines.subList(2, lines.size())) {
            HashMap<String, String> l = new HashMap<>();
            for(int i = 0; i < line.size(); i++) {
                l.put(header.get(i), line.get(i));
            }
            csvResults.add(l);
        }

        return csvResults;
    }

    public void setCsv(String fileName, List<HashMap<String, String>> csvMap) {
        /*
         * Writes the content of csvMap to fileName
         * Gets the header from the keys and rewrites it
         * The content will not be ordered
        */

        List<List<String>> lines = new ArrayList<>();

        
        List<String> header = new ArrayList<>();
        for(String key: csvMap.get(0).keySet()) {
            header.add(key);
        }
        lines.add(header);

        for(HashMap<String, String> line: csvMap) {
            List<String> l = new ArrayList<>();
            for(String val: line.values()) {
                l.add(val);
            }
            lines.add(l);
        }
        
        this.writeCsvFile(fileName, lines);

    } 

}