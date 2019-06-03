package com.druid.test.config;

import com.druid.test.beans.User;
import com.druid.test.service.PermService;
import com.druid.test.service.RoleService;
import com.druid.test.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


/**
 * 实现AuthorizingRealm接口用户用户认证
 * 主要是自定义了如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/31 14:36
 * @Version 1.0
 */

public class MyShiroRealm extends AuthorizingRealm {

        @Autowired
        private UserService userService;
        @Autowired
        private RoleService roleService;
        @Autowired
        private PermService permService;

        //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
        {
            //设置用于匹配密码的CredentialsMatcher
            HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
            hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
            hashMatcher.setStoredCredentialsHexEncoded(false);
            hashMatcher.setHashIterations(1024);
            this.setCredentialsMatcher(hashMatcher);
        }


        //定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
            //null usernames are invalid
            if (principals == null) {
                throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
            }

            User user = (User) getAvailablePrincipal(principals);

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            System.out.println("获取角色信息："+user.getRoles());
            System.out.println("获取权限信息："+user.getPerms());
            info.setRoles(user.getRoles());
            info.setStringPermissions(user.getPerms());
            return info;
        }

        //定义如何获取用户信息的业务逻辑，给shiro做登录
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
            UsernamePasswordToken upToken = (UsernamePasswordToken) token;
            String username = upToken.getUsername();
            // Null username is invalid
            if (username == null) {
                throw new AccountException("Null usernames are not allowed by this realm.");
            }
            User userDB = userService.findUserByName(username);
            if (userDB == null) {
                throw new UnknownAccountException("No account found for admin [" + username + "]");
            }
            //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
            //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
            Set<String> roles = roleService.getRolesByUserId(userDB.getUid());
            Set<String> perms = permService.getPermsByUserId(userDB.getUid());
            userDB.getRoles().addAll(roles);
            userDB.getPerms().addAll(perms);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPwd(), getName());
            if (userDB.getSalt() != null) {
                info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
            }
            return info;
        }
}