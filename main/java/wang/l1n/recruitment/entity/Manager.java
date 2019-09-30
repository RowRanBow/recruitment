package wang.l1n.recruitment.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/7/3 20:39
 * @description：
 */
@Data
public class Manager implements Serializable {

    private int mid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
