package cn.my.model;

import java.io.Serializable;


public class Menu  implements Serializable {
   
	private Long id;

    private String textch;

    private String texten;

    private Long parentid;

    private Long orderid;

    private String url;

    private Long permissionid;

    private String imageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextch() {
        return textch;
    }

    public void setTextch(String textch) {
        this.textch = textch == null ? null : textch.trim();
    }

    public String getTexten() {
        return texten;
    }

    public void setTexten(String texten) {
        this.texten = texten == null ? null : texten.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}