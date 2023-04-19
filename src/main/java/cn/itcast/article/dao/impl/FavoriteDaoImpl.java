package cn.itcast.article.dao.impl;

import cn.itcast.article.dao.FavoriteDao;
import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.Favorite;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite isFavorite(int aid, int uid) {
        Favorite favorite= null;
        try {
            String sql=" select * from favorite where aid=? and uid=? ";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<>(Favorite.class),aid,uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public void addFavorite(int parseInt, int uid) {
        String sql=" insert into favorite values (?,?,?)  ";
        template.update(sql,parseInt,new Date(),uid);
        sql=" update article set count=count+1 where aid= ? ";
        template.update(sql,parseInt);
    }

    @Override
    public List<Article> hotArticle() {
        String sql=" SELECT * FROM article ORDER BY count desc LIMIT 5 ";
        List<Article> articleList = template.query(sql, new BeanPropertyRowMapper<>(Article.class));
        return articleList;
    }
}
