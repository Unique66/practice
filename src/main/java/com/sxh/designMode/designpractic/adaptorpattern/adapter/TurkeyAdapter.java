package com.sxh.designMode.designpractic.adaptorpattern.adapter;


import com.sxh.designMode.designpractic.adaptorpattern.duck.Duck;
import com.sxh.designMode.designpractic.adaptorpattern.turkey.Turkey;
// 对象适配器：适配器实现目标类接口，将被适配类组合到适配器中，通过构造函数引入被适配对象即可
public class TurkeyAdapter implements Duck {
	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey)
	{
		this.turkey=turkey;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		for(int i=0;i<6;i++)
		{
			turkey.fly();
		}
	}

}
