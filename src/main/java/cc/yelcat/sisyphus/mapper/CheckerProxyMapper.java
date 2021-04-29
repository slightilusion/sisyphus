package cc.yelcat.sisyphus.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cc.yelcat.sisyphus.entity.CheckerProxy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckerProxyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckerProxy record);

    int insertSelective(CheckerProxy record);

    CheckerProxy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckerProxy record);

    int updateByPrimaryKey(CheckerProxy record);

    int insertList(@Param("list")List<CheckerProxy> list);

    int deleteAll();



}