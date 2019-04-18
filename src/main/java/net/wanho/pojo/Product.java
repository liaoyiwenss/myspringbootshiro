package net.wanho.pojo;

import net.wanho.pojo.base.BaseEntity;

public class Product extends BaseEntity {
    private String name;

    private String description;

    private Float price;

    private Integer stock;

    private Long categorylevel1id;

    private Long categorylevel2id;

    private Long categorylevel3id;

    private String filename;

    private Integer isdelete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getCategorylevel1id() {
        return categorylevel1id;
    }

    public void setCategorylevel1id(Long categorylevel1id) {
        this.categorylevel1id = categorylevel1id;
    }

    public Long getCategorylevel2id() {
        return categorylevel2id;
    }

    public void setCategorylevel2id(Long categorylevel2id) {
        this.categorylevel2id = categorylevel2id;
    }

    public Long getCategorylevel3id() {
        return categorylevel3id;
    }

    public void setCategorylevel3id(Long categorylevel3id) {
        this.categorylevel3id = categorylevel3id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}