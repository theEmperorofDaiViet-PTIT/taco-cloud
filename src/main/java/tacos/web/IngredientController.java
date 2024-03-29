package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;
import tacos.Ingredient;
@Slf4j
@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientRepository ingredientRepo;

	@Autowired
	public IngredientController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("ingredient", new Ingredient(null, null, null));
		return "addIngredient";
	}
	
	@PostMapping
	public String addIngredient(Ingredient ingredient, Model model) {
	  ingredientRepo.save(ingredient);
	  model.addAttribute(ingredient);
	  log.info("Ingredient saved: " + ingredient);
	  return "addIngredientSuccess";
	}
}
