package com.cobot00.cassandra_generator.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobot00.cassandra_generator.config.ResourceConfiguration;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLColumnDao;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLKeyColumnDao;
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
        makeDirs(config.getOutputDirectory() + File.separator + javaPackagePath);

        System.out.println("---");
        List<ColumnEntity> result = columnDao.select(Arrays.asList("data_types"));
        System.out.println("size: " + result.size());

        List<KeyColumnEntity> keyColumns = keyColumnDao.select(Arrays.asList("multi_keys"));
        System.out.println("size: " + keyColumns.size());
        keyColumns.stream().forEach(System.out::println);
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
