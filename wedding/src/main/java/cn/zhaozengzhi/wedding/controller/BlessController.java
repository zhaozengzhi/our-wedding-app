package cn.zhaozengzhi.wedding.controller;

import cn.zhaozengzhi.wedding.dao.IBlessDao;
import cn.zhaozengzhi.wedding.model.Bless;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaozengzhi on 2017/8/25.
 */
@RestController
@RequestMapping("/bless")
public class BlessController
{

    private static final Logger LOGGER = LogManager.getLogger(BlessController.class);

    @Autowired
    private IBlessDao blessDao;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean addBless(@RequestParam(value = "user", required = false, defaultValue = "anonymous") String user)
    {
        try
        {
            return blessDao.addBless(user);
        }
        catch (Exception e)
        {
            LOGGER.error("add bless failed. Error message:", e);
            return false;
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Bless> queryBless()
    {
        List<String> users = blessDao.getBless();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String user : users)
        {
            if (!map.containsKey(user))
            {
                map.put(user, 0);
            }
            map.put(user, map.get(user) + 1);
        }

        List<Bless> result = new ArrayList<Bless>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            result.add(new Bless(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
