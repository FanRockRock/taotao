package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by Administrator on 2017/3/6.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASE_URL;//

    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult pictureResult = new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            pictureResult.setError(1);
            pictureResult.setMessage("图片为空");
            return pictureResult;
        }
        //取图片扩展名
        String originalFilename = picFile.getOriginalFilename();
        System.out.println("originalFilename="+originalFilename);

        try {
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient fastDFSClient = new FastDFSClient("properties/client.conf");
            String url = fastDFSClient.uploadFile(picFile.getBytes(), extName);
            url=IMAGE_SERVER_BASE_URL+url;
            //把url响应给客户端
            pictureResult.setError(0);
            pictureResult.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
            pictureResult.setError(1);
            pictureResult.setMessage("图片上传失败");
        }
        return pictureResult;
    }
}
