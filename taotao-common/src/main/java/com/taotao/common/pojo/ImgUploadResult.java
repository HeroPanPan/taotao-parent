package com.taotao.common.pojo;

/**
 * @author Panxiong
 * @date 2018/10/12 10:25
 * @projectname taotaoparent
 */
public class ImgUploadResult {
    private int error;
    private String url;
    private String message;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
