package com.my.reflect.practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @auther Summerday
 */
public class ScShell {

    Properties prop = null;

    private ScShell() {

        InputStream in = ScShell.class.getResourceAsStream("/person.properties");
        try {
            prop = new Properties();
            prop.load(in);

        } catch (IOException e) {
            System.out.println("Properties load failed!");
        }
    }

    public static void start() {
        ScShell shell = new ScShell();

        try {
            shell.process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        //读取输入内容
        while (true) {
            System.out.print("# ");

            String textLine = reader.readLine();

            if (textLine == null)
                break;
            if (textLine.equals("exit")) {
                System.out.println("exit!");
                break;
            }
            //移除左右空格
            textLine = textLine.trim();
            handleCommand(textLine);

        }
        reader.close();
    }

    private void handleCommand(String textLine) {
        Command cmd = new Command();
        cmd.parser(textLine);

        String en = prop.getProperty(cmd.entrance);
        //防止login键值写错
        if(en == null){
            System.out.println("数据格式有误！注意英文单词有没有写错");
            return;
        }

        en = en.trim();




        try {
            if (en.length() == 0)
                throw new Exception("配置信息无法找到");
            Class cls = Class.forName(en);
            Object obj = cls.newInstance();
            Method[] methods = cls.getMethods();
            Method method = null;

            for (pair p : cmd.p) {
                String key = p.k;
                String value = p.v;

                //标准化setter的名字
                char firstChar = Character.toUpperCase(key.charAt(0));
                StringBuilder stringBuilder = new StringBuilder("set" + key);
                stringBuilder.setCharAt(3, firstChar);

                for (Method m : methods) {
                    if (m.getName().trim().equals(stringBuilder.toString())) {
                        method = m;
                        break;
                    }

                }
                if (method == null)
                    throw new Exception("无此方法");
                Object[] parameter = {value};
                method.invoke(obj, parameter);

            }
            Method execute = cls.getMethod("execute", null);
            Integer returnValue = (Integer) execute.invoke(obj, null);

            System.out.println("returnValue = " + returnValue);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private class pair {
        String k;
        String v;

        public pair() {
        }

        public pair(String k, String v) {
            this.k = k;
            this.v = v;
        }
    }

    private class Command {
        String entrance = "";
        ArrayList<pair> p = new ArrayList<>();

        public void parser(String textLine) {
            String[] buf = textLine.split(" ");
            this.entrance = buf[0].trim();

            p.clear();

            for (int i = 1; i < buf.length; i++) {
                //存储键和值
                String[] aim = buf[i].trim().split("=");
                if (aim.length != 2) {
//                    throw new IllegalArgumentException("数据格式错误");
                    System.out.println("数据格式错误,一个等号哦");
                    return;
                }

                String k = aim[0].trim();
                String v = aim[1].trim();
                p.add(new pair(k, v));
            }
        }
    }

    public static void main(String[] args) {
        ScShell.start();
    }


}
