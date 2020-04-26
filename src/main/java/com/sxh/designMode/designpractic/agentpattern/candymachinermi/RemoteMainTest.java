package com.sxh.designMode.designpractic.agentpattern.candymachinermi;

import com.sxh.designMode.designpractic.agentpattern.candymachine.CandyMachine;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class RemoteMainTest {
	public static void main(String[] args) {

		try {
			CandyMachine service = new CandyMachine("test1", 7);
			// LocateRegistry.createRegistry(6602);
			Naming.rebind("rmi://127.0.0.1:6602/test1", service);
			service.insertCoin();
			service = new CandyMachine("test2", 5);
			Naming.rebind("rmi://127.0.0.1:6602/test2", service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}

	}
}
