package cn.itcast.article.service.impl;

import cn.itcast.article.dao.CategoryDao;
import cn.itcast.article.dao.impl.CategoryDaoImpl;
import cn.itcast.article.domain.Category;
import cn.itcast.article.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao=new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        List<Category> ca=null;
        ca = categoryDao.findAll();
        return ca;
    }
}
