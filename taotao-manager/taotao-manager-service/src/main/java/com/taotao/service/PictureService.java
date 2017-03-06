package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/3/6.
 */
public interface PictureService {
    public PictureResult uploadPic(MultipartFile picFile);
}
