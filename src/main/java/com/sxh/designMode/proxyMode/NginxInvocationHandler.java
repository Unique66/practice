package com.sxh.designMode.proxyMode;/**
 * Created by SXH on 2019/8/6 22:03.
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author SXH
 * @description Nginx InvocationHandler
 * @date 2019/8/6 22:03.
 */
public class NginxInvocationHandler implements InvocationHandler{

    /*
     * 新浪服务器列表
     */
//    private static final List<String> SINA_SERVER_ADDRESSES = Lists.newArrayList("192.168.1.1", "192.168.1.2", "192.168.1.3");
    private  List<String> SINA_SERVER_ADDRESSES = new ArrayList<String>();
    private Object object;

    public  NginxInvocationHandler (Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String remoteIP = UUID.randomUUID().toString();
        int index = Math.abs(remoteIP.hashCode()) % SINA_SERVER_ADDRESSES.size();
        String realSinaIp = SINA_SERVER_ADDRESSES.get(index);
        StringBuilder sb = new StringBuilder();
        sb.append("【页面标题：");
        sb.append(method.invoke(object, args));
        sb.append("】,【来源Ip：");
        sb.append(realSinaIp);
        sb.append("】");
        return sb.toString();
    }
}
