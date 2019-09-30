package wang.l1n.recruitment.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wang.l1n.recruitment.dto.BaseResult;
import wang.l1n.recruitment.entity.Manager;
import wang.l1n.recruitment.service.ManagerService;
import wang.l1n.recruitment.utils.EncryptionUtils;

import java.util.List;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/9/28 14:46
 * @description： 管理员控制器
 */

@Controller
@RequestMapping("manage/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 返回列表页
     *
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Model model) {
        List<Manager> list = managerService.getManagerList();
        model.addAttribute("managers", list);
        return "manage/manager/list";
    }

    /**
     * 根据ID获取管理员信息
     *
     * @param mid
     * @return
     */
    @RequestMapping("/{mid}")
    @ResponseBody
    public BaseResult getManagerById(@PathVariable("mid") int mid) {
        BaseResult baseResult = new BaseResult();
        Manager manager = managerService.getManagerById(mid);
        baseResult.setObject(manager);
        return baseResult;
    }

    /**
     * 更新管理员账号
     *
     * @param manager
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public BaseResult updateManager(@RequestBody Manager manager) {
        BaseResult baseResult = new BaseResult();
        if (StringUtils.isNotBlank(manager.getUsername()) && StringUtils.isNotBlank(manager.getPassword())) {
            String pwd = EncryptionUtils.getMD5(manager.getPassword());
            manager.setPassword(pwd);
            managerService.updateManagerById(manager);
            baseResult.setMessage("更改成功！");
        }
        baseResult.setMessage("更新失败，请输入有效数据！");
        return baseResult;
    }

    @ResponseBody
    @PostMapping("delete/{id}")
    public BaseResult deleteManager(@PathVariable String id) {
        BaseResult baseResult = new BaseResult();
        managerService.deleteManager(id);
        baseResult.setMessage("删除成功");
        return baseResult;
    }

    @RequestMapping("add")
    public String toAdd(Model model) {
        return "manage/manager/add";
    }

    /**
     * 添加管理员操作
     *
     * @param manager
     * @return
     */
    @RequestMapping("doAdd")
    public String doAdd(Manager manager, RedirectAttributes redirectAttributes) {
        if (StringUtils.isNotBlank(manager.getUsername()) && StringUtils.isNotBlank(manager.getPassword())) {
            String pwd = EncryptionUtils.getMD5(manager.getPassword());
            manager.setPassword(pwd);
            //将用户插进用户表
            managerService.insertManager(manager);
            redirectAttributes.addFlashAttribute("message", "添加成功");
            return "redirect:list";
        }
        redirectAttributes.addFlashAttribute("message", "添加失败");
        return "redirect:list";
    }

}
