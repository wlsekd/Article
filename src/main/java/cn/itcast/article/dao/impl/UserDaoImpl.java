package cn.itcast.article.dao.impl;

import cn.itcast.article.dao.UserDao;
import cn.itcast.article.domain.User;
import cn.itcast.article.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    /**
     * 查找用户名是否存在返回用户或者null
     */
    public User findByUsername(String username) {
        //定义sql语句
        User user=null;
        try{
            String sql="select * from user where username = ? ";
            //执行
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        }catch (Exception e){

        }
        //返回
        return user;
    }

    /**
     * 保存注册用户用户
     * @param user
     */
    @Override
    public void save(User user) {
        //定义sql
        String sql="insert into user(username,password,name,birthday,sex,telephone,email) values(?,?,?,?,?,?,?) ";
        //执行
        template.update(sql,
                        user.getUsername(),
                        user.getPassword(),
                        user.getName(),
                        user.getBirthday(),
                        user.getSex(),
                        user.getTelephone(),
                        user.getEmail());
    }



    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user=null;
        try{
            String sql="select * from user where username = ? and password = ? ";
            //执行
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username,password);
        }catch (Exception e){

        }
        //返回
        return user;
    }
}
