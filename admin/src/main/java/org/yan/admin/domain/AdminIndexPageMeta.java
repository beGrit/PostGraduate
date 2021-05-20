package org.yan.admin.domain;

public class AdminIndexPageMeta {
    private String title;
    private String version;

    public AdminIndexPageMeta() {
        this.title = "后台管理页面";
        this.version = "1.0";
    }

    public AdminIndexPageMeta(String title, String version) {
        this.title = title;
        this.version = version;
    }
}
