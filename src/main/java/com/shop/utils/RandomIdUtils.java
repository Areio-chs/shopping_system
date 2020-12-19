package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomIdUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyy");
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
