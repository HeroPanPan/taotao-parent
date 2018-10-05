package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeData;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
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
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public List<EasyUITreeData> getItemCatList(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        //组装查询条件：
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);

        List<EasyUITreeData> result = new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemCats) {
            EasyUITreeData easyUITreeData = new EasyUITreeData();
            easyUITreeData.setId(tbItemCat.getId());
            easyUITreeData.setText(tbItemCat.getName());
            easyUITreeData.setState(tbItemCat.getIsParent() ? "closed" : "open");
            result.add(easyUITreeData);
        }
        return result;
    }
}
