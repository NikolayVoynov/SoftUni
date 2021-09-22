package com.example.db_spring_data_mvc_project.service.util;

public interface XmlConverter {

    <T> T deserialize(String input, Class<T> type);

    String serialize(Object o);
}
