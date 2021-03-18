import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { FooterComponent } from './footer/footer.component';
import { LeftPanelComponent } from './left-panel/left-panel.component';
import { MainPanelComponent } from './main-panel/main-panel.component';
import { AboutUsComponent } from './header-menu/about-us/about-us.component';
import { OtherProductsComponent } from './header-menu/other-products/other-products.component';
import { ContactComponent } from './header-menu/contact/contact.component';
import { ReferComponent } from './left-panel/refer/refer.component';
import { HowerdisplayDirective } from './Directives/howerdisplay.directive';
import { HttpClientModule } from '@angular/common/http';
import { LoginPageComponent } from './header-menu/login-page/login-page.component';
import { RegisterComponent } from './header-menu/register/register.component' 

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    HeaderMenuComponent,
    FooterComponent,
    LeftPanelComponent,
    MainPanelComponent,
    AboutUsComponent,
    OtherProductsComponent,
    ContactComponent,
    ReferComponent,
    HowerdisplayDirective,
    LoginPageComponent,
    RegisterComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
