package yunjinhz.print.Model;

import  java.util.Date;
public class Alert {
    public long ID;
    public String ALERTNO;
    public String ALERTNAME;

    public Date  ALERTOCCURTIME;

    /// <summary>
    /// 报警恢复时间
    /// </summary>
    public Date ALERTRESUMETIME ;

    /// <summary>
    /// 报警现象
    /// </summary>
    public String ALERTPHENOMENA ;

    /// <summary>
    /// 报警解决方法
    /// </summary>
    public String ALERTRESOLVEMETHOD ;

}
