package com.weitao.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weitao.bean.*;
import com.weitao.dao.*;
import com.weitao.service.OrderService;
import com.weitao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lzr on 2018/9/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private Order_detailMapper order_detailMapper;

    @Override
    public List<Order> getByUser1(int userId) {
        //根据用户id查询待发货订单
        return orderMapper.selectByUser1(userId);
    }

    @Override
    public List<Order> getByUser2(int userId) {
        //根据用户id查询已发货订单
        return orderMapper.selectByUser2(userId);
    }

    @Override
    public List<Order> getByUser3(int userId) {
        //根据用户id查询已签收订单
        return orderMapper.selectByUser3(userId);
    }

    @Override
    public List<Order> getByUser4(int userId) {
        //根据用户id查询退款中订单
        return orderMapper.selectByUser4(userId);
    }

    @Override
    public List<Order> getByUser(int userId) {
        //根据用户id查询所有订单
        return orderMapper.selectByUser(userId);
    }

    @Override
    public List<Order> getByUser9(int userId) {
        //根据用户id查询已评价订单
        return orderMapper.selectByUser9(userId);
    }

    @Override
    public Boolean confirmOrder(int oId) {
        //根据订单id确定订单
        if (orderMapper.confirmOrder(oId) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean refundOrder(int oId) {
        //根据订单id申请退款
        if (orderMapper.refundOrder(oId) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean cancelOrder(int oId) {
        //根据订单id取消订单
        if (orderMapper.cancelOrder(oId) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Order> addOrder(Integer userId, Byte oPost, String oAddress, String oMessage) {
//        购物车对象集合
        List<ItemsCar> carList = carMapper.selectAllItemsOfCarByUid(userId);
//        生成的List<Order>对象集合
        List<Order> orderList = new ArrayList<>();
//        用于判断库存是否足够的key
        boolean key = false;
        for (ItemsCar itemsCar : carList) {
//            找出商品对象
            Items items = itemsMapper.selectByPrimaryKey(itemsCar.getItemsId());
            /*判断库存*/
            if (itemsCar.getNumber() > items.getiExsit()) {
//                库存大于购买数，key=true
                key = false;
                break;
            }else {
                key = true;
            }
        }

        if (key) {
//        店铺id数组集合
            String[] storeArr = new String[carList.size()];
//        商品id数组集合
            String[] itemsArr = new String[carList.size()];
//        订单添加进数据库的数量
            int addCount = 0;

//                用于计数
            int x = 0;
            for (ItemsCar car : carList) {
//        总店铺id集合
                storeArr[x] = itemsMapper.selectByPrimaryKey(car.getItemsId()).getStoreId() + "";
//        总商品id集合
                itemsArr[x] = car.getItemsId() + "";
                x++;
            }

//        新建一个List
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < storeArr.length; i++) {
                list.add(storeArr[i]);
            }

        /*去重算法*/
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = list.size() - 1; j > i; j--) {
                    if (list.get(j).equals(list.get(i))) {
                        list.remove(j);
                    }
                }
            }

//        输出去重的list
//                System.out.println(list);


        /*创建订单*/
            for (int i = 0; i < list.size(); i++) {
                System.out.println("创建订单");
                Order order = new Order();
//            自动生成的订单状态,默认为0
                order.setoStatus((byte) 1);
//            留言
                order.setoMessage(oMessage);
//            收货地址
                order.setoAddress(oAddress);
//            邮寄方式
                order.setoPost(oPost);
//            下单时间
                order.setoDate(new Date());
//            商店id
                order.setStoreId(Integer.parseInt(list.get(i)));
//            用户id
                order.setUserId(userId);

                for (int j = 0; j < carList.size(); j++) {
//                比较店铺id，卖家id
                    if (itemsMapper.selectByPrimaryKey(carList.get(j).getItemsId()).getStoreId() == Integer.parseInt(list.get(i))) {
                        Integer abcId = storeMapper.selectByPrimaryKey(Integer.parseInt(list.get(i))).getSellerId();
                        order.setSellerId(abcId);
//                    总价格
                        BigDecimal total = carList.get(j).getiPrice().multiply(new BigDecimal(carList.get(j).getNumber()));
                        order.setoPrice(total);
                    }
                }

//                    System.out.println("*" + order);

            /*添加进数据库*/
                addCount = orderMapper.insertAndGetId(order);
//                    System.out.println("生成的主键" + order.getoId());
                orderList.add(order);


            /*生成订单详情*/
                for (int j = 0; j < carList.size(); j++) {
                    if (itemsMapper.selectByPrimaryKey(carList.get(j).getItemsId()).getStoreId() == Integer.parseInt(list.get(i))) {
                        Order_detail order_detail = new Order_detail();
//                    订单详情表
                        order_detail.setOrderId(order.getoId());
//                    商品id
                        order_detail.setItemsId(carList.get(j).getItemsId());
//                    商品数量
                        order_detail.setOrDeNumber(carList.get(j).getNumber());
                        System.out.println("***订单详情***" + order_detail);
//                    添加进数据库
                        order_detailMapper.insertSelective(order_detail);
                    }
                }

            }
//        判断订单是否生成
            if (addCount > 0) {
        /*清空购物车*/
                int clear = carMapper.deleteCarByUid(userId);
                if (clear > 0) System.out.println("购物车已清空");
                else System.out.println("购物车清空失败");

            /*商品库存减少、销量增加*/
                for (int i = 0; i < carList.size(); i++) {
                    int itemsId = carList.get(i).getItemsId();
                    Items itemsChange = itemsMapper.selectByPrimaryKey(itemsId);
//                库存减少
                    itemsChange.setiExsit(itemsChange.getiExsit() - carList.get(i).getNumber());
//                销量增加
                    itemsChange.setiSale(itemsChange.getiSale() + carList.get(i).getNumber());
//                更新库存、销量
                    itemsMapper.updateByPrimaryKeySelective(itemsChange);
                }
            } else {
                System.out.println("订单创建失败");
            }
//            }
        } else {
            for (ItemsCar itemsCar : carList) {
                Items items = itemsMapper.selectByPrimaryKey(itemsCar.getItemsId());
            /*判断库存*/
                if (itemsCar.getNumber() > items.getiExsit()) {
                    System.out.println(itemsCar.getNumber() + "less than " + items.getiExsit());
                    /*返回库存不足错误*/
//            创建假的order对象，用于报错
                    Order mistake = new Order();
//            设置错误信息
//                获得商品名
                    String errorMessage = "您所购买的商品“";
                    errorMessage += items.getiName();
                    errorMessage += " ”库存仅剩：";
                    errorMessage += "" + items.getiExsit();
                    errorMessage += "请重新选择商品数量";
                    mistake.setoMessage(errorMessage);
                    System.out.println(mistake.getoMessage());
//                前端判断List<Order>第一个对象的oId是否为空，为空时：输出oMessage信息
                    orderList.add(mistake);
                }
            }
        }
//        返回orderList
        return orderList;
    }


    @Override
    public PageInfo getCondition1(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> list=orderMapper.selectCondition1(map);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo get1(int sellerId,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.select1(sellerId);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo getCondition2(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> list=orderMapper.selectCondition2(map);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo get2(int sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.select2(sellerId);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo getCondition3(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> list=orderMapper.selectCondition3(map);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo get3(int sellerId,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.select3(sellerId);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo getCondition4(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> list=orderMapper.selectCondition4(map);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo get4(int sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.select4(sellerId);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo getCondition5(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> list=orderMapper.selectCondition5(map);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public PageInfo get5(int sellerId, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.select5(sellerId);
        PageInfo orderList=new PageInfo(list);
        return orderList;
    }

    @Override
    public Boolean sendOrder(int oId) {
        //根据订单id确定订单
        if (orderMapper.sendOrder(oId) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Order> selectAllOrderBySid(int sId) {
        return orderMapper.selectAllOrderBySid(sId);
    }
}
