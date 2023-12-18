package com.example.fist_it.entity;

import androidx.room.TypeConverter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Converters {
    @TypeConverter
    public static Map<Date, List<String>> fromString(String value) {
        Type listType = new TypeToken<Map<Date, List<String>>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMap(Map<Date, List<String>> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}