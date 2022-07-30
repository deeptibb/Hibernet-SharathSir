package com.xworkz.pen.service;

import java.util.List;

import com.xworkz.pen.dto.PenDTO;
import com.xworkz.pen.entity.PenEntity;

public interface PenService {

	boolean validateAllDetails(PenDTO penDTO);

	boolean saveAll(PenDTO penDTO);

	boolean validateSearchPenName(String name);

	public PenEntity findPenByName(String name);

	List<Object> getAllPenDetails();

	boolean validateDeletePenByName(String studentName);

	boolean deletePenByName(String name);

	boolean validateupdatePenByName(String name);

	boolean updatePenByName(String name);

}
