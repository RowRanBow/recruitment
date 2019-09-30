package wang.l1n.recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/7/3 20:42
 * @description：
 */


@Controller
public class DefaultController {

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/manage/login")
    public String toLogin() {
        return "manage/login";
    }

    /**
     * 未授权页面
     *
     * @return
     */
    @RequestMapping("/unAuth")
    public String toUnAuth() {
        return "unAuth";
    }

    @RequestMapping("/manage/main")
    public String toMain() {
        return "manage/main";
    }

}
