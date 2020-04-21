package com.others.tmptest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TmpUrlFilter {


    public static void main(String[] args) {
        TmpUrlFilter test = new TmpUrlFilter();
        test.findUrl();

    }

    String startStr = "href=\"/video/";
    String endStr = "?playlist=";

    public  void findUrl() {
        List<String>  list = readFile();
        list.stream().filter( str -> str.indexOf(startStr)>1).forEach(str ->{
            //System.out.println(str);
            String tmStr = str.substring(str.indexOf(startStr),str.indexOf( endStr)+endStr.length());
            //optional
            tmStr = tmStr.replace("href=\"","https://www.dailymotion.com");
            System.out.println(tmStr);
        });
        String str = "2Qq1K Video__large___HkCZW Video__sortable___NLz98\"><a title=\"腾飞五千年之西汉——第十二集  七国之乱\" href=\"/video/x71xlko?playlist=x6oxd9\">";
        String tmStr = str.substring(str.indexOf(startStr),str.indexOf( endStr)+8);

    }

    public List<String> readFile() {
        String fileName = "\\src\\main\\java\\com\\others\\tmptest\\TmpUrlFilter.txt";
        //String path = "src/com/others/tmpstest/TmpUrlFilter.txt";
        String line = null;
        String content = "";
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        ArrayList<String> result = new ArrayList<String>();
        File directory = new File(System.getProperty("user.dir")+fileName);//设定为当前文件夹
        System.out.println("=============================================");
        System.out.println(directory.getAbsolutePath());//获取绝对路径
        System.out.println(directory.getPath()); //获得new File()时设定的路径
        String path = System.getProperty("user.dir")+"\\src";
        System.out.println(path);
        //System.out.println(System.getProperties());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("com/others/tmpstest/TmpUrlFilter.txt"));
        //String classPath = this.getClass().getClassLoader().getResource("/").getPath();//容器加载的时候，例如tomcat启动该项目的时候。
        //System.out.println(classPath);
        //ReadFile.class.getResourceAsStream("/com/lavasoft/res/a.txt");
        //System.out.println(TmpUrlFilter.class.getResource("").getPath());
        //System.out.println(TmpUrlFilter.class.getResource("/com/others/tmpstest/TmpUrlFilter.txt").getPath());
        System.out.println("=============================================");
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("com/wpy/json/data.properties"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("db.properties"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("src/test/java/file1.properties"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("file2.properties"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("file3.properties"));
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        System.out.println(classloader);

        try {
            // br = new BufferedReader(new FileReader(path));
            br = new BufferedReader(new FileReader(directory)); // 与上等效

            while (null != (line = br.readLine())) {
                //System.out.println(line);
                content += line + "\n";
                result.add(line);
            }
            br.close();
            //System.out.println("--------------风骚分隔线--------------");
            //System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
