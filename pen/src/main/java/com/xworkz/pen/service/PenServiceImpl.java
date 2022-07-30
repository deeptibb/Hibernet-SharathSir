package com.xworkz.pen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.pen.dao.PenDAO;
import com.xworkz.pen.dto.PenDTO;
import com.xworkz.pen.entity.PenEntity;

@Component
public class PenServiceImpl implements PenService {

	@Autowired
	private PenDAO penDAO;

	public static Map<String, String> hashMap;

	public PenServiceImpl() {
		System.out.println("PenServiceImpl is created");
	}

	@Override
	public boolean validateAllDetails(PenDTO penDTO) {
		boolean flag = false;
		if (penDTO.getPenName() != null && !penDTO.getPenName().isEmpty() && !penDTO.getPenName().isBlank()) {
			flag = true;
			System.out.println("Name is valid : " + penDTO.getPenName());
		} else {
			flag = false;
			System.out.println("Name is not valid : ");
			hashMap.put("NAME", "Name is Invalid");
			return flag;
		}

		if (penDTO.getPenColor() != null && !penDTO.getPenColor().isEmpty() && !penDTO.getPenColor().isBlank()) {
			flag = true;
			System.out.println("Color is valid : " + penDTO.getPenColor());
		} else {
			flag = false;
			System.out.println("Color is not valid : ");
			hashMap.put("COLOR", "Color is Invalid");
			return flag;
		}

		if (penDTO.getPenPrice() > 10) {
			flag = true;
			System.out.println("Price is valid : " + penDTO.getPenPrice());
		} else {
			flag = false;
			System.out.println("Price is not valid : ");
			hashMap.put("PRICE", "Price is Invalid");
			return flag;
		}

		return flag;
	}

	@Override
	public boolean saveAll(PenDTO penDTO) {
		System.out.println("saveAll(PenDTO penDTO) started ");
		boolean issavePen = false;
		PenEntity penEntity = new PenEntity();

		System.out.println(penDTO + " penDTO inside service");

		BeanUtils.copyProperties(penDTO, penEntity);
		 issavePen = this.penDAO.savePen(penEntity);
		System.out.println("isDaoImplsaved is saved  at service " + issavePen);
		System.out.println(penEntity + " inside service if condition ");
		if (issavePen) {
			System.out.println("isDaoImplsaved in service " + issavePen);
			issavePen = true;
			System.out.println("issavePen is saved  at service " + issavePen);
		}
		return issavePen;
	}

	@Override
	public boolean validateSearchPenName(String name) {

		try {
			return name != null && !name.isEmpty() && !name.isBlank() ? true : false;

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public PenEntity findPenByName(String name) {
		try {
			System.out.println("Invoked findPenByName()");

		} catch (Exception e) {
		}
		return this.penDAO.findPenByName(name);
	}

	@Override
	public List<Object> getAllPenDetails() {
		ArrayList<Object> listOfObjects = null;
		List<PenEntity> list = this.penDAO.getAllPenDetails();
		if (list != null && !list.isEmpty()) {
			listOfObjects = new ArrayList<>();
			for (PenEntity penEntity : list) {
				listOfObjects.add(penEntity);
				System.out.println("Details" + penEntity.toString());
			}
		}
		return listOfObjects;
	}

	@Override
	public boolean validateDeletePenByName(String name) {

		try {
			return name != null && !name.isEmpty() && !name.isBlank() ? true : false;

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deletePenByName(String name) {
		boolean deletePenByName = false;
		deletePenByName = this.penDAO.deletePenByName(name);
		return deletePenByName;
	}

	@Override
	public boolean validateupdatePenByName(String name) {
		try {
			return name != null && !name.isEmpty() && !name.isBlank() ? true : false;

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updatePenByName(String name) {
		boolean updatePenByName = false;
		updatePenByName = this.penDAO.updatePenByName(name);
		return updatePenByName;
	}
}
