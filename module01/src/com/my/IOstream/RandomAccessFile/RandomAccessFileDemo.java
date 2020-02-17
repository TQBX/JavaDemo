package com.my.IOstream.RandomAccessFile;

import java.io.*;

/**
 * @auther Summerday
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {

//        RandomAccessFile raf = new RandomAccessFile("D:\\bb.txt","rw");
//        raf.writeInt(10);
//        raf.seek(0);
//        System.out.println("首次指针指向->"+raf.getFilePointer());
//        System.out.println("读取的int值："+raf.readInt());
//        System.out.println("读取int之后指针指向->"+raf.getFilePointer());
        String fileName = "D:\\bb.txt";
//        testFilePointerAndRead(fileName, "r");
//        addToTail(fileName);

//        testFilePointerAndRead(fileName);
//        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
//        System.out.println(raf.read());

        insert(fileName,4,"hello,world");
        
    }

    /**
     * 从指定的文件中读取数据
     * @param fileName  文件路径名
     */
    public static void testFilePointerAndRead(String fileName){
        //try-with-resource
        try(RandomAccessFile raf = new RandomAccessFile(fileName,"r")){

            byte[] bs = new byte[1024];
            int byteRead = 0;
            //read(bs)  读取bs数组大小的字节数据进入数组
            while((byteRead = raf.read(bs))!=-1){
                System.out.println("读取的内容："+new String(bs,0,byteRead));//123
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在指定文件尾部追加内容
     * @param fileName  文件路径名
     */
    public static void addToTail(String fileName){
        //try-with-resource
        try(RandomAccessFile raf = new RandomAccessFile(fileName,"rw")) {
            //将文件指针指向文件尾部
            raf.seek(raf.length());
            raf.write("追加内容".getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 插入文件指定位置的指定内容
     * @param filePath 文件路径
     * @param pos  插入文件的指定位置
     * @param insertContent 插入文件中的内容
     * @throws IOException
     */
    public static void insert(String filePath,long pos,String insertContent)throws IOException{
        RandomAccessFile raf=null;
        //创建临时文件
        File tmp= File.createTempFile("tmp",null);
        tmp.deleteOnExit();
        try {
            // 以读写的方式打开一个RandomAccessFile对象
            raf = new RandomAccessFile(new File(filePath), "rw");
            //创建一个临时文件来保存插入点后的数据
            FileOutputStream fileOutputStream = new FileOutputStream(tmp);
            FileInputStream fileInputStream = new FileInputStream(tmp);
            //把文件记录指针定位到pos位置
            raf.seek(pos);
            //------下面代码将插入点后的内容读入临时文件中保存-----
            byte[] bbuf = new byte[64];
            //用于保存实际读取的字节数据
            int hasRead = 0;
            //使用循环读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) != -1) {
                //将读取的内容写入临时文件
                fileOutputStream.write(bbuf, 0, hasRead);
            }
            //-----下面代码用于插入内容 -----
            //把文件记录指针重新定位到pos位置
            raf.seek(pos);
            //追加需要插入的内容
            raf.write(insertContent.getBytes());
            //追加临时文件中的内容
            while ((hasRead = fileInputStream.read(bbuf)) != -1) {
                //将读取的内容写入临时文件
                raf.write(bbuf, 0, hasRead);
            }
        }catch (Exception e){
            throw e;
        }
    }


}
