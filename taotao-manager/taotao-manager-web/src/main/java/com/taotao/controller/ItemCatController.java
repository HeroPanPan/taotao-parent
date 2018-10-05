package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeData;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Panxiong
 * @date 2018/10/5 11:29
 * @projectname taotaoparent
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    //注意此处@Requestparam的使用：
    private List<EasyUITreeData> showItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentid) {
        return itemCatService.getItemCatList(parentid);
    }
}
