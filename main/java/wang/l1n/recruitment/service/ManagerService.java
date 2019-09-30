package wang.l1n.recruitment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.l1n.recruitment.entity.Manager;
import wang.l1n.recruitment.mapper.ManagerMapper;

import java.util.List;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/7/3 20:41
 * @description：
 */

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 校验登录
     *
     * @param username
     * @return
     */
    public Manager checkLogin(String username) {
        return managerMapper.selectManagerByUsername(username);
    }

    public int insertManager(Manager manager) {
        return managerMapper.insertManager(manager);
    }

    public void addManagerToRole(int mid, int rid) {
        managerMapper.addManagerToRole(mid, rid);
    }

    public List<Manager> getManagerList() {
        return managerMapper.getManagerList();
    }

    public Manager getManagerById(int mid) {
        return managerMapper.getManagerById(mid);
    }

    public void updateManagerById(Manager manager) {
        managerMapper.updateManagerById(manager);
    }

    public void deleteManager(String id) {
        managerMapper.deleteManager(id);
        managerMapper.deleteManagerFromRole(id);
    }
}
