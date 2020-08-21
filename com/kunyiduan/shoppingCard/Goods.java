package com.kunyiduan.shoppingCard;

/**
 * @author achilles
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020/08/21 14:03:00
 */
public class Goods {

    /**
     * 第j行的数据，编号为j-1
     */
    private Integer id;

    private Integer price;

    private Integer importance;

    /**
     * 主件-0；附件-非0，表示归属于那个主件，如值为1，表示该物件是主件1的附件
     */
    private Integer category;

    public Goods() {
    }

    public Goods(Integer id, Integer price, Integer importance, Integer category) {
        this.id = id;
        this.price = price;
        this.importance = importance;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", price=" + price +
                ", importance=" + importance +
                ", category=" + category +
                '}';
    }

}
