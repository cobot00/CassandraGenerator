package com.cobot00.cassandra_generator.model.dto;

import java.util.List;

import com.cobot00.cassandra_generator.model.CassandraDataType;
import com.cobot00.cassandra_generator.model.logic.PG2CassandraFieldMapper;

import lombok.Value;

@Value
public class CassandraInJavaField {

    private final CassandraDataType dataType;
    private final String fieldName;
    private final int keyOrder;

    public static CassandraInJavaField of(String pgDataType, String fieldName, List<KeyColumnEntity> keyColumns) {
        int keyOrder = -1;
        for (int i = 0; i < keyColumns.size(); i++) {
            if (keyColumns.get(i).getColumnName().equals(fieldName)) {
                keyOrder = i;
                break;
            }
        }
        return new CassandraInJavaField(PG2CassandraFieldMapper.getTypeForJava(pgDataType), fieldName, keyOrder);
    }

    public String toJavaField() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        if (keyOrder >= 0) {
            sb.append("    @Key(order = " + keyOrder + ")");
            sb.append(System.getProperty("line.separator"));
        }
        sb.append("    private ");
        sb.append(dataType.getType());
        sb.append(" ");
        sb.append(fieldName);
        sb.append(";");
        return sb.toString();
    }

}
