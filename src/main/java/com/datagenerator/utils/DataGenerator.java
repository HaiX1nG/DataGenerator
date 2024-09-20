package com.datagenerator.utils;

import com.datagenerator.dao.DataDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {
    public String accessedGenerator() {
        // 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        // 格式化输出时间戳
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatterDate = now.format(formatter);
        return formatterDate;
    }

    public Integer visitsGenerator() {
        // 创建随机数实例对象
        Random random = new Random();
        // 访问次数范围为 1～10000
        Integer visits = random.nextInt(10000) + 1;
        return visits;
    }

    public DataDao DataObject() {
        String accessed = accessedGenerator();
        Integer visits = visitsGenerator();
        DataDao data = new DataDao(accessed, visits);
        return data;
    }
}
