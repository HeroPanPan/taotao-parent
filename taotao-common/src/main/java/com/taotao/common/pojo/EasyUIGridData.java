package com.taotao.common.pojo;

import java.util.List;

/**
 * @author Panxiong
 * @date 2018/10/5 10:43
 * @projectname taotaoparent
 */
public class EasyUIGridData {
    //Easyui中datagrid控件要求的数据格式为：
    //{total:”2”,rows:[{“id”:”1”,”name”,”张三”},{“id”:”2”,”name”,”李四”}]}
    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
