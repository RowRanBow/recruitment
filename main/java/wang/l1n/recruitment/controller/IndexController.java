package wang.l1n.recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author l1nker4
 */
@Controller
public class IndexController {

    /**
     * 主页
     * @return
     */
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    /**
     * 公司列表
     *
     * @return
     */
    @RequestMapping("companyList")
    public String companyList() {
        return "companyList";
    }

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    /**
     * 职位列表
     *
     * @return
     */
    @RequestMapping("index")
    public String jobList() {
        return "index";
    }

    /**
     * 公司账号 企业中心
     *
     * @return
     */
    @RequestMapping("cinfo")
    public String companyInfo() {
        return "cinfo";
    }

    /**
     * 公司账号  修改企业信息
     *
     * @return
     */
    @RequestMapping("cchange")
    public String cchange() {
        return "cchange";
    }

    /**
     * 公司账号 企业界面
     *
     * @return
     */
    @RequestMapping("ccenter")
    public String ccenter() {
        return "ccenter";
    }

    /**
     * 公司账号 我发布的岗位
     *
     * @return
     */
    @RequestMapping("cjoblist")
    public String cjoblist() {
        return "cjoblist";
    }

    /**
     * 公司账户 岗位申请
     *
     * @return
     */
    @RequestMapping("capplys")
    public String capplys() {
        return "capplys";
    }

    /**
     * 公司账户 添加公告
     */
    @RequestMapping("caddannouce")
    public String addcannouce() {
        return "caddannouce";
    }

    /**
     * 公司账户 我的公告
     */
    @RequestMapping("cannouce")
    public String cannouce() {
        return "cannouce";
    }
}
