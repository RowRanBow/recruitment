package wang.l1n.recruitment.entity;

import java.io.Serializable;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/27 13:11
 * @description： 权限
 */
public class Permission implements Serializable {
    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
