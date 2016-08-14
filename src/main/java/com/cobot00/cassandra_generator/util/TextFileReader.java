package com.cobot00.cassandra_generator.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    public List<String> read(String filePath) {
        final List<String> result = new ArrayList<String>();

        try {
            //final File file = new File(filePath);
            InputStream is = ClassLoader
                    .getSystemResourceAsStream(filePath);
            //final BufferedReader br = new BufferedReader(new FileReader(file));
            final BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = "";
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return result;
    }
}
