package com.resdii.crm.user.utils;

import com.resdii.ms.common.utils.DateUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class StringUtils {

    public static String generateTransactionCode(){
        StringBuilder sb = new StringBuilder("VR");
        sb.append(RandomStringUtils.randomAlphabetic(4));
        sb.append(DateUtils.getCurrentTimeString());
        return sb.toString().toUpperCase();
    }

    public static String generateEnrollCode(){
        StringBuilder sb = new StringBuilder("ENR");
        sb.append(RandomStringUtils.randomAlphabetic(4));
        sb.append(DateUtils.getCurrentTimeString());
        return sb.toString().toUpperCase();
    }

    public static String generateWalletCode(){
        return UUID.randomUUID().toString().toLowerCase();
    }
}
