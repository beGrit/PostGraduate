package org.yan.persistence.entity.university;

import org.yan.persistence.enums.AttachmentType;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Announcement {
    @Id
    private Long id;

    /**
     * 标题
     */
    @Column(nullable = false)
    private String title;

    /**
     * 发布时间
     * */
    private Date publishTime;

    /**
     * 附件链接
     */
    private String attachmentPath;

    /**
     * 附件类型
     */
    private AttachmentType attachmentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(AttachmentType attachmentType) {
        this.attachmentType = attachmentType;
    }
}
