package com.taotao.common.utils;

import org.apache.commons.io.FileUtils;
import org.csource.fastdfs.*;

import java.io.File;

/**
 * @author Panxiong
 * @date 2018/10/12 10:39
 * @projectname taotaoparent
 */
public class FastDFSClientUtil {

    private String config = "D:\\alltools\\test_project\\taotaoparent\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\imgserver.properties";

    public FastDFSClientUtil() {

    }

    public FastDFSClientUtil(String config) {
//        if (config.startsWith("classpath:")) {
//            String filePath = config.substring(config.lastIndexOf("classpath:"), config.length());
//            String resourcesUrl = "";
//            config = resourcesUrl + filePath;
//        }
        this.config = config;
    }

    public String uploadFile(String uploadFile) throws Exception {
        String serverFilePath = "";
        ClientGlobal.init(this.config);
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file(FileUtils.readFileToByteArray(new File(uploadFile)), "jpg", null);
        for (String string : strings) {
            serverFilePath += string + "/";
        }
        return serverFilePath.substring(0, serverFilePath.lastIndexOf("/"));
    }
}
