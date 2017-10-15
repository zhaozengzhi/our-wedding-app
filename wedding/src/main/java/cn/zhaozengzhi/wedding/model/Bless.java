package cn.zhaozengzhi.wedding.model;

import lombok.Data;

/**
 * Created by zhaozengzhi on 2017/8/25.
 */
@Data
public class Bless
{
    private String user;

    private int number = 0;

    public Bless(String user, Integer number)
    {
        this.user = user;
        this.number = number;
    }
}
