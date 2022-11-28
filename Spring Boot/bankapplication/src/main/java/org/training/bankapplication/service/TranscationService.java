package org.training.bankapplication.service;

import java.util.List;

import org.training.bankapplication.entity.Transcation;


public interface TranscationService {



	List<Transcation> statement(long accountNumber, String date);
}
