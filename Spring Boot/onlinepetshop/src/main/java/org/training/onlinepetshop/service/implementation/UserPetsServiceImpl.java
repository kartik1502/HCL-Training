package org.training.onlinepetshop.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.onlinepetshop.dto.History;
import org.training.onlinepetshop.entity.UserPets;
import org.training.onlinepetshop.repository.UserPetsRepository;
import org.training.onlinepetshop.service.UserPetsService;

@Service
public class UserPetsServiceImpl implements UserPetsService{

	@Autowired
	private UserPetsRepository userPetsRepository;
	
	@Override
	public List<History> history() {
		
		List<UserPets> userPets = userPetsRepository.findAll();
		List<History> purchases = new ArrayList<>();
		userPets.forEach(e -> {
			History purchaseHistory = new History();
			purchaseHistory.setPetName(e.getPet().getPetName());
			purchaseHistory.setPurchaseDate(e.getPurchasedDate());
			purchaseHistory.setPurchaseId(e.getUserPetId());
			purchaseHistory.setQuantity(e.getQuantity());
			purchaseHistory.setUserName(e.getUser().getFirstNme() +" "+ e.getUser().getLastName());
			purchases.add(purchaseHistory);
		});
		return purchases;
	}

}
