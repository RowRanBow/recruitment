package wang.l1n.recruitment.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wang.l1n.recruitment.realm.ShiroRealm;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/7/3 20:33
 * @description：
 */

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager());

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/asserts/**", "anon");
        filterMap.put("/manage/login", "anon");
        filterMap.put("/manage/doLogin", "anon");
        filterMap.put("/manage/logout", "logout");
        filterMap.put("/public","anon");
        filterMap.put("/manage/**/*", "authc");


        //设置登录界面
        shiroFilterFactoryBean.setLoginUrl("/manage/login");

        shiroFilterFactoryBean.setSuccessUrl("manage/main");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 配置SecurityManager，并注入shiroRealm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * 配置realm
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        // 配置Realm，需自己实现
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /**
     * shiro和thymeleaf集成
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * cookie对象
     *
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间 单位是秒
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     *
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}
