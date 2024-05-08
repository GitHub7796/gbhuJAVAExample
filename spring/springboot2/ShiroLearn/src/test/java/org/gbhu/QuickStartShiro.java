package org.gbhu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickStartShiro {

    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();
    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    /**
     * 初始化 SecurityManager 环境
     */
    @BeforeEach
    public void init() {
        //初始化数据源
        accountRealm.addAccount("gbhu","123","root","admin");
        accountRealm.addAccount("beibei","456","user");

        //构造环境
        defaultSecurityManager.setRealm(accountRealm);
    }

    /**
     * 测试认证
     */
    @Test
    public void testAuthenticator() {
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //当前操作主题
        Subject subject = SecurityUtils.getSubject();

        //模拟用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken("gbhu", "1234");
        subject.login(usernamePasswordToken);

        System.out.println("认证结果："+subject.isAuthenticated());
    }

    /**
     * 测试授权
     */
    @Test
    public void testAuthorizer() {
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //当前操作主题
        Subject subject = SecurityUtils.getSubject();

        //模拟用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken("gbhu", "123");
        subject.login(usernamePasswordToken);

        System.out.println("login后，认证结果："+subject.isAuthenticated());
        System.out.println("是否有对应角色:" + subject.hasRole("root"));
        System.out.println("getPrincipal:" + subject.getPrincipal());
        subject.checkRole("user");
        subject.logout();
        System.out.println("logout后，认证结果："+subject.isAuthenticated());
    }
}
