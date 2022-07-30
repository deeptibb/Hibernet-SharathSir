package com.xworkz.pen.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.pen.dao.PenDAO;
import com.xworkz.pen.dto.PenDTO;
import com.xworkz.pen.entity.PenEntity;
import com.xworkz.pen.service.PenService;
import com.xworkz.pen.service.PenServiceImpl;

@Component
@RequestMapping("/")
public class PenController {
	@Autowired
	private PenService penService;

	public PenController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}

	@RequestMapping(value = "/getimg.do")
	public String getJasminJpg() {
		System.out.println("Invoked getimage1Jpg");
		return "/WEB-INF/img1.jpg";
	}

	@RequestMapping("/getValues.do")
	public String getValues() {
		System.out.println("Invoked getValues()");
		return "pen";
	}

	@RequestMapping(value = "/saveValuesFromPage.do")
	public String saveValues(@ModelAttribute PenDTO penDTO, Model model) {
		System.out.println(" Invoked saveValues() ");
		System.out.println("PenName : " + penDTO.getPenName());
		System.out.println("PenColor : " + penDTO.getPenColor());
		System.out.println("PenPrice : " + penDTO.getPenPrice());

		boolean valid = this.penService.validateAllDetails(penDTO);
		System.out.println("In controller valid is  " + valid);

		if (valid) {
			System.out.println("Data is Valid");
			boolean result = this.penService.saveAll(penDTO);
			System.out.println(result + " Controller");

			if (result) {
				System.out.println("Saved to Database");
			} else {
				System.out.println("Not Saved to Database");
			}
		}

		else {
			System.out.println("The Data is Not Valid");
			Map<String, String> map = PenServiceImpl.hashMap;
			model.addAttribute("errorName", map.get("NAME"));
			model.addAttribute("errorColor", map.get("COLOR"));
			model.addAttribute("errorPrice", map.get("PRICE"));
		}
		return "pen";
	}

	@RequestMapping(value = "/searchPenByName.do")
	public String searchPenByName(@RequestParam String name, Model model) {
		System.out.println("Invoked searchPenByName() PenName : " + name);

		boolean validateSearchPenName = this.penService.validateSearchPenName(name);

		if (validateSearchPenName) {
			PenEntity penEntity = this.penService.findPenByName(name);
			System.out.println("givenpen " + penEntity);

			if (penEntity != null) {

				model.addAttribute("PenName", penEntity.getPenName());
				model.addAttribute("PenColor", penEntity.getPenColor());
				model.addAttribute("PenPrice", penEntity.getPenPrice());
			} else {
				model.addAttribute("ErrorPenName", "Results are not Found for the " + name);
			}
		} else {
			System.out.println("User data is not valid");

		}
		return "pen";
	}

	
	
	
	@RequestMapping("/getAllPenDetails.do")
	public String getAllPenDetails(Model model) {
		System.out.println("getAllPenDetails() details invoked");
		List<Object> allPenDetails = this.penService.getAllPenDetails();
		model.addAttribute("getAllPenDetails", allPenDetails);
		return "pen";
	}

	
	
	
	@RequestMapping(value = "/deletePenByName.do")
	public String deletePenByName(@RequestParam String name, Model model) {
		System.out.println("Invoked deletePenByName() PenName : " + name);

		boolean deletePenByName = this.penService.validateDeletePenByName(name);

		if (deletePenByName) {
			boolean penEntity = this.penService.deletePenByName(name);
			System.out.println(" in controller " + penEntity);

			if (deletePenByName) {

				model.addAttribute("PenNameDeleted", "" + name + " is deleted");

			} else {
				model.addAttribute("delete " + name + "  Results are not Found for the " + name);
			}
		} else {
			System.out.println("User data is not valid");

		}
		return "pen";
	}

	@RequestMapping(value = "/updatePenByName.do")
	public String updatePenByName(@ModelAttribute String name, Model model) {
		System.out.println("Invoked updatePenByName() PenName : " + name);
		boolean updatePenByName = this.penService.validateupdatePenByName(name);

		if (updatePenByName) {

			model.addAttribute("PenNameDeleted", "" + name + " is deleted");

		} else {
			System.out.println("user data not valid pls enter valid data");
			Map<String, String> mapContainer = PenServiceImpl.hashMap;
			model.addAttribute("delete " + name + "  Results are not Found for the " + name);
		}

		System.out.println("User data is not valid");

		return "pen";
	}

}