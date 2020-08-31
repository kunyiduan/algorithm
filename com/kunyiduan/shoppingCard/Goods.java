package com.kunyiduan.shoppingCard;

/**
 * @author achilles
 * @version 1.0.0
 * @Description 同一物品最多只购买一次，即0-1背包问题
 * @createTime 2020/08/21 14:03:00
 */
public class Goods {

    /**
     * 第j行的数据，编号为j-1
     */
    private int id;

    private int price;

    private int importance;

    /**
     * 主件-0；附件-非0，表示归属于那个主件，如值为1，表示该物件是主件1的附件
     */
    private int category;

    public Goods() {
    }

    public Goods(int id, int price, int importance, int category) {
        this.id = id;
        this.price = price;
        this.importance = importance;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
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
