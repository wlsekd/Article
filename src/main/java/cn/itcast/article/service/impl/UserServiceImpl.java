package cn.itcast.article.service.impl;

import cn.itcast.article.dao.UserDao;
import cn.itcast.article.dao.impl.UserDaoImpl;
import cn.itcast.article.domain.User;
import cn.itcast.article.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return bool
     */
    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User u=userDao.findByUsername(user.getUsername());
        //判断是否为空
        if(u!=null){
            return false;
        }
        userDao.save(user);
        return true;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
