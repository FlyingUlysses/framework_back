package com.siniswift.webservice.impl;
 
import java.util.List;
 
import javax.jws.WebService;
 
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.siniswift.model.Order;
import com.siniswift.webservice.IRemoteService;
 
 
@WebService(endpointInterface="com.siniswift.webservice.IRemoteService") //endpointInterface这个不能写错了
public class RemoteServiceImpl implements IRemoteService {
     
    public String showRemoteMessage(String message) {
        return "You message is "+ message;
    }
 
    public String addOrder(List<Order> orders) {
        return JSONArray.toJSONString(orders,true);
    }
     
}