package cn.itcast.article.dao.impl;

import cn.itcast.article.dao.CategoryDao;
import cn.itcast.article.domain.Category;
import cn.itcast.article.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql="select * from category";
        return template.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
