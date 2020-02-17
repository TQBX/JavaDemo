package com.my.reflect.practice;

/**
 * @auther Summerday
 */

/**
 * 框架类，可创建人任意类的对象，任意类的方法
 */


import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *
 * 实现：1、配置文件  2、反射
 *
 * 一、将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 *
 * 二、在程序中加载读取配置文件
 *
 * 三、使用反射计数来加载类文件进内存
 *
 * 四、创建对象
 *
 * 五、执行方法
 *
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        //1、加载配置文件

        //1.1 创建Properties对象
        Properties pro = new Properties();

        //1.2 加载配置文件，转换为一个集合

        //1.2.1获取class目录下的配置文件

        //创建类加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();

        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        pro.load(resourceAsStream);

        //2、获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3、加载该类进内存
        Class cls = Class.forName(className);

        //4、创建对象
        Object obj = cls.newInstance();

        //5、获取方法
        Method method = cls.getMethod(methodName);

        //6、执行方法
        method.invoke(obj);

    }
}
