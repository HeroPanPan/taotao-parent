package com.taotao.service;

import com.taotao.common.pojo.EasyUIGridData;
import com.taotao.common.pojo.ImgUploadResult;
import com.taotao.pojo.TbItem;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Panxiong
 * @date 2018/10/4 7:51
 * @projectname taotaoparent
 */
public interface ItemService {
    TbItem getItemById(Long itemId);
    //根据前台传的页码和当前页显示条数查询所有商品列表：
    EasyUIGridData getItemList(Integer page,Integer rows);
    //上传图片：
    ImgUploadResult uploadItemImage(MultipartFile img);
}
