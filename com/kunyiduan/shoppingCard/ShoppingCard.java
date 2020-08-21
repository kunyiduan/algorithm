package com.kunyiduan.shoppingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author achilles
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020/08/21 14:19:00
 */
public class ShoppingCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //budget row : 总钱数 期望购买商品个数
        String budgetStr = sc.nextLine();
        String[] budgetArr = budgetStr.split(" ");
        int money = Integer.valueOf(budgetArr[0]);
        int count = Integer.valueOf(budgetArr[1]);

        //goods row : 价格 重要度 category
        List<Goods> goodsList = new ArrayList<>(10);
        int id = 1;//商品编号，所在数据行-1
        while (sc.hasNext()){
            String goodsStr = sc.nextLine();
            String[] goodsPropertyArr = goodsStr.split(" ");
            int price = Integer.valueOf(goodsPropertyArr[0]);
            int importance = Integer.valueOf(goodsPropertyArr[1]);
            int category = Integer.valueOf(goodsPropertyArr[2]);
            Goods goods = new Goods();
            goods.setId(id);
            goods.setPrice(price);
            goods.setImportance(importance);
            goods.setCategory(category);
            goodsList.add(goods);
            id++;
        }


    }
}
