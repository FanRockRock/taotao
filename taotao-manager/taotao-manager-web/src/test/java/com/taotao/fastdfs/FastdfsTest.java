package com.taotao.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/5.
 */
public class FastdfsTest {
    public void testUpload() throws IOException, MyException {
      //  1、把FastDFS提供的jar包添加到工程中
      //  2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("E:\\IdeaProjects\\taotao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
       // 3、创建一个TrackerClient对象。

      //  4、创建一个TrackerServer对象。
      //  5、声明一个StorageServer对象，null。
      //  6、获得StorageClient对象。
      //  7、直接调用StorageClient对象方法上传文件即可。

    }
}
