package com.wench.order.controller;

import com.wench.order.entity.Order;
import com.wench.order.entity.OrderVO;
import com.wench.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "订单服务端口号："+ this.port;
    }

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 订单添加
     * @param order
     */
    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
    }

    /**
     * 通过用户id查询
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(uid,(page-1)*limit,limit));
        return orderVO;
    }

    /**
     * 删除
     * @param mid
     */
    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderRepository.deleteByMid(mid);
    }

    /**
     * 通过用户id删除
     * @param uid
     */
    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid){
        orderRepository.deleteByUid(uid);
    }

    /**
     * 通过状态查询
     * @param state
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByState(0));
        orderVO.setData(orderRepository.findAllByState(0,(page-1)*limit,limit));
        return orderVO;
    }

    /**
     * 修改订单
     * @param id
     * @param state
     * @param aid
     */
    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid){
        orderRepository.updateState(id,aid,state);
    }
}
