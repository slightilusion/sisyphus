package cc.yelcat.sisyphus.mapper;

import cc.yelcat.sisyphus.entity.TypechoContents;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypechoContentsMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TypechoContents record);

    int insertSelective(TypechoContents record);

    TypechoContents selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TypechoContents record);

    int updateByPrimaryKey(TypechoContents record);
}