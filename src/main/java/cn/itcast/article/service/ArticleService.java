package cn.itcast.article.service;

import cn.itcast.article.domain.PageBean;
import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.User;

public interface ArticleService {

    PageBean<Article> pageQuery(int cid, int currentPage, int pageSize, String aname);
    Article findOne(int aid);
    PageBean<Article> uidQueryarticle(int uid,int currentPage,int pageSize,String aname);

    void ArticleOn(User user, String cid, String aname, String name, String aInner);
    boolean isMyArticle(String aid,int uid);

    void ArticleUpdate(String aid, String cid, String aname, String name, String aInner);

    void ArticleDelete(String aid);

}
