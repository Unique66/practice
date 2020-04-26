package com.sxh.designMode.designpractic.facadepattern;


import com.sxh.designMode.designpractic.facadepattern.hometheater.HomeTheaterFacade;

public class MainTest {
	public static void main(String[] args) {
		HomeTheaterFacade mHomeTheaterFacade=new HomeTheaterFacade();
		
		mHomeTheaterFacade.ready();
		mHomeTheaterFacade.play();
	}
}
