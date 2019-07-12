package node;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        System.out.println("checkCodeServlet");
        int width = 120;
        int height = 40;
        // 1. 创建内存中图片对象（验证码图片）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        // 2. 美化图片
        // 2.1 填充颜色
        Graphics graphics = image.getGraphics();// 画笔对象
        graphics.setColor(Color.cyan);
        graphics.fillRect(0,0,width, height);

        // 2.2 画边框
        graphics.setColor(Color.MAGENTA);
        graphics.drawRect(0, 0, width-1, height-1);

        // 2.3 画上验证码
        String str = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0123456789";
        String resultStr = "";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            String ch = str.charAt(index)+"";
            graphics.drawString(ch, i*20, 20);
            resultStr += ch;
        }
        System.out.println("验证码为："+resultStr);

        // 2.4 设置干扰线
        graphics.setColor(Color.red);
        for (int i = 0; i <random.nextInt(10) ; i++) {

            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            graphics.drawOval(x1, y1, x2, y2); // 画○

            graphics.drawLine(x2, y2, x1, y1); // 划线
        }



        // 3. 将图片输出到页面展示
        boolean result = ImageIO.write(image, "jpg", resp.getOutputStream());
        if (result) {
            System.out.println("图片打印成功！");
        } else {
            System.out.println("图片打印失败！");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
