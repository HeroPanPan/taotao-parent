import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Panxiong
 * @date 2018/10/5 0:59
 * @projectname taotaoparent
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");

        TbItemMapper itemMapper = ac.getBean(TbItemMapper.class);

        PageHelper.startPage(1, 15);

        TbItemExample example = new TbItemExample();

        List<TbItem> tbItems = itemMapper.selectByExample(example);

        //PageInfo<TbItem> pageInfos = new PageInfo<>(tbItems);

        //Page{pageNum=1, pageSize=15, startRow=0, endRow=15, total=3096, pages=207}
        //List<TbItem> list = pageInfos.getList();

        //System.out.println(list);

    }
}
