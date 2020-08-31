package com.kunyiduan.shoppingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author achilles
 * @version 1.0.0
 * @Description 类似于0-1背包问题
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
        //商品编号=所在数据行-1
        int id = 1;
        while (id <= count){
            String goodsStr = sc.nextLine();
            String[] goodsPropertyArr = goodsStr.split(" ");
            int price = Integer.parseInt(goodsPropertyArr[0]);
            int importance = Integer.parseInt(goodsPropertyArr[1]);
            int category = Integer.parseInt(goodsPropertyArr[2]);
            Goods goods = new Goods();
            goods.setId(id);
            goods.setPrice(price);
            goods.setImportance(importance);
            goods.setCategory(category);
            goodsList.add(goods);
            id++;
        }

        BackPackage backPackage = new BackPackage();
        int[][] ints = backPackage.originalMax(goodsList, money);
        System.out.println(ints[goodsList.size()+1][money]);

    }



}
