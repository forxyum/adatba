import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent} from './book-list/book-list.component' ;
import { UserFormComponent } from './auth/user-form/user-form.component';
import { LoginFormComponent } from './auth/login-form/login-form.component';
import { AuthGuard } from './auth/auth.guard';
import { BookComponent } from './book/book.component';
import { CartComponent } from './cart/cart.component';
import { BookAddComponent } from './book-add/book-add.component';
import { SearchComponent } from './search/search.component';
import { StatsComponent } from './stats/stats.component';


const routes: Routes = [
  { path: 'home', component: BookListComponent},
  { path: '', component: BookListComponent},
  { path: 'register', component: UserFormComponent},
  { path: 'login', component: LoginFormComponent},
  { path: 'catalog/:id', component: BookComponent, canActivate : [AuthGuard]},
  { path: 'cart', component: CartComponent, canActivate : [AuthGuard]},
  { path: 'add', component: BookAddComponent, canActivate : [AuthGuard]},
  { path: 'search', component:SearchComponent},
  { path: 'stats', component:StatsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
