package cn.itcast.article.dao;

import cn.itcast.article.domain.Article;

import java.util.Date;
import java.util.List;

public interface ArticleDao {
    /**
     * 根据cid查询总记录数
     */
    public  int getTotalCount(int cid,String aname);

    /**
     * 根据cid，start，pageSize查询当前页面的数据集合
     */
    public List<Article> findByPage(int cid, int start, int pageSize, String aname);

    public Article findOne(int aid);

    /**
     * 根据用户名查找分页数据
     * @param uid
     * @param start
     * @param pageSize
     * @param aname
     * @return
     */
    public List<Article> findByuid(int uid,int start,int pageSize,String aname);

    /**
     * 根据uid查找总记录
     * @param uid
     * @param aname
     * @return
     */
    public  int getTotalCountByuid(int uid,String aname);


    public void ArticleOn(String aname, String aInner, Date date, int cid, int uid, String name);

    public Article isMyArticle(int aid,int uid);

    void ArticleUpdate(int aid, int cid, String aname, String name, String aInner);

    void ArticleDelete(int aid);
}
