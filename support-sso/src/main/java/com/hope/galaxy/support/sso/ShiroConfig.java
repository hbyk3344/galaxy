package com.hope.galaxy.support.sso;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm(){
        return new UserRealm();
    }
    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition  shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        shiroFilterChainDefinition.addPathDefinition("/toLogin","anon,ssl");
        shiroFilterChainDefinition.addPathDefinition("/login","anon,ssl");
        shiroFilterChainDefinition.addPathDefinition("/sucess","anon,ssl");
        shiroFilterChainDefinition.addPathDefinition("/unauth","anon,ssl");
        shiroFilterChainDefinition.addPathDefinition("/**","authc,ssl");
        return shiroFilterChainDefinition;
    }
    @Bean
    DefaultSecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager());
        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        filterFactoryBean.setLoginUrl("toLogin");
        filterFactoryBean.setSuccessUrl("sucess");
        filterFactoryBean.setUnauthorizedUrl("unauth");
        return filterFactoryBean;
    }
}
