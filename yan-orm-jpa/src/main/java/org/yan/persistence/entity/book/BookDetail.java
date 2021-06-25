package org.yan.persistence.entity.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BMS_BOOK_DETAIL")
public class BookDetail {
    @Id
    private Long id;

    private String bookSN;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍单价（原价）
     */
    private Double price;

    /**
     * 书籍折扣后价格
     */
    private Double discountPrice;

    /**
     * 折扣额度
     */
    private Double discount;

    /**
     * 书籍介绍
     */
    private String intro;

    /**
     * 封面图片地址
     */
    private String img;

    /**
     * 库存量
     */
    private int storage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
