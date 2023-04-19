package cn.itcast.article.service;

import cn.itcast.article.domain.Comment;
import cn.itcast.article.domain.PageBean;

public interface CommentService {
    public PageBean<Comment> fingByAid(String aid);

    void saveComment(int uid, String name, String mInner, String aid);
    void deleteComment(String mid);
    boolean findComment(String mid ,int uid );
}
