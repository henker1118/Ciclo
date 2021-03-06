package com.thomas.gimnasio.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.services.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

//    @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/all")
	public List<Category> getCategorys() {
		return categoryService.getAll();
	};

//    @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
		return categoryService.getCategory(categoryId);
	}

//    @CrossOrigin(origins = "http://132.226.240.254")
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category category) {
		return categoryService.save(category);
	};

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category update(@RequestBody Category category) {
		return categoryService.update(category);
	};

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int categoryId) {
		return categoryService.deleteCategory(categoryId);
	};
}
