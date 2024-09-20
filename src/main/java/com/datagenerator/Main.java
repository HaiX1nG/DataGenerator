package com.datagenerator;


import com.datagenerator.utils.CsvCreater;
import com.datagenerator.utils.TxtCreater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final TxtCreater txtCreater = new TxtCreater();
    private static final CsvCreater csvCreater = new CsvCreater();
    public static void main(String[] args) {
        // 使用线程来运行创建文本和CSV文件的操作，以便它们可以并行执行
        Thread txtThread = new Thread(txtCreater::createTxt);
        Thread csvThread = new Thread(csvCreater::createCsv);

        txtThread.start();
        csvThread.start();

        try {
            txtThread.join();
            csvThread.join();
        } catch (InterruptedException e) {
            logger.error("The program was interrupted", e);
            Thread.currentThread().interrupt();
        }

        // 在主线程结束前确保所有资源都被关闭
        txtCreater.close();
        csvCreater.close();
    }
}