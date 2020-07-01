package life.majiang.community.bjsxt.mapper;

import life.majiang.community.bjsxt.pojo.ComUser;

public interface ComUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComUser record);

    int insertSelective(ComUser record);

    ComUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComUser record);

    int updateByPrimaryKey(ComUser record);
}