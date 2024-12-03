import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EvenementComponent} from './evenement/evenement.component';
import { AuthGuard } from './guards/secure.gard';


const routes: Routes = [
  //{path: "evenements", component : EvenementComponent},
  
    {path: "evenements", component : EvenementComponent,canActivate:[AuthGuard],data : {roles:['ADMIN']}},
    
  {path: "", redirectTo: "evenements", pathMatch:"full"},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
