package cn.itcast.article.service;

import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.PageBean;

import java.util.List;

public interface FavoriteService {

    boolean isFavorite(String aid, int uid);

    void addFavorite(String aid, int uid);

    PageBean<Article> hotArticle();

}
