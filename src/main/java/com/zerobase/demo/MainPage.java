package com.zerobase.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MainPage {

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<p>hello</p>" + "<p>festlms2 website!!!</p>" +
                "</body>" +
                "</html>";

        printWriter.write(msg);
        printWriter.close();
    }
}
