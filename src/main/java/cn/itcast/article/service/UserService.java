package cn.itcast.article.service;

import cn.itcast.article.domain.User;

public interface UserService {
    /**
     * 注册
     * @param user
     * @return
     */
    boolean regist(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

}
