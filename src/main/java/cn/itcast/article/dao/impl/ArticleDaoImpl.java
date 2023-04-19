package cn.itcast.article.dao.impl;

import cn.itcast.article.dao.ArticleDao;
import cn.itcast.article.domain.Article;
import cn.itcast.article.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int getTotalCount(int cid,String aname) {
        //String sql=" select count(*) from route where cid=? and rname like ";
        String sql=" select count(*) from article where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        //判断传入参数
        if(cid!=0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if(aname!=null||aname.length()>0){
            sb.append(" and aname like ? ");
            params.add("%"+aname+"%");
        }
        sql=sb.toString();
        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<Article> findByPage(int cid, int start, int pageSize, String aname) {
        //String sql=" select * from article where cid=? limit ?,? ";
        String sql = " select * from article where 1 = 1 ";
        //1.定义sql模板
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();//条件们
        //2.判断参数是否有值
        if(cid != 0){
            sb.append( " and cid = ? ");

            params.add(cid);//添加？对应的值
        }

        if((aname != null && aname.length() > 0)&&!" null ".equals(aname)){
            sb.append(" and aname like ? ");

            params.add("%"+aname+"%");
        }
        sb.append(" limit ? , ? ");//分页条件
        sql = sb.toString();
        //System.out.println(sb);
        //System.out.println(sql);
        params.add(start);
        params.add(pageSize);
        return template.query(sql,new BeanPropertyRowMapper<>(Article.class),params.toArray());
    }

    @Override
    public Article findOne(int aid) {
        String sql=" select * from article where aid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Article.class),aid);
    }

    @Override
    public List<Article> findByuid(int uid, int start, int pageSize, String aname) {
        String sql = " select * from article where 1 = 1 ";
        //1.定义sql模板
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //2.判断参数是否有值
        if(uid != 0){
            sb.append( " and uid = ? ");

            params.add(uid);//添加？对应的值
        }

        if((aname != null && aname.length() > 0)&&!" null ".equals(aname)){
            sb.append(" and aname like ? ");

            params.add("%"+aname+"%");
        }
        sb.append(" limit ? , ? ");//分页条件
        sql = sb.toString();
        //System.out.println(sb);
        //System.out.println(sql);
        params.add(start);
        params.add(pageSize);
        return template.query(sql,new BeanPropertyRowMapper<>(Article.class),params.toArray());
    }

    @Override
    public int getTotalCountByuid(int uid, String aname) {
        String sql=" select count(*) from article where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        //判断传入参数
        if(uid!=0){
            sb.append(" and uid = ? ");
            params.add(uid);
        }
        if(aname!=null||aname.length()>0){
            sb.append(" and aname like ? ");
            params.add("%"+aname+"%");
        }
        sql=sb.toString();
        int integer=0;
        try {
            integer = template.queryForObject(sql, Integer.class, params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public void ArticleOn(String aname, String aInner, Date date, int cid, int uid, String name) {
        String sql=" insert into article (aname,aInner,adate,cid,uid,name) values(?,?,?,?,?,?); ";
        template.update(sql,aname,aInner,date,cid,uid,name);
    }

    @Override
    public Article isMyArticle(int aid, int uid) {
        String sql=" select * from article where aid = ? and uid = ? ";
        Article article=null;
        try {
            article = template.queryForObject(sql, new BeanPropertyRowMapper<>(Article.class), aid, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public void ArticleUpdate(int aid, int cid, String aname, String name, String aInner) {
        String sql=" update article set aname = ? , name = ? , aInner = ? , cid = ? where aid = ? ";
        template.update(sql,aname,name,aInner,cid,aid);
    }

    @Override
    public void ArticleDelete(int aid) {
        String sql=" delete from article where aid = ? ";
        template.update(sql,aid);
    }
}
