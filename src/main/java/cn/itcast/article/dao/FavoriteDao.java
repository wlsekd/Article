package cn.itcast.article.dao;

import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.Favorite;
import cn.itcast.article.domain.PageBean;

import java.util.List;

public interface FavoriteDao {
    public Favorite isFavorite(int aid,int uid);

    void addFavorite(int parseInt, int uid);
    public List<Article> hotArticle();

}
