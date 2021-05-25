package cc.yelcat.sisyphus.mapper;

import cc.yelcat.sisyphus.entity.TypechoRelationships;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TypechoRelationshipsMapper {
    int deleteByPrimaryKey(@Param("cid") Integer cid, @Param("mid") Integer mid);

    int insert(TypechoRelationships record);

    int insertSelective(TypechoRelationships record);
}