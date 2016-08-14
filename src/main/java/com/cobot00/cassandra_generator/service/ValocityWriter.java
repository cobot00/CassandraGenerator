package com.cobot00.cassandra_generator.service;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ValocityWriter {

    public ValocityWriter() {
        init();
    }

    public void write(String className, String packagePath, String filePath,
            List<String> fields) {
        try {
            Template template = Velocity.getTemplate("templates/CassandraDto.vm", "UTF-8");

            VelocityContext context = new VelocityContext();
            context.put("package_path", packagePath);
            context.put("class_name", className);
            context.put("fields", fields);

            File file = new File(filePath);
            FileWriter fw = new FileWriter(file);
            template.merge(context, fw);
            fw.flush();

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void init() {
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty("input.encoding", "UTF-8");
        Velocity.init(p);
    }
}
