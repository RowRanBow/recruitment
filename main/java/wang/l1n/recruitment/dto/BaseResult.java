package wang.l1n.recruitment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/25 11:01
 * @description：  封装数据传输对象
 */
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;
    private Map<String,Object> map = new HashMap<>();
    private List list = new ArrayList<>();
    private Object object;

    public static BaseResult success(){
        return BaseResult.createResult(STATUS_SUCCESS, "成功");
    }

    public static BaseResult success(String message){
        return BaseResult.createResult(STATUS_SUCCESS, message);
    }

    public static BaseResult fail(){
        return BaseResult.createResult(STATUS_FAIL, "失败");
    }

    public static BaseResult fail(String message){
        return BaseResult.createResult(STATUS_FAIL, message);
    }

    public static BaseResult fail(int status,String message){
        return BaseResult.createResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    private static BaseResult createResult(int status, String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

}
