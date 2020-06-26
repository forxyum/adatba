import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BookListComponent } from './book-list/book-list.component';
import { MaterialModule } from './material.module';
import { SidenavComponent } from './sidenav/sidenav.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { UserService } from './auth/services/user.service';
import { UserFormComponent } from './auth/user-form/user-form.component';
import { LoginFormComponent } from './auth/login-form/login-form.component';
import { AuthGuard } from './auth/auth.guard';
import { BookComponent } from './book/book.component';
import { CartComponent } from './cart/cart.component';
import { BookAddComponent } from './book-add/book-add.component';
import { SearchComponent } from './search/search.component';
import { SearchPipe } from './search/search-pipe';
import { MatSelectModule } from '@angular/material/select';
import { StatsComponent } from './stats/stats.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    SidenavComponent,
    ToolbarComponent,
    UserFormComponent,
    LoginFormComponent,
    BookComponent,
    CartComponent,
    BookAddComponent,
    SearchComponent,
    StatsComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    MatSelectModule
  ],
  providers: [UserService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
