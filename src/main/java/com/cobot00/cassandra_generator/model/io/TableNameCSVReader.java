package com.cobot00.cassandra_generator.model.io;

import com.cobot00.cassandra_generator.model.dto.TableNameEntity;
import com.cobot00.cassandra_generator.util.CSVFileReader;

public class TableNameCSVReader extends CSVFileReader<TableNameEntity> {

    @Override
    protected TableNameEntity parseCSV(String line) {
        String[] fields = line.split(",");
        String tableName = fields[0];
        String javaClassName = fields.length >= 2 ? fields[1] : "";
        String parentClassName = fields.length >= 3 ? fields[2] : "";
        return new TableNameEntity(tableName, javaClassName, parentClassName);
    }

}
