package cn.itcast.article.web.servlet;

import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.PageBean;
import cn.itcast.article.domain.User;
import cn.itcast.article.service.FavoriteService;
import cn.itcast.article.service.impl.FavoriteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {
    FavoriteService favoriteService = new FavoriteServiceImpl();

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        boolean isFavorite;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        isFavorite = favoriteService.isFavorite(aid, uid);
        //writeValue(isFavorite, response);
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),isFavorite);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            return;
        } else {
            uid = user.getUid();
        }
        favoriteService.addFavorite(aid, uid);
    }

    public void hotFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean<Article> pageBean = favoriteService.hotArticle();

        //writeValue(pageBean, response);
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pageBean);
    }
}

