package org.training.manytoonemapping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.training.manytoonemapping.dao.CollegeDao;
import org.training.manytoonemapping.dto.Building;
import org.training.manytoonemapping.dto.College;

public class CollegeController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CollegeDao collegeDao = new CollegeDao();

		boolean execute = true;
		while (execute) {
			System.out.println(
					"1.Save College Buildings.\n2.Get College Building details.\n3.Update College Building details.\n4.Delete College Details.\n5.Terminate.\nEnter your choice\n");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					College college = new College();
					List<Building> buildings = new ArrayList<Building>();
					System.out.println("Enter the College Name: ");
					college.setCollegeName(sc.next());
					System.out.println("Enter the College Address: ");
					college.setCollegeAddress(sc.next());
					System.out.println("Enter the number of Building: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						Building building = new Building();
						System.out.println("Enter the Building Name: ");
						building.setBuildingName(sc.next());
						System.out.println("Enter the Building Color: ");
						building.setBulidingColor(sc.next());
						buildings.add(building);
					}
					collegeDao.saveBuilding(college, buildings);
				}
					break;
				case 5:execute = false;
					break;
				default:System.out.println("Invalid Choice\n");
			}
		}

		sc.close();
	}
}
