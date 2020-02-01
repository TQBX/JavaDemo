package com.my.FileTest.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @auther Summerday
 */
public final class Directory {
    public static File[] local(File dir,final String regex){
        //使用FilenameFilter来产生File数组
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[]local (String path,final String regex){
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{
        //存储文件名
        public List<File> files = new ArrayList<>();
        //存储目录名
        public List<File> dirs = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        @Override
        public String toString(){
            return "dirs: "+ PPrint.pformat(dirs) +"\n\nfiles: "+PPrint.pformat(files);
        }
    }

    /**
     * 将开始目录的名字转换为File对象，然后调用recurseDirs方法。
     * @param start  开始路径
     * @param regex  匹配正则表达式
     * @return       将传入的路径名转化成对象
     */
    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start), ".*");
    }

    /**
     * 遍历目标目录，根据regex，搜集信息，存入数组
     * @param startDir  开始路径
     * @param regex     匹配正则表达式
     * @return    返回存储目录所有匹配信息的对象
     */
    private static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for(File item:startDir.listFiles()){
            if (item.isDirectory()) {

                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else{
                if(item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }


}
class Test{
    public static void main(String[] args) {
        System.out.println(Directory.walk(".\\module01\\src\\leetcode\\链表"));
    }
}