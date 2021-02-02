import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TachesListComponent } from './components/taches-list/taches-list.component';

const routes: Routes = [
  {path : '', redirectTo : 'tasks', pathMatch : 'full'},
  {path : 'tasks', component : TachesListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
