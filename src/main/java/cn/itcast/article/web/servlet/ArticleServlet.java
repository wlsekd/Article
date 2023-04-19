package cn.itcast.article.web.servlet;

import cn.itcast.article.domain.PageBean;
import cn.itcast.article.domain.Article;
import cn.itcast.article.domain.ResultInfo;
import cn.itcast.article.domain.User;
import cn.itcast.article.service.ArticleService;
import cn.itcast.article.service.impl.ArticleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/article/*")
public class ArticleServlet extends BaseServlet {
    private ArticleService articleService = new ArticleServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String aname = null;
        aname = request.getParameter("aname");
        aname = new String(aname.getBytes("iso-8859-1"), "utf-8");
        int cid = 0;//类别id
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 10;
        }
        //3. 调用service查询PageBean对象
        PageBean<Article> pb = articleService.pageQuery(cid, currentPage, pageSize, aname);
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pb);
        //writeValue(pb, response);
    }
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        Article article = articleService.findOne(Integer.parseInt(aid));
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),article);
        //writeValue(article, response);
    }
    public void pageQueryByuid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        User user = (User) request.getSession().getAttribute("user");
        int uid1 = user.getUid();
        String aname = null;
        aname = request.getParameter("aname");
        aname = new String(aname.getBytes("iso-8859-1"), "utf-8");
        int uid=uid1;
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 10;
        }
        PageBean<Article> pb = articleService.uidQueryarticle(uid, currentPage, pageSize, aname);
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pb);
    }
    public void articleOn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        String aname = request.getParameter("aname");
        String aInner = request.getParameter("aInner");
        String name = request.getParameter("name");
        User user = (User) request.getSession().getAttribute("user");
        articleService.ArticleOn(user,cid,aname,name,aInner);
    }

    public void isMyArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        User user = (User) request.getSession().getAttribute("user");
        int uid=0;
        if(user!=null){
             uid = user.getUid();
        }

        boolean myArticle = articleService.isMyArticle(aid, uid);
        ResultInfo info=new ResultInfo();
        if(myArticle){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("不是我的文章");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
    public void articleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String aid = request.getParameter("aid");
        String cid = request.getParameter("cid");
        String aname = request.getParameter("aname");
        String aInner = request.getParameter("aInner");
        String name = request.getParameter("name");
        articleService.ArticleUpdate(aid,cid,aname,name,aInner);
    }
    public void articleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String aid = request.getParameter("aid");
        articleService.ArticleDelete(aid);
    }
    }
