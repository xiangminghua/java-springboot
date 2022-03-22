package yunjinhz.print.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

import yunjinhz.print.Model.*;

public class AlertRepository {

    //增加
    public void Add(Alert alert) throws SQLException {
        //2. 获得数据库连接
        Connection conn = DbUtil.getConnection();

        //sql
        String sql = "INSERT INTO alert(ALERTNO, ALERTNAME, ALERTOCCURTIME, ALERTRESUMETIME, ALERTPHENOMENA, ALERTRESOLVEMETHOD)"
                + "values(?,?,CURRENT_DATE(),CURRENT_DATE(),?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1, alert.ALERTNO);
        ptmt.setString(2, alert.ALERTNAME);
        ptmt.setString(3, alert.ALERTPHENOMENA);
        ptmt.setString(4, alert.ALERTRESOLVEMETHOD);
        //执行
        ptmt.execute();
    }

    //更新
    public void Update(Alert alert) {
        try {
            //获取连接
            Connection conn = DbUtil.getConnection();
            //sql, 每行加空格
            String sql = "UPDATE alert" +
                    " set ALERTNAME=?, ALERTOCCURTIME=?," +
                    " ALERTRESUMETIME=CURRENT_DATE() " +
                    " where id=?";
            //预编译
            PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

            //传参
            ptmt.setString(1, alert.ALERTNO);
            ptmt.setString(2, alert.ALERTNAME);
            ptmt.setLong(3, alert.ID);

            //执行
            ptmt.execute();

        } catch (SQLException ex) {

        }

    }

    //列表
    public List<Alert> Query() {
        List<Alert> list = new ArrayList<Alert>();
        try {

            Connection conn = DbUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alert");

            Alert alert = null;
            while (rs.next()) {
                alert = new Alert();
                alert.ID = rs.getLong("ID");
                alert.ALERTNO = rs.getString("ALERTNO");
                alert.ALERTNAME = rs.getString("ALERTNAME");
                alert.ALERTPHENOMENA = rs.getString("ALERTPHENOMENA");
                alert.ALERTRESOLVEMETHOD = rs.getString("ALERTRESOLVEMETHOD");

                alert.ALERTOCCURTIME = rs.getDate("ALERTOCCURTIME");
                alert.ALERTRESUMETIME = rs.getDate("ALERTRESUMETIME");

                list.add(alert);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

}

