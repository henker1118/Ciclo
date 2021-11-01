package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.CategoryRepository;
import com.thomas.gimnasio.entities.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return (List<Category>) categoryRepository.getAll();
	};

	public Optional<Category> getCategory(int id) {
		return categoryRepository.getCategory(id);
	};

	public Category save(Category category) {
		if (category.getId() == null) {
			return categoryRepository.save(category);
		} else {
			Optional<Category> co = categoryRepository.getCategory(category.getId());
			if (co.isEmpty()) {
				return categoryRepository.save(category);
			} else {
				return category;
			}
		}

	}

	public Category update(Category category) {
		if (category.getId() != null) {
			Optional<Category> g = categoryRepository.getCategory(category.getId());
			if (!g.isEmpty()) {
				if (category.getDescription() != null) {
					g.get().setDescription(category.getDescription());
				}
				if (category.getName() != null) {
					g.get().setName(category.getName());
				}
				categoryRepository.save(g.get());
				return g.get();

			} else {
				return category;
			}
		} else {
			return category;
		}
	}

	public boolean deleteCategory(int id) {
		Boolean result = getCategory(id).map(category -> {
			categoryRepository.delete(category);
			return true;
		}).orElse(false);
		return result;
	}
}
