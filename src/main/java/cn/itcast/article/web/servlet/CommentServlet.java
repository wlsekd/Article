package cn.itcast.article.web.servlet;

import cn.itcast.article.domain.*;
import cn.itcast.article.service.CategoryService;
import cn.itcast.article.service.CommentService;
import cn.itcast.article.service.impl.CategoryServiceImpl;
import cn.itcast.article.service.impl.CommentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet {
    CommentService commentService = new CommentServiceImpl();

    public void findByAid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        PageBean<Comment> pageBean = commentService.fingByAid(aid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), pageBean);
    }

    public void saveComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String aid = request.getParameter("aid");
        String mInner = request.getParameter("mInner");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        String name = user.getName();
        commentService.saveComment(uid, name, mInner, aid);
    }

    public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        User user=null;
        user = (User) request.getSession().getAttribute("user");
        int uid=0;
        if(user!=null){
            uid=user.getUid();
        }
        boolean flag = commentService.findComment(mid, uid);
        ResultInfo resultInfo=new ResultInfo();
        if(flag){
            resultInfo.setFlag(true);
            commentService.deleteComment(mid);
        }else{
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("你没有权限删除改评论或未登录");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        //将json写回客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
}