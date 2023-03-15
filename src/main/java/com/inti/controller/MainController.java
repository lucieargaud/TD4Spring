package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.IVoitureRepository;
import com.inti.model.Voiture;

@Controller
public class MainController {

	@Autowired
	IVoitureRepository ivr;

	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("formVoiture")
	public String formVoiture() {
		return "formVoiture";
	}

	@PostMapping("saveVoiture")
	public String saveActeur(@ModelAttribute("acteur") Voiture v) {
		ivr.save(v);
		return "redirect:/listeVoiture";
	}

	@GetMapping("listeVoiture")
	public String listeVoiture(Model m) {
		m.addAttribute("listeVoiture", ivr.findAll());
		return "listeVoiture";
	}
	@GetMapping("getVoiture")
	public String getVoiture(@RequestParam("id") int id, Model m) {
		m.addAttribute("voiture", ivr.findById(id).get());
		return "getVoiture";
	}
	@GetMapping("deleteVoiture")
	public String deleteVoiture(@RequestParam("id") int id) {
		ivr.deleteById(id);
		return "redirect:/listeVoiture";
	}
	
	@GetMapping("modifierVoiture")
	public String modifierVoiture(@RequestParam("id") int id, Model m)
	{
		System.out.println(id);
		m.addAttribute("voiture", ivr.findById(id).get());
		return "modifierVoiture";
	}
	
	@PostMapping("updateVoiture") // Avec une requête Post donc bien =/= du @Get'modifVoiture'
	public String updateVoiture(@ModelAttribute("voiture") Voiture v)
	{
		ivr.save(v); // = saveOrUpdate
		return "redirect:/listeVoiture";
	}
}
