package com.taotao.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2017/3/5.
 */

public class FastdfsTest {
    @Test
    public void testUpload() throws IOException, MyException {
        //  1、把FastDFS提供的jar包添加到工程中
        //  2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("E:\\IdeaProjects\\taotao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
        //  3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        //  4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        //  5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        //  6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //  7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file("F:\\zhangyuTV.jpg", "jpg", null);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void testFastDfsClient() throws Exception {
        //不要带classpath
        FastDFSClient client = new FastDFSClient("properties/client.conf");
        String uploadFile = client.uploadFile("F:\\zhangyuTV.jpg", "jpg");
        System.out.println(uploadFile);
    }

}
