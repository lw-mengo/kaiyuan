package com.kaiyuan.mengo.kaiyuan;

import DrawSDK.Handler;
import org.junit.Test;

public class MainTest {

//    @Test
//    public void testCsvReadByAnnotation() throws Exception {
//        String filePath = "F:\\upload\\movieV3.csv";
//        CSVReader reader = new CSVReader(new FileReader(filePath));
//        String[] nexLine;
//        /*
//        输出前10条记录
//         */
//        //  for (int i=0;i<10;i++) {
//        //     if ((nexLine = reader.readNext()) != null) {
//        //       System.out.println("title:::" + nexLine[0]);
//        //      }
//        /*
//        输出字段
//         */
//        if ((nexLine = reader.readNext()) != null) {
//            int i = nexLine.length;
//            System.out.println(i);
//            for (int j = 0; j < i; j++) {
//                System.out.println(nexLine[j]);
//            }
//        }
//    }
//
//    /*
//    测试随机数工具
//     */
//    @Test
//    public void testUtil(){
//        String id = TaskIdUtil.getUUID();
//        System.out.println(id);
//    }
//
//    @Test
//    public void testResult(){
//        String str = CommonResult.success();
//        System.out.println(str);
//    }
//
//    /*
//    测试下uid生成
//     */
//    @Test
//    public void testUid(){
//        System.out.println(UIDUtil.getUid());
//    }

    /*
    测试sdk
     */

//    @Test
//    public void testSdk(){
//        Handler handler = new Handler();
//        HashMap<String,String> hashMap =  handler.getUrlMap("111","sdsff");
//        Set keys = hashMap.keySet();
//        for (Object key : keys){
//            System.out.println(key+"="+hashMap.get(key));
//        }
//
//    }
//
//    interface Callback {
//        void receiveNotification(String string);
//    }
//
//    class Leader implements Callback {
//        @Override
//        public void receiveNotification(String string) {
//            System.out.println(string);
//        }
//
//        public void assignTask(Developer student){
//            student.doTask(this);
//        }
//
//        public void assignTask(Thread thread){
//            thread.start();
//        }
//    }
//
//    class Developer {
//        private String name;
//
//        void doTask(Callback callback) {
//            try {
//                Thread.sleep(3000);
//                System.out.println("3S delete");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            callback.receiveNotification(this.name + "complete the task");
//        }
//
//        public Developer(String name) {
//            this.name = name;
//        }
//    }
//
//    @Test
//    public void test(){
//        Leader leader = new Leader();
//        Developer xiao = new Developer("xiaoming");
//        leader.assignTask(new DoJobThread(xiao,leader));
//        DoJobThread doJobThread = new DoJobThread(xiao,leader);
//        doJobThread.run();
//
//    }
//
//    static class DoJobThread extends Thread{
//        private Developer student;
//        private Leader teacher;
//
//        @Override
//        public void run() {
//            student.doTask(teacher);
//        }
//
//        public DoJobThread(Developer student,Leader teacher){
//            this.student = student;
//            this.teacher = teacher;
//        }
//    }




    @Test
    public void test() {
        Demo demo = new Demo("apple");
        String result = Demo.getResult();
        System.out.println(result);
    }


}

class Demo {
    private static String result;

    public Demo(String result) {
        this.result = result;
    }

    public static String getResult() {
        return result;
    }

    public Demo() {
    }
}

