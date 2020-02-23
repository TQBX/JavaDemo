package playcards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @auther Summerday
 */
public class CardsGame {
    public static void main(String[] args) {
        //准备牌

        ArrayList<String> poker = new ArrayList<>();
        //存储花色和序号
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        //添加大小王
        poker.add("大王");
        poker.add("小王");
        //组合花色和序号，并添加入poker
        for (String number : numbers) {
            for (String color : colors) {
//                System.out.println(color+number);
                poker.add(color+number);
            }
        }
//        System.out.println(poker);

        //洗牌
        Collections.shuffle(poker);

        //发牌

        //三个集合存储玩家牌，一个集合存储底牌

        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> base = new ArrayList<>();

        //遍历poker，获取一张牌剩余三张牌为底牌
        for(int i = 0;i<poker.size();i++){
            //获取
            String p = poker.get(i);

            if(i>=51){
                base.add(p);
            }else if(i%3 == 0){
                player01.add(p);
            }else if(i%3 == 1){
                player02.add(p);
            }else{
                player03.add(p);
            }
        }

        //看牌
        System.out.println("p1"+player01);
        System.out.println("p2"+player02);
        System.out.println("p3"+player03);
        System.out.println("底牌"+base);
    }
}


