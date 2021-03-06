package com.taotao.controller;

import com.taotao.common.pojo.EasyUIGridData;
import com.taotao.common.pojo.ImgUploadResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Panxiong
 * @date 2018/10/4 7:53
 * @projectname taotaoparent
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    private EasyUIGridData getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }


    @RequestMapping("/pic/upload")
    @ResponseBody
    private ImgUploadResult uploadItemImage(MultipartFile uploadFile){
        return itemService.uploadItemImage(uploadFile);
    }

}
