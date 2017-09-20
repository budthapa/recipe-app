package pro.budthapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.budthapa.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
