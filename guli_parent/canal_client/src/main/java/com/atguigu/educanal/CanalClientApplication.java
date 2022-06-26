package com.atguigu.educanal;

import com.atguigu.educanal.client.CanalClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @Author luokai
 */
@SpringBootApplication
public class CanalClientApplication implements CommandLineRunner {
    @Resource
    private CanalClient canalClient;

    public static void main(String[] args) {
        SpringApplication.run(CanalClientApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception{

        //项目启动，执行canal客户端监听
        canalClient.run();
    }
}
