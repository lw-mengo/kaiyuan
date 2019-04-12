package com.kaiyuan.mengo.kaiyuan;

import com.opencsv.CSVReader;
import org.graphviz.server.Handler;
import org.junit.Test;

import java.io.FileReader;

public class MainTest {

    @Test
    public void testCsvReadByAnnotation() throws Exception {
        String filePath = "F:\\upload\\movieV3.csv";
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] nexLine;
        /*
        输出前10条记录
         */
        //  for (int i=0;i<10;i++) {
        //     if ((nexLine = reader.readNext()) != null) {
        //       System.out.println("title:::" + nexLine[0]);
        //      }
        /*
        输出字段
         */
        if ((nexLine = reader.readNext()) != null) {
            int i = nexLine.length;
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                System.out.println(nexLine[j]);
            }
        }
    }

}

