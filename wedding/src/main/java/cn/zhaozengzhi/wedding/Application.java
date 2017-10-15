package cn.zhaozengzhi.wedding;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhaozengzhi on 2017/8/25.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application
{
    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    public static void main(String[] args)
    {
        try
        {
            SpringApplication.run(Application.class, args);
        }
        catch (Exception e)
        {
            LOGGER.error("start service failed. ", e);
        }
    }
}
