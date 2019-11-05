package com.qf.servlet;

import com.qf.bean.SmbillSupplier;
import com.qf.service.SmbillSupplierService;
import com.qf.service.impl.SmbillSupplierServiceImpl;
import com.qf.util.PageInfo;
import com.qf.util.PageInfoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SmbillSuppliersServlet",urlPatterns = "/smbillSupplier")
public class SmbillSuppliersServlet extends HttpServlet {
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

    //添加供应商信息
    protected void addSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //从页面获取数据
        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        String proDesc = request.getParameter("proDesc");
        String contact = request.getParameter("contact");
        String phone = request.getParameter("phone");
        String fax = request.getParameter("fax");
        String address = request.getParameter("address");
        SmbillSupplier smbillSupplier = new SmbillSupplier(proId,proName,proDesc,contact,phone,fax,address);
        SmbillSupplierService smbillSupplierService = new SmbillSupplierServiceImpl();
        int i = smbillSupplierService.addSullpiers(smbillSupplier);
        PrintWriter out = response.getWriter();
        if(i>0){
            out.write("<script>alert('添加成功！');location.href='smbillSupplier?method=queryAllSuppliers'</script>");
        }else{
            out.write("<script>alert('添加失败！');location.href='providerAdd.jsp'</script>");
        }
    }

    //分页查询供应商信息
    protected void queryAllSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String providerName = request.getParameter("providerName");
        String providerDesc = request.getParameter("providerDesc");
        String sapage = request.getParameter("apage");
        if(sapage==null){
            sapage = "1";
        }
        int apage = Integer.parseInt(sapage);
        if(providerName==null){
            providerName="";
        }
        if(providerDesc==null){
            providerDesc="";
        }
        SmbillSupplierService smbillSupplierService = new SmbillSupplierServiceImpl();
        //分页---统计总页数
        Long totalCount = null;
        try {
            totalCount = smbillSupplierService.totalCount(providerName, providerDesc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = PageInfoUtils.getPageInfo(apage, totalCount);
        try {
            List<SmbillSupplier> smbillSuppliers = smbillSupplierService.queryAllSuppliers(providerName,providerDesc,pageInfo.getOffset(),pageInfo.getSize());
            request.setAttribute("smbillSuppliers",smbillSuppliers);
            request.setAttribute("providerName",providerName);
            request.setAttribute("providerDesc",providerDesc);
            request.setAttribute("apage",apage);
            request.setAttribute("pageInfo",pageInfo);
            request.getRequestDispatcher("providerAdmin.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
