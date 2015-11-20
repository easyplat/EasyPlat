package com.langeye.utilities;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Fish on 2015/11/7.
 */

@Component("validateCodeGener")
public class DefaultValidateCodeGener implements ValidateCodeGener{
    private final String[] arrCode=new String[]{
            "0","1","2","3","4",
            "5","6","7","8","9",
            "A","B","C","D","E",
            "F","G","H","I","J",
            "K","L","M","N","O",
            "P","Q","R","S","T",
            "U","V","W","X","Y",
            "Z","a","b","c","d",
            "e","f","g","h","i",
            "j","k","l","m","n",
            "o","p","q","r","s",
            "t","u","v","w","x",
            "y","z"
    };

    public DefaultValidateCodeGener() {

    }

    public String getValidateCode(int length) {
        //随机生成字符以及数字的组合
        Random random = new Random();
        StringBuilder sbValidCode = new StringBuilder(length);
        for (int i = 0;i<length;i++){
            sbValidCode.append(arrCode[random.nextInt(arrCode.length)]);
        }
        return sbValidCode.toString();
    }
}
