package yunjinhz.print.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yunjinhz.print.Model.*;
import yunjinhz.print.Repository.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping("home/hello")
    public String hello() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("home/getAlerts")
    public List<Alert> GetList() {
        //test423453249999
        //test333
        //添加
        Alert alert = new Alert();
        alert.ALERTNO = "110";
        alert.ALERTNAME = "错误";
        alert.ALERTPHENOMENA = "打码机断开连接";
        alert.ALERTRESOLVEMETHOD = "打码机断开连接";
        AlertRepository alertRepository = new AlertRepository();
        try {
            alertRepository.Add(alert);
        } catch (SQLException exception) {
            int a=4;
        }
        //获取
        List<Alert> list = alertRepository.Query();
        return list;
    }

}
