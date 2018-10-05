package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIGridData;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panxiong
 * @date 2018/10/4 7:52
 * @projectname taotaoparent
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUIGridData getItemList(Integer page, Integer rows) {
        EasyUIGridData result = new EasyUIGridData();
        //设置分页:
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();

        //查询信息：
        List<TbItem> tbItems = itemMapper.selectByExample(example);

        //取分页信息：
        PageInfo<TbItem> pageInfos = new PageInfo<TbItem>(tbItems);
        //将结果集注入返回结果中：
        List<TbItem> items = new ArrayList<>();
        for (TbItem item : tbItems) {
            items.add(item);
        }
        result.setTotal(pageInfos.getTotal());
        result.setRows(items);

        return result;
    }
}
