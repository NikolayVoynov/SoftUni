import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from './shared/shared.module';
import { AppRoutingModule } from './app-routing.module';
import { AuthModule } from './auth/auth.module';
import { ThemeModule } from './theme/theme.module';
import { appInterceptorProvider } from './app.interceptor';

@NgModule({
  declarations: [
    AppComponent   
  ],
  imports: [
    AuthModule,
    ThemeModule,
    AppRoutingModule,
    BrowserModule,
    CoreModule,
    HttpClientModule,
    SharedModule,
  ],
  providers: [appInterceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
