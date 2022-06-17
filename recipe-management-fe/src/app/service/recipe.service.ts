import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Recipe} from "../model/recipe";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private serviceUrl = environment.recipeBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(`${this.serviceUrl}/recipe/all`)
  }

  public addRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(`${this.serviceUrl}/recipe/add`, recipe)
  }

  public updateRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.put<Recipe>(`${this.serviceUrl}/recipe/update`, recipe)
  }

  public deleteRecipe(recipeId: number): Observable<void> {
    return this.http.delete<void>(`${this.serviceUrl}/recipe/delete/${recipeId}`)
  }
}
