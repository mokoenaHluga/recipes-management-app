import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RecipeManagementComponent} from "./components/recipe-management/recipe-management.component";

const routes: Routes = [
  {
    path: '',
    component: RecipeManagementComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
