package com.cobot00.cassandra_generator.util;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CSVFileReader<T> {

    public List<T> read(String filePath) {
        List<String> lines = new TextFileReader().read(filePath);
        lines.remove(0); // remove header line
        return lines.stream().map(this::parseCSV).collect(Collectors.toList());
    }

    protected abstract T parseCSV(String line);
}
