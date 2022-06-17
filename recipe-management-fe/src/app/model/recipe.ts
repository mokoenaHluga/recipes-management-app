import {Ingredient} from "./ingredient";

export interface Recipe {
  id: number,
  recipeTitle: string,
  mealType: string,
  numberItServes: string,
  difficultyLevel: string,
  ingredients: Ingredient[]

}
