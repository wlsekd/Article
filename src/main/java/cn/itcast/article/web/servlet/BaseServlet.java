package cn.itcast.article.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException{
//        1.Class.forName("全类名")：将字节码文件加载进内存，返回Class对象。多用于配置文件，将类名定义在配置文件中。读取文件，加载对象。
//
//        2.类名.Class:通过类名的属性Class获取。这是在没有创建对象的时候。多用于参数的传递
//
//        3.对象.getClass():封装在Object类中，多用于对象获取字节码的方式。
//        通过Class对象获取类中成员方法的方法如下：
//
//        *Method[] gstMethods()
//                *Method getMethod(String name,<类>...Parameter Types)
//        *Method[] gstDeclaredMethods()
//                *Method getDeclaredMethod(String name,<类>...Parameter Types)
        String uri=req.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        try {

            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (InvocationTargetException e) {
                e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
