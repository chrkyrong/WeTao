package com.weitao.service.serviceImpl;

import com.weitao.bean.Car;
import com.weitao.bean.Order;
import com.weitao.bean.Order_detail;
import com.weitao.dao.ItemsMapper;
import com.weitao.dao.OrderMapper;
import com.weitao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void insertOrders(List<Car> carList) {
        String[] storeArr = new String[carList.size()];
        String[] itemsArr = new String[carList.size()];


        int x = 0;
        for (Car cc : carList) {
            Integer storeId = itemsMapper.selectByPrimaryKey(cc.getItemsId()).getStoreId();
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

        for (int i = 0; i < list.size(); i++) {
//            创建订单
            Order order = new Order();
//            订单状态
            order.setoStatus((byte) 0);

        }
//        生成订单
//        System.out.println("插入前主键为："+order.getoId());
//        orderMapper.insertAndGetId(order);
//        返回添加订单后的主键
//        System.out.println("插入后主键为："+order.getoId());


//        生成订单详情循环
//        Order_detail order_detail = new Order_detail();
//        数量
//        order_detail.setOrDeNumber(2);
//        订单号
//        order_detail.setOrderId(3000006);
//        商品号
//        order_detail.setItemsId(8000000);
//        添加订单详情
//        System.out.println(order_detailMapper.insertSelective(order_detail));

    }


}
