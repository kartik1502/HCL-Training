package org.training.bankapplication.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.training.bankapplication.entity.Transcation;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation, Long> {

	List<Transcation> findAllByTranscationDateTimeBetweenAndFromAccountNumberOrToAccountNumber(Date startDate,Date endDate, long fromAccountNumber, long toAccountNumber);

	List<Transcation> findAllByTranscationDateTimeBetween(Date valueOf, Date valueOf2);
	
	
	@Query("select t from Transcation t where (month(t.transcationDateTime) = :month and year(t.transcationDateTime) = :year) and (fromAccountNumber = :accountNumber or toAccountNumber = :accountNumber)")
	List<Transcation> statement(long accountNumber, int month, int year);

}
