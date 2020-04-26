package com.sxh.designMode.StrategyMode;/**
 * Created by SXH on 2019/8/5 23:23.
 */

/**
 * @author SXH
 * @description 验证策略模式
 * @date 2019/8/5 23:23.
 */
public class Test {
    public static void main(String[] args) {
        StrategyInterface strategyInterface1 = new StrategyA();
        StrategyInterface strategyInterface2 = new StrategyB();
        Context context1 = new Context(strategyInterface1);
        Context context2 = new Context(strategyInterface2);
        context1.strategyMethod();
        context2.strategyMethod();
    }
}
