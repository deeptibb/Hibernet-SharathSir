package com.xworkz.pen.dao;

import java.util.List;

import com.xworkz.pen.entity.PenEntity;

public interface PenDAO {

	boolean savePen(PenEntity penEntity);

	public PenEntity findPenByName(String name);

	List<PenEntity> getAllPenDetails();

	boolean deletePenByName(String name);

	boolean updatePenByName(String name);

}
