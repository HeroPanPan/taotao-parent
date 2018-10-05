package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeData;

import java.util.List;

/**
 * @author Panxiong
 * @date 2018/10/5 11:31
 * @projectname taotaoparent
 */
public interface ItemCatService {

    List<EasyUITreeData> getItemCatList(Long id);
}
