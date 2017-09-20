package pro.budthapa.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import pro.budthapa.enums.Difficulty;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving;
	private String source;
	private String url;
	private String directions;

	@Lob
	private byte[] image;

	// cascade is mentioned in the owning side, eg. Recipe has notes. so,
	// cascade id defined here,
	// If we delete Recipe object related Notes object is also deleted
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	// mappedBy=property defined on relationship class, ie.Ingredient class
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") 
	private Set<Ingredient> ingredients;
	
	//create a table name recipe_category, join column from recipe to category with name recipe_id
	//inverse the join from category to recipe with name category_id
	@ManyToMany
	@JoinTable(name="recipe_category", 
				joinColumns = @JoinColumn(name="recipe_id"),
				inverseJoinColumns= @JoinColumn(name="category_id"))
	private Set<Category> categories;

	@Enumerated(value=EnumType.STRING)
	private Difficulty difficulty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	public Integer getServing() {
		return serving;
	}

	public void setServing(Integer serving) {
		this.serving = serving;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
