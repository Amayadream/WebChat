package com.amayadream.webchat.common.util;

import com.google.common.base.Charsets;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author :  Amayadream
 * @date :  2017.06.19 22:01
 */
public class StringUtil {

    public static String getGuid(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase();
    }

    public static String getAvatarUrl(String userId, int size) {
        String hash = DigestUtils.md5DigestAsHex(userId.getBytes(Charsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        sb.append("http://www.gravatar.com/avatar/");
        sb.append(hash).append(".jpg?d=identicon&s=");
        sb.append(size);
        return sb.toString();
    }

}
