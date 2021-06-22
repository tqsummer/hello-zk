package com.study.hello.zk.basic.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

/**
 * @Classname CuratorUtil
 * @Description TODO
 * @Author Jack
 * Date 2021/6/15 21:58
 * Version 1.0
 */
public class CuratorUtil {

    private static String connectStr = "192.168.67.139:2184";

    private static TestingServer server = null;

    static {
        try {
            server = new TestingServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class InnerClass {
        private static CuratorFramework client = CuratorFrameworkFactory
                .builder()
                .connectString(connectStr)
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .build();
    }


    public static CuratorFramework getInstance() {
        return InnerClass.client;
    }
}
