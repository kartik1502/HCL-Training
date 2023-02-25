package org.training.onlinepetshop.service;

import javax.validation.Valid;

import org.training.onlinepetshop.dto.BuyPets;
import org.training.onlinepetshop.entity.UserPets;

public interface PurchaseService {

	UserPets buy(@Valid BuyPets pets);

}
