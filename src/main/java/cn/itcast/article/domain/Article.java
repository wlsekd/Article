package cn.itcast.article.domain;

import java.io.Serializable;

/**
 * 旅游线路商品实体类
 */
public class Article implements Serializable {

    private int aid;//文章id，必输
    private String aname;//文章名称，必输
    private String aInner;//文章内容
    private String adate;   //上架时间
    private int count;//收藏数量
    private int cid;//所属分类，必输
    private int uid;//所属商家
    private String name;



    /**
     * 无参构造方法
     */
    public Article(){}


    public Article(int aid, String aname, String aInner, String adate, int count, int cid, int uid,String name) {
        this.aid = aid;
        this.aname = aname;
        this.aInner = aInner;
        this.adate = adate;
        this.count = count;
        this.cid = cid;
        this.uid = uid;
        this.name=name;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getaInner() {
        return aInner;
    }

    public void setaInner(String aInner) {
        this.aInner = aInner;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
