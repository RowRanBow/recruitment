package wang.l1n.recruitment.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/9/28 11:37
 * @description： 公司
 */
@Data
public class Company {

    private Integer id;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司规模
     */
    private String companySize;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 简介
     */
    private String description;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;

    private int state;
}
