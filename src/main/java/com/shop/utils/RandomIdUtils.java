package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomIdUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyy");
    public static int Guid=100;
    public static String getGuid() {
        RandomIdUtils.Guid+=1;
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran=0;
        if(RandomIdUtils.Guid>999){
            RandomIdUtils.Guid=100;
        }
        ran=RandomIdUtils.Guid;
        return time+info.substring(2, info.length())+ran;
    }
    public static String getId(){
        Random random = new Random();
        Date date = new Date();
        String resu = sdf.format(date)+(random.nextInt(1000)+1000);
        return resu;
    }

    public static  String getUUID(){//生成32位id
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr =str.replace("-","");
        return uuidStr;
    }
    public static void main(String[] args) {
        System.out.println(getId());
    }
}
