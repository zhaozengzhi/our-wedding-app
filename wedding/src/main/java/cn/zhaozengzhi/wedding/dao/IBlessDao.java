package cn.zhaozengzhi.wedding.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaozengzhi on 2017/8/25.
 */
@Repository
public interface IBlessDao
{
    public boolean addBless(@Param("user") String user);

    public List<String> getBless();
}
