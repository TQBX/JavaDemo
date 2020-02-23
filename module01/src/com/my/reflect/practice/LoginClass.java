package com.my.reflect.practice;

/**
 * @auther Summerday
 */
public class LoginClass {
    String username;
    String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int execute(){
        int flag = 0;
        if(this.username.equals("xx")&&this.password.equals("123456")){
            System.out.println("登录成功");
            flag = 1;

        }else {
            System.out.println("登录失败");
        }
        return flag;
    }
}

