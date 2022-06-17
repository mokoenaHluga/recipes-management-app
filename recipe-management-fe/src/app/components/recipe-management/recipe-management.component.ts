import {Component, OnInit} from '@angular/core';
import {Recipe} from "../../model/recipe";
import {RecipeService} from "../../service/recipe.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Ingredient} from "../../model/ingredient";

@Component({
  selector: 'app-recipe-management',
  templateUrl: './recipe-management.component.html',
  styleUrls: ['./recipe-management.component.css']
})
export class RecipeManagementComponent implements OnInit {

  public recipes: Recipe[] = [];
  public ingredients: Ingredient[] = [];
  public ingredentTitle: string = '';

  constructor(private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.getRecipes();
  }

  public getRecipes(): void {
    this.recipeService.getAllRecipes().subscribe(
      (response: Recipe[]) => {
        this.recipes = response;
        console.log(this.recipes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchRecipe(key: string): void {
    console.log(key);
    const results: Recipe[] = [];
    for (const recipe of this.recipes) {
      if (recipe.recipeTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || recipe.difficultyLevel.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || recipe.mealType.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(recipe);
      }
    }
    this.recipes = results;
    if (results.length === 0 || !key) {
      this.getRecipes();
    }
  }

  public viewIngredients(recipe: Recipe): void {
    this.ingredients = recipe.ingredients;
    this.ingredentTitle = recipe.recipeTitle
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    button.setAttribute('data-target', '#viewIngredients');

    // @ts-ignore
    container.appendChild(button);
    button.click();
  }
}
