package com.siniswift.webservice;
 
import java.util.List;
 
import javax.jws.WebParam;
import javax.jws.WebService;

import com.siniswift.model.Order;
 
@WebService
public interface IRemoteService {
     
    public String showRemoteMessage(@WebParam(name="arg0") String message);
     
    public String addOrder(List<Order> orders);
 
}