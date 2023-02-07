package org.training.employeemanagement.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.employeemanagement.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	Location findLocationByLocationName(@NotNull(message = "Location Name is required") String locationName);

}
