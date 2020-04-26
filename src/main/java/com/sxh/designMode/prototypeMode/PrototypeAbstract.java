package com.sxh.designMode.prototypeMode;/**
 * Created by SXH on 2019/8/5 23:06.
 */

/**
 * @author SXH
 * @description 抽象原型类
 * @date 2019/8/5 23:06.
 */
public abstract class PrototypeAbstract implements Cloneable{

    public  PrototypeAbstract clone () {
        PrototypeAbstract prototypeAbstract = null;
        try {
            prototypeAbstract = (PrototypeAbstract) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  prototypeAbstract;
    }

    public abstract void show();
}
