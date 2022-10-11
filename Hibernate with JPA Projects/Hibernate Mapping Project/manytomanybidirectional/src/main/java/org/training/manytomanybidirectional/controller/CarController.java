package org.training.manytomanybidirectional.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.training.manytomanybidirectional.dao.CarDao;
import org.training.manytomanybidirectional.dto.Car;
import org.training.manytomanybidirectional.dto.Features;

public class CarController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CarDao carDao = new CarDao();
		boolean execute = true;
		while(execute){
			System.out.println("1.Save Car Features details.\n2.Get Car Features details.\n3.Update Car Feature details.\n4.Delete Car Features details.\n5.Terminate.\nEnter your choice");
			int choice = sc.nextInt();
			switch(choice){
				case 1:{
					System.out.println("Enter the number of cars: ");
					int cars = sc.nextInt();
					List<Car> cars2 = new ArrayList<>();
					List<Features> features2 = new ArrayList<Features>();
					for(int i=0;i<cars;i++){
						Car car = new Car();
						System.out.println("Enter the Car Name: ");
						car.setCarName(sc.next());
						System.out.println("Enter the Car Price: ");
						car.setCarPrice(sc.nextInt());
						System.out.println("Enter the number of features: ");
						int features = sc.nextInt();
						for(int j = 0;j<features;j++){
							Features feature = new Features();
							System.out.println("Enter the feature Name: ");
							feature.setFeatureName(sc.next());
							features2.add(feature);
						}
						car.setFeatures(features2);
						cars2.add(car);
					}
					carDao.saveCarFeatures(cars2,features2);
				}
					break;
				case 5:execute = false;
					break;
			}
		}
		sc.close();
	}
}
