package in.hocg.web.modules.system.domain;

import in.hocg.web.modules.base.BaseDomain;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by hocgin on 2017/11/17.
 * email: hocgin@gmail.com
 * 系统日志
 */
@Document(collection = "SysLog")
@Data
public class SysLog extends BaseDomain {
    public enum Type {
        INFO, WANING, ERROR
    }
    
    public enum From {
        Admin,
        Web,
        WeiXin,
        Api
    }
    
    @Transient
    public static String Document = "SysLog";
    @Id
    private String id;
    
    /**
     * 日志平台
     * INFO, WANING, ERROR
     */
    private String type;
    
    /**
     * 事件
     * - 用户登陆
     * - 增加XX
     */
    private String tag;
    /**
     * 执行类+函数
     * - in.hocg.MainController#login
     */
    private String src;
    /**
     * 请求的IP
     */
    private String ip;
    /**
     * 日志内容
     */
    private String msg;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 请求结果
     */
    private String result;
    
    /**
     * 操作人员
     */
    private String username;
    
    /**
     * 操作平台
     * [Admin, Web, WeiXin, Api]
     */
    private String from;
    
    /**
     * 消耗时间
     */
    private long usageTime;
    
    public SysLog(String type,
                  String tag,
                  String src,
                  String ip,
                  String msg,
                  String params,
                  String result,
                  String username,
                  String from) {
        this.type = type;
        this.tag = tag;
        this.src = src;
        this.ip = ip;
        this.msg = msg;
        this.params = params;
        this.result = result;
        this.username = username;
        this.from = from;
        this.createdAt = new Date();
    }
    
    
    public static SysLog NEW(String type,
                             String tag,
                             String src,
                             String ip,
                             String msg,
                             String params,
                             String result,
                             String username,
                             String from) {
        return new SysLog(type, tag, src, ip, msg, params, result, username, from);
    }
    
}
