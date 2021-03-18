import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { MainPanelComponent } from './main-panel/main-panel.component';
import { AboutUsComponent } from './header-menu/about-us/about-us.component';
import { OtherProductsComponent } from './header-menu/other-products/other-products.component';
import { ContactComponent } from './header-menu/contact/contact.component';
import { ReferComponent } from './left-panel/refer/refer.component';
import { LoginPageComponent } from './header-menu/login-page/login-page.component';
import { RegisterComponent  } from './header-menu/register/register.component';

const routes: Routes = [
  {path: '', component:MainPanelComponent},
  {path: 'home', component:MainPanelComponent},
  {path:'emp-list', component:EmployeeListComponent},
  {path:'about-us',component:AboutUsComponent},
  {path:'Others',component:OtherProductsComponent},
  {path:'Contact',component:ContactComponent},
  {path:'refer',component:ReferComponent},
  {path:'login', component:LoginPageComponent},
  {path:'login/register', component: RegisterComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
