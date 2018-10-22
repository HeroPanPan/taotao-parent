import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * @author Panxiong
 * @date 2018/10/11 17:27
 * @projectname taotaoparent
 */
public class TestUpload {
    //@Test
    public void testUpload() throws Exception {
        String config = "D:\\alltools\\test_project\\taotaoparent\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\imgserver.conf";
        String fileName = "C:\\Users\\Panxng\\Desktop\\TEMPfile\\WeChat 圖片_20180617123210.jpg";

        String serverFilePath = fastDfsClient(config, fileName);

        System.out.println(serverFilePath);
    }

    public String fastDfsClient(String config, String uploadFile) throws Exception {
        String str = "ABCD";
        System.out.println(str.substring(1,3));
        String serverFilePath = "";
        ClientGlobal.init(config);
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file(uploadFile, uploadFile.substring(uploadFile.lastIndexOf(".") + 1, uploadFile.length()), null);
        for (String string : strings) {
            serverFilePath += string + "/";
        }
        return serverFilePath;
    }
    @Test
    public void getUrl() throws URISyntaxException, IOException {

        InputStream resourceAsStream = this.getClass().getResourceAsStream("D:\\alltools\\test_project\\taotaoparent\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\imgserver.conf");
        Properties pro = new Properties();
        pro.load(resourceAsStream);
        String str = pro.getProperty("tracker_server");
        System.out.println(str);
    }
}
