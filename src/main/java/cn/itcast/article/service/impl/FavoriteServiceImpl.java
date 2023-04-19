package cn.itcast.article.service.impl;

import cn.itcast.article.dao.FavoriteDao;
import cn.itcast.article.dao.impl.FavoriteDaoImpl;
import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.Favorite;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String aid, int uid) {
        Favorite favorite = favoriteDao.isFavorite(Integer.parseInt(aid), uid);
        return favorite!=null;
    }

    @Override
    public void addFavorite(String aid, int uid) {
        favoriteDao.addFavorite(Integer.parseInt(aid),uid);
    }

    @Override
    public PageBean<Article> hotArticle() {
        PageBean<Article> pageBean=new PageBean<>();
        pageBean.setList(favoriteDao.hotArticle());
        return pageBean;
    }
}
