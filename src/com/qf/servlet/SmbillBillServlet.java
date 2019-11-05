package com.qf.servlet;

import com.qf.bean.SmbillBill;
import com.qf.bean.SmbillSupplier;
import com.qf.service.SmbillBillService;
import com.qf.service.SmbillSupplierService;
import com.qf.service.impl.SmbillBillServiceImpl;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SmbillBillServlet",urlPatterns = "/smbillBill")
public class SmbillBillServlet extends HttpServlet {
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

    //添加账单信息
    protected void addSmbillBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面获取数据
        String billNum = request.getParameter("billNum");
        String commodity = request.getParameter("commodity");
        String scommNum = request.getParameter("commNum");
        int commNum = Integer.parseInt(scommNum);
        String smoney = request.getParameter("money");
        int money = Integer.parseInt(smoney);
        String discription = request.getParameter("discription");
        String supplierIdAndName = request.getParameter("supplierIdAndName");
        String[] idName = supplierIdAndName.split(",");//使用字符串切割
        String supplierid = idName[0];
        String supplierName = idName[1];
        String sisPay = request.getParameter("isPay");
        int isPay = Integer.parseInt(sisPay);
        SmbillBillService smbillBillService = new SmbillBillServiceImpl();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = sdf.format(date);
        Date createdate = null;
        try {
            createdate = sdf.parse( sdate );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SmbillBill smbillBill = new SmbillBill(billNum,commodity,commNum,money,isPay,supplierName,discription,createdate,supplierid);
        int i = smbillBillService.addSmbillBill(smbillBill);
        PrintWriter out = response.getWriter();
        if(i>0){
            out.write("<script>alert('添加成功！');location.href='smbillBill?method=queryAllSmbillBill'</script>");
        }else{
            out.write("<script>alert('添加失败！');location.href='smbillBill?method=queryAllSupplier'</script>");
        }
    }

    //查询账单信息
    protected void queryAllSmbillBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面数据
        String productName = request.getParameter("productName");
        String spayStatus = request.getParameter("payStatus");
        String sapage = request.getParameter("apage");
        //非空判断
        if(sapage==null){
            sapage="1";
        }
        int apage = Integer.parseInt(sapage);
        if(spayStatus==null){
            productName = "";
        }
        if(spayStatus==null){
            spayStatus = "-1";
        }
        int payStatus = Integer.parseInt(spayStatus);
        SmbillBillService smbillBillService = new SmbillBillServiceImpl();
        //分页----统计总帐单数
        Long countTotal = null;
        try {
            countTotal = smbillBillService.countTotal(productName, payStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //分页查询
        PageInfo pageInfo = PageInfoUtils.getPageInfo(apage, countTotal);
        List<SmbillBill> smbillBills = smbillBillService.queryAllSmbillBill(productName,payStatus,pageInfo.getOffset(),pageInfo.getSize());

        request.setAttribute("apage",apage);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("smbillBills",smbillBills);
        request.setAttribute("productName",productName);
        request.setAttribute("payStatus",payStatus);
        request.getRequestDispatcher("admin_bill_list.jsp").forward(request,response);
    }

    //搜寻所有供应商
    protected void queryAllSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SmbillSupplierService smbillSupplierService = new SmbillSupplierServiceImpl();
        try {
            List<SmbillSupplier> smbillSuppliers = smbillSupplierService.queryAllSupplier();
            request.setAttribute("smbillSuppliers",smbillSuppliers);
            request.getRequestDispatcher("modify.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
