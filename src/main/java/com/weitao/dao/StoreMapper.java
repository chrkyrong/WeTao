package com.weitao.dao;

import com.weitao.bean.Seller;
import com.weitao.bean.Store;
import com.weitao.vo.StoreVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    /*查询卖家有多少的店铺*/
    List<Store> seleteStore(Store store);

    //    管理员，查询所有店铺
    List<StoreVo> managerSelectStore();

    //    管理员，根据状态查询店铺
    List<StoreVo> managerSelectByStatus(int status);

    //    管理员，根据店铺id查询店铺
    StoreVo managerSelectById(int stId);

    //    管理员，根据卖家id查询店铺
    List<StoreVo> selectStoreBySellerId(Seller seller);

    //    管理员，根据卖家名字模糊查询店铺
    List<StoreVo> selectStoreBySellerAccount(Seller seller);

    //    管理员，根据店铺名字模糊查询
    List<StoreVo> selectStoreByStoreName(String stName);

    //    管理员，根据店铺id多选查封和解封
    int changeStoreStatus(@Param("stId") List<Integer> stId, @Param("stStatus") Byte stStatus);

    //    管理员根据条件查询店铺
    List<StoreVo> managerSelectByCondition(@Param("stId") String stId,
                                           @Param("stStatus") Byte stStatus,
                                           @Param("stName") String stName,
                                           @Param("sId") String sId,
                                           @Param("sAccount") String sAccount);
}