package com.amayadream.webchat.common.util;

import com.google.common.base.Charsets;
import org.springframework.util.DigestUtils;

/**
 * @author :  Amayadream
 * @date :  2017.06.12 22:24
 */
public class AvatarUtils {

    public static String getAvatarUrl(String userId, int size) {
        String hash = DigestUtils.md5DigestAsHex(userId.getBytes(Charsets.UTF_8));
        return "http://www.gravatar.com/avatar/" + hash +".png?d=identicon&s=" + size;
    }

}
