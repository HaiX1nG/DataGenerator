package com.datagenerator.utils;

import com.datagenerator.bean.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtCreater {
    // 创建SLF4J实例
    private static final Logger logger = LoggerFactory.getLogger(TxtCreater.class);
    private static final DataGenerator dataGenerator = new DataGenerator();
    private static final FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter("output.txt");
        } catch (IOException e) {
            logger.error("Failed to initialize FileWriter", e);
            throw new RuntimeException("Failed to initialize FileWriter", e);
        }
    }

    public void createTxt() {
        try {
            List<Data> dataList = new ArrayList<>();
            logger.info("Data writing...");
            fileWriter.write("date_now" + "\t" + "visits"+ "\n");
            while (true) {
                Data data = dataGenerator.DataObject();
                dataList.add(data);
                for (Data dao : dataList) {
                    String line = dao.getAccessed() + "\t" + dao.getVisits() + "\n";
                    logger.info("Insert Data ==> {} ", line);
                    fileWriter.write(line);
                    // 确保数据写入文件
                    fileWriter.flush();
                }
                logger.info("File written successfully.");
                Thread.sleep(100);
            }
        } catch (IOException e) {
            logger.error("The program has terminated due to the following reason:", e);
        } catch (InterruptedException e) {
            logger.error("The program was interrupted during sleep:", e);
            Thread.currentThread().interrupt(); // 重置中断状态
            return;
        }
    };

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            logger.error("Failed to close FileWriter", e);
        }
    }
}
