package cn.itcast.article.service.impl;

import cn.itcast.article.dao.ArticleDao;
import cn.itcast.article.dao.impl.ArticleDaoImpl;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.User;
import cn.itcast.article.service.ArticleService;

import java.util.Date;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao =new ArticleDaoImpl();
    @Override
    public PageBean<Article> pageQuery(int cid, int currentPage, int pageSize, String aname) {
        //封装PageBean
        PageBean<Article> pb=new PageBean<Article>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示页数
        pb.setPageSize(pageSize);
        //查询总记录数
        int totalCount= articleDao.getTotalCount(cid,aname);
        //设置总记录数
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*pageSize;
        List<Article> list = articleDao.findByPage(cid, start, pageSize,aname);
        //System.out.println(list);
        pb.setList(list);
        int totalPage=totalCount%pageSize==0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Article findOne(int aid) {
        return articleDao.findOne(aid);
    }

    @Override
    public PageBean<Article> uidQueryarticle(int uid, int currentPage, int pageSize, String aname) {
        PageBean<Article> pb=new PageBean<Article>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示页数
        pb.setPageSize(pageSize);
        //查询总记录数
        int totalCount= articleDao.getTotalCountByuid(uid,aname);
        //设置总记录数
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*pageSize;
        List<Article> list = articleDao.findByuid(uid, start, pageSize,aname);
        //System.out.println(list);
        pb.setList(list);
        int totalPage=totalCount%pageSize==0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void ArticleOn(User user, String cid, String aname, String name, String aInner) {
        int uid = user.getUid();
        articleDao.ArticleOn(aname,aInner,new Date(),Integer.parseInt(cid),uid,name);
    }

    @Override
    public boolean isMyArticle(String aid, int uid) {
        boolean flag=false;
        Article myArticle = articleDao.isMyArticle(Integer.parseInt(aid), uid);
        if (myArticle!=null){
            flag=true;
        }
        return flag;
    }

    @Override
    public void ArticleUpdate(String aid, String cid, String aname, String name, String aInner) {
        articleDao.ArticleUpdate(Integer.parseInt(aid),Integer.parseInt(cid),aname,name,aInner);
    }

    @Override
    public void ArticleDelete(String aid) {
        articleDao.ArticleDelete(Integer.parseInt(aid));
    }
}
