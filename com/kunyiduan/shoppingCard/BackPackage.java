package com.kunyiduan.shoppingCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author achilles
 * @version 1.0.0
 * @Description 购物车可能组合-多个主件/主件+附件/
 * @createTime 2020/08/27 10:08:00
 */
public class BackPackage {

    private List<Goods> goodsList;

    public BackPackage() {
    }

    public BackPackage(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * 获取某个商品列表价格与重要度乘积的最大值
     * @param goodsList
     * @return
     */
    private int getMaxPriceImportance(List<Goods> goodsList){
        return goodsList.stream().mapToInt(x -> x.getImportance() * x.getPrice()).sum();
    }

    /**
     * 判断某个商品是否可以添加进商品迭代列表
     * @param goodsList
     * @param goods
     * @return
     */
    private static boolean isBelong(List<Goods> goodsList,Goods goods){
        AtomicBoolean result = new AtomicBoolean(false);
        //主件直接添加
        if(goods.getCategory() == 0){
            result.set(true);
        }else {
            //附件则需要对应的主件存在
            goodsList.stream().forEach(x -> {
                if(x.getId() == goods.getCategory()){
                    result.set(true);
                }
            });
        }
        return result.get();
    }

    /**
     * 动态规划中间结果递归,List<Goods>-商品列表，Integer-该商品列表的最大价格重要度
     * @param goodsList
     * @return
     */
    private Map<List<Goods>,Integer> max(List<Goods> goodsList,int money){
        Map<List<Goods>,Integer> result =  new HashMap<List<Goods>,Integer>();
        if(goodsList.size()==1){
            if(goodsList.get(0).getPrice() < money){
                result.put(goodsList,goodsList.get(0).getPrice()*goodsList.get(0).getImportance());
            }
        }else{

        }
        return result;
    }

    /**
     * 原始背包问题求解，即没有主件附件
     * @param goodsList
     * @param money
     * @return
     */
    public int[][] originalMax(List<Goods> goodsList,int money){
        int[][] dp = new int[goodsList.size()+1][money];
        //特殊节点——第一列和第一行，赋初始值-dp[i][0]=dp[0][j]=0
        for(int i = 0;i<goodsList.size();i++){
            dp[i][0]=0;
        }
        for (int j = 0;j<money;j++){
            dp[0][j]=0;
        }

        for(int i = 1;i<goodsList.size();i++){
            for(int j=1;j<=money;j++){
                int priceImportance=goodsList.get(i-1).getImportance()*goodsList.get(i-1).getPrice();
                if(j > priceImportance){
                    dp[i][j]=max(dp[i-1][j],dp[i-1][j-goodsList.get(i-1).getPrice()]+priceImportance);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;
    }

    private int max(int a,int b){
        return a > b ? a : b;
    }

}
