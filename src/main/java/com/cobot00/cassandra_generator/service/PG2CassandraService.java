package com.cobot00.cassandra_generator.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobot00.cassandra_generator.config.ResourceConfiguration;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLColumnDao;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLKeyColumnDao;
import com.cobot00.cassandra_generator.model.dto.CassandraInJavaField;
import com.cobot00.cassandra_generator.model.dto.ColumnEntity;
import com.cobot00.cassandra_generator.model.dto.KeyColumnEntity;
import com.cobot00.cassandra_generator.util.Utility;

@Service
public class PG2CassandraService {

    @Autowired
    private ResourceConfiguration config;

    @Autowired
    private PostgreSQLColumnDao columnDao;

    @Autowired
    private PostgreSQLKeyColumnDao keyColumnDao;

    public void execute() {
        System.out.println("---");
        System.out.println("OutputDirectory: " + config.getOutputDirectory());
        System.out.println("JavaPackagePath: " + config.getJavaPackagePath());
        makeDirs(config.getOutputDirectory());
        String javaPackagePath = Utility.toFilePath(config.getJavaPackagePath());
        String outputDir = config.getOutputDirectory() + File.separator + javaPackagePath;
        makeDirs(outputDir);

        System.out.println("---");
        List<ColumnEntity> columns = columnDao.select(Arrays.asList("data_types"));
        System.out.println("size: " + columns.size());

        List<KeyColumnEntity> keyColumns = keyColumnDao.select(Arrays.asList("multi_keys"));
        System.out.println("size: " + keyColumns.size());
        keyColumns.stream().forEach(System.out::println);

        List<CassandraInJavaField> cassandraFields = columns.stream()
                .map(column -> CassandraInJavaField.of(column.getDataType(), column.getColumnName(), keyColumns))
                .collect(Collectors.toList());
        List<String> fields = cassandraFields.stream().map(CassandraInJavaField::toJavaField)
                .collect(Collectors.toList());

        ValocityWriter writer = new ValocityWriter();
        String filePath = outputDir + File.separator + "DataTypes.java";
        writer.write("DataTypes", config.getJavaPackagePath(), filePath, fields);
    }

    private void makeDirs(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            return;
        }
        if (!dir.mkdirs()) {
            throw new RuntimeException();
        }
    }

}
