package cn.itcast.article.service.impl;

import cn.itcast.article.dao.CommentDao;
import cn.itcast.article.dao.impl.CommentDaoImpl;
import cn.itcast.article.domain.Comment;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.service.CommentService;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao=new CommentDaoImpl();

    @Override
    public PageBean<Comment> fingByAid(String aid) {
        PageBean<Comment> pageBean=new PageBean<>();
        List<Comment> list = commentDao.findByAid(Integer.parseInt(aid));
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void saveComment(int uid, String name, String mInner, String aid) {
        commentDao.saveComment(uid,name,mInner,Integer.parseInt(aid),new Date());
    }

    @Override
    public void deleteComment(String mid) {
        commentDao.deleteComment(Integer.parseInt(mid));
    }

    @Override
    public boolean findComment(String mid, int uid) {
        boolean flag=false;
        Comment comment = commentDao.findComment(Integer.parseInt(mid), uid);
        if(comment!=null){
            flag=true;
        }
        return  flag;
    }

}
