package com.sunsheng.modules.zk.zkTest;

import lombok.val;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class zkClient {
    private String connectString = "localhost:2182";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    /**
     * 连接测试
     *
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                    for (String s : children) {
                        System.out.println(s);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String nodeCreated = zkClient.create("/sunsss", "sunsheng.txt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取子节点并监听节点变化
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String s : children) {
            System.out.println(s);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 判断节点是否存在
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/sunsheng", false);
        System.out.println(stat == null ? "not" : "exist");
    }
}
