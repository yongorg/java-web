package com.yong.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 3. 获取请求体数据:
 * 				* 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
 * 				* 步骤：
 * 					1. 获取流对象
 * 						*  BufferedReader getReader()：获取字符输入流，只能操作字符数据
 * 						*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
 * 							* 在文件上传知识点后讲解
 *
 * 					2. 再从流对象中拿数据
 *
 */
@WebServlet("/Demo04Request")
public class Demo04Request extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost......");
        // 获取请求消息体，--- 请求参数

        // 1. 获取字符流
        BufferedReader br = req.getReader();
        String line = null;
        while ( (line = br.readLine()) != null){
            System.out.println(line);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doget....");
    }
}
