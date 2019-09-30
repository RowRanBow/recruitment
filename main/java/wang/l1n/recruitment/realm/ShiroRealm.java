package wang.l1n.recruitment.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wang.l1n.recruitment.entity.Manager;
import wang.l1n.recruitment.entity.Permission;
import wang.l1n.recruitment.entity.Role;
import wang.l1n.recruitment.service.ManagerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/21 17:07
 * @description：
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    ManagerService managerService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Manager manager = (Manager) principals.getPrimaryPrincipal();
        List<String> permissionList = new ArrayList<>();
        Set<String> roleNameSet = new HashSet<>();

        //获取用户的角色集
        Set<Role> roleSet = manager.getRoles();
        if (!CollectionUtils.isEmpty(roleSet)){
            for (Role role : roleSet){
                //添加角色名称
                roleNameSet.add(role.getRname());
                //获取角色的权限集
                Set<Permission> permissionSet = role.getPermissions();
                if (!CollectionUtils.isEmpty(permissionSet)){
                    for (Permission permission: permissionSet){
                        //添加权限的名称
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.setRoles(roleNameSet);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = (String) token.getPrincipal();
        Manager manager = managerService.checkLogin(username);
        if (manager == null){
            throw new UnknownAccountException("用户名或密码输入错误");
        }
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(manager,manager.getPassword(),this.getClass().getName());
        return info;
    }

}
