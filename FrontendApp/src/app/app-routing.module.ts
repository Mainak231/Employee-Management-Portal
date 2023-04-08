import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CanActivateRouteGuardService } from './services/can-activate-route-guard.service';
import { UserDetailsComponent } from './user-details/user-details.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent,canActivate:[CanActivateRouteGuardService]},
  {path:'register',component:RegisterComponent,canActivate:[CanActivateRouteGuardService]},
  {path:'userDetail/:id',component:UserDetailsComponent,canActivate:[CanActivateRouteGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
