package wang.l1n.recruitment.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/22 13:10
 * @description：  MD5加密工具类
 */
@Component
public class EncryptionUtils {
    public static String getMD5(String credentials){
        Object result = new SimpleHash("MD5",credentials);
        return result.toString();
    }
}
