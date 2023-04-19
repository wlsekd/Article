package cn.itcast.article.web.servlet;

import cn.itcast.article.util.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
@MultipartConfig
@WebServlet("/file/*")
public class filetest extends BaseServlet {


    public void filetest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断上传数据是否是多段数据
//        if(ServletFileUpload.isMultipartContent(request)){
//            //创建fileitemfactory工厂实现类
//            FileItemFactory fileItemFactory=new DiskFileItemFactory();
//            //创建用于解析上传数据的工具类ServletFileUpload
//            ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory);
//            try {
//                List<FileItem> fileItems = fileUpload.parseRequest(request);
//                for(FileItem element : fileItems){
//                    if(element.isFormField()){
//                        System.out.println("表单项的name属性值："+element.getFieldName());
//                        System.out.println("表单项的value属性值："+element.getString("utf-8"));
//                    }else{
//                        System.out.println("表单项的name属性值："+element.getFieldName());
//                        System.out.println("上传文件名："+element.getName());
//                        element.write(new File("D:\\File\\"+element.getName()));
//                        JdbcTemplate template=new JdbcTemplate();
//                        String sql="insert into img (file) values(?) ";
//                        template.update(sql,element.getInputStream());
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        response.setContentType("image/jpg");
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
//        InputStream inputStream=null;
//        Part file = request.getPart("file");
//        if(file==null){
//            System.out.println("no file");
//            return;
//        }
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();}
//            JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
//                       String sql="insert into img (file) values(?) ";
//        try {
//            template.update(sql,inputStream);
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }


    }
}