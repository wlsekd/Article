package cn.itcast.article.dao;

import cn.itcast.article.domain.Comment;
import cn.itcast.article.domain.PageBean;

import java.util.Date;
import java.util.List;

public interface CommentDao {
    public List<Comment> findByAid(int aid);

    void saveComment(int uid, String name, String mInner, int aid, Date date);
    void deleteComment(int mid);
    Comment findComment(int mid,int uid);
}
