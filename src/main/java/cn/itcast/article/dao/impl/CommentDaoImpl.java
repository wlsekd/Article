package cn.itcast.article.dao.impl;

import cn.itcast.article.dao.CommentDao;
import cn.itcast.article.domain.Comment;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Comment> findByAid(int aid) {
        List<Comment> list= null;
        try {
            String sql=" select * from comment where aid = ? ";
            list = template.query(sql, new BeanPropertyRowMapper<>(Comment.class), aid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveComment(int uid, String name, String mInner, int aid, Date date) {
        String sql="insert into comment (uid,name,mInner,aid,mdate) values (?,?,?,?,?) ";
        template.update(sql,uid,name,mInner,aid,date);
    }

    @Override
    public void deleteComment(int mid) {
        String sql="delete from comment where mid = ? ";
        template.update(sql,mid);
    }

    @Override
    public Comment findComment(int mid, int uid) {
        Comment comment = null;
        try {
            String sql=" select * from comment where mid =? and  uid = ?  ";
            comment = template.queryForObject(sql, new BeanPropertyRowMapper<>(Comment.class), mid, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return comment;
    }

}
