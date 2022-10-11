package org.training.onetomany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.training.onetomany.dao.MobileDao;
import org.training.onetomany.dto.Mobile;
import org.training.onetomany.dto.Sim;

public class MobileController {

	public static void main(String[] args) {
		MobileDao mobileDao = new MobileDao();
		Scanner sc = new Scanner(System.in);
		boolean execute = true;
		while (execute) {
			System.out.println(
					"1.Save the Mobile and Sim.\n2.Get Mobile and Sim By Id.\n3.Update Mobile and Sim Details.\n4.Delete Mobile and Sim Details.\n5.Terminate.\nEnter your choice\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				Mobile mobile = new Mobile();
				System.out.println("Enter the Mobile Name:");
				mobile.setName(sc.next());
				System.out.println("Enter the Mobile Model:");
				mobile.setModel(sc.next());
				System.out.println("Enter the number of Sims: ");
				int n = sc.nextInt();
				List<Sim> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					Sim sim = new Sim();
					System.out.println("Enter the Sim Provider: ");
					sim.setName(sc.next());
					System.out.println("Enter the Sim Type: ");
					sim.setProvider(sc.next());
					list.add(sim);
				}
				mobile.setSims(list);
				mobileDao.saveMobileSim(mobile, list);
			}
				break;
			case 2: {
				System.out.println("Enter the Mobile Id: ");
				int id = sc.nextInt();
				System.out.println(mobileDao.getMobileDetailsById(id));
				break;
			}
			case 3: {
				System.out.println("Enter the Mobile Id: ");
				int id = sc.nextInt();
				System.out.println("Enter the Mobile Name: ");
				String mobileName = sc.next();
				System.out.println("Enter the old Sim Provider which you want to change: ");
				String oldSimProvider = sc.next();
				System.out.println("Enter the new Sim Provider: ");
				String newSimProvider = sc.next();
				mobileDao.updateMobileSimDetails(id, mobileName, oldSimProvider, newSimProvider);
				break;
			}
			case 4: {
				System.out.println("Enter the Mobile Id: ");
				int id = sc.nextInt();
				mobileDao.deleteMobileSimDetails(id);
			}
				break;
			case 5:
				execute = false;
				break;
			default:
				System.out.println("Invalid Choice\n");
			}
		}
		sc.close();
	}
}
