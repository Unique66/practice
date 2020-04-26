package com.sxh.designMode.StrategyMode;/**
 * Created by SXH on 2019/8/5 23:24.
 */

/**
 * @author SXH
 * @description 某个类持有策略的引用
 * @date 2019/8/5 23:24.
 */
public class Context {
    private StrategyInterface strategyInterface;

    public Context(StrategyInterface strategyInterface) {
        this.strategyInterface = strategyInterface;
    }

    public void strategyMethod() {
        strategyInterface.say();
    }
}
