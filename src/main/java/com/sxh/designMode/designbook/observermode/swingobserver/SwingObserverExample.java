package com.sxh.designMode.designbook.observermode.swingobserver;/**
 * Created by SXH on 2020/1/19 21:37.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author SXH
 * @description 简单的swing 应用：建立一个JFrame，然后放上一个按钮
 * @date 2020/1/19 21:37.
 */
public class SwingObserverExample {
	JFrame frame;

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}


	public void go () {
		frame = new JFrame();

		JButton button = new JButton("Should I do it");
		button.addActionListener(new AngelListener());// 制造出两个倾听者（观察者），一个天使，一个恶魔
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		// 在这里设置frame的属性
	}

	class AngelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Don't do it, you might regret it!");
		}
	}

	class DevilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Come on, do it!");
		}
	}
}
