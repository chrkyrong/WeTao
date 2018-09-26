package com.weitao.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.weitao.bean.Car;
import com.weitao.bean.Items;
import com.weitao.bean.Order;
import com.weitao.dao.ItemsMapper;
import com.weitao.dao.OrderMapper;
import com.weitao.service.OrderService;
import org.apache.commons.collections.IterableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Boolean confirmOrder(int oId) {
        //根据订单id确定订单
        if(orderMapper.confirmOrder(oId)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean refundOrder(int oId) {
        //根据订单id申请退款
        if(orderMapper.refundOrder(oId)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean cancelOrder(int oId) {
        //根据订单id取消订单
        if(orderMapper.cancelOrder(oId)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Order> order(List<Car> car) {
        //for(int i=0;i<car.size();i++)
            //遍历购物车的商品car[i].getId
            //mapper得到商品详情item
            //if(car[i].num>item.exist)
            //抛出异常商品数量不足

        String[] storeArr = new String[car.size()];
        String[] itemsArr = new String[car.size()];


        int x = 0;
        for (Car cc : car) {
            Integer storeId=itemsMapper.selectByPrimaryKey(cc.getItemsId()).getStoreId();
            storeArr[x] = storeId + "";
            itemsArr[x] = cc.getItemsId() + "";
            x++;
        }

//        新建一个List
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < storeArr.length; i++) {
            list.add(storeArr[i]);
        }

//        去重算法
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
//        用于记录的数组
        String[][] result = new String[list.size()][storeArr.length];
        x = 0;
        for (String str : list) {
            result[x][0] = "" + str;
            x++;
        }

//        输出去重的list
        System.out.println(list);


//        key
        int[] aa = new int[list.size()];
        for (int i = 0; i < aa.length; i++) {
            aa[i] = 1;
        }


//        标记函数
        for (int i = 0; i < storeArr.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (storeArr[i].equals(list.get(j))) {
                    result[j][aa[j]] = "" + itemsArr[i];
                    aa[j]++;
                }
            }
        }

//        遍历输出二维数组
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            for (int j = 0; j < storeArr.length; j++) {
                System.out.print(result[i][j] + "-");

            }
        }
        System.out.println();

        return  null;
    }

    @Override
    public List<Order> get1(Map<String, Object> map,int pageNum,int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum, pageSize);
        //分页查询
        List<Order> orderList=orderMapper.selectConditions(map);
        return orderList;
    }
}
