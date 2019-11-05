package com.qf.servlet;

import com.qf.bean.SmbillUser;
import com.qf.service.SmbillUserService;
import com.qf.service.impl.SmbillUserServiceImpl;
import com.qf.util.PageInfo;
import com.qf.util.PageInfoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SmbillUserServlet",urlPatterns = "/smbillUser")
public class SmbillUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            String method = request.getParameter("method");
            Class aClass = this.getClass();
            Method declaredMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void addUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //从页面获取数据
        String suserId = request.getParameter("userId");
        int userId = Integer.parseInt(suserId);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ssex = request.getParameter("sex");
        int sex = Integer.parseInt(ssex);
        String sage = request.getParameter("age");
        int age = Integer.parseInt(sage);
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String sauth = request.getParameter("auth");
        int auth = Integer.parseInt(sauth);
        SmbillUser smbillUser = new SmbillUser(userId,username,password,sex,age,mobile,address,auth);
        SmbillUserService smbillUserService = new SmbillUserServiceImpl();
        try {
            int i = smbillUserService.addUsers(smbillUser);
            PrintWriter out = response.getWriter();
            if(i>0){
                out.write("<script>alert('添加成功！');location.href='smbillUser?method=queryAllUsers'</script>");
            }else{
                out.write("<script>alert('添加失败！');location.href='userAdd.jsp'</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void queryAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //从页面获取页面数据
        String userName = request.getParameter("userName");
        String sapage = request.getParameter("apage");
        if(sapage==null){
            sapage="1";
        }
        int apage = Integer.parseInt(sapage);
        if(userName==null){
            userName="";
        }
        //分页---查询总条数
        SmbillUserService smbillUserService = new SmbillUserServiceImpl();
        try {
            Long totalCount = smbillUserService.totalCount(userName);
            PageInfo pageInfo = PageInfoUtils.getPageInfo(apage, totalCount);
            List<SmbillUser> smbillUsers = smbillUserService.queryAllUser(userName,pageInfo.getOffset(),pageInfo.getSize());

            request.setAttribute("smbillUsers",smbillUsers);
            request.setAttribute("userName",userName);
            request.setAttribute("apage",apage);
            request.setAttribute("pageInfo",pageInfo);
            request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面数据
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        SmbillUserService smbillUserService = new SmbillUserServiceImpl();
        SmbillUser smbillUser = smbillUserService.queryByUserNameAndPassword(userName, passWord);
        PrintWriter out = response.getWriter();
        if(smbillUser==null){
            out.write("<script>alert('用户名或密码不正确！');location.href='login.jsp'</script>");
        }else{
            //将登录信息放入cookies
            Cookie userCookies = new Cookie("userName", smbillUser.getUserName());
            userCookies.setMaxAge(60*60*24*30);//如果不设置使用时间，那么将取不到Cookie的值
            response.addCookie(userCookies);
            request.setAttribute("smbillUser",smbillUser);
            request.getRequestDispatcher("admin_index.jsp").forward(request,response);
        }
    }

    //退出
    protected void backDown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }
}
