import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './add-post/add-post.component';
import { AuthGuard } from './auth.guard';
import { LoginFailedComponent } from './auth/login-failed/login-failed.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccesComponent } from './auth/register-succes/register-succes.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { PostComponent } from './post/post.component';

const routes: Routes = [
{path: '', component: HomeComponent},
{path: 'article/get/:id', component: PostComponent},
{path: 'register', component: RegisterComponent},
{path: 'login', component: LoginComponent},
{path: 'register-success' , component: RegisterSuccesComponent},
{path: 'home', component: HomeComponent},
{path: 'add-post' , component: AddPostComponent , canActivate:[AuthGuard]},
{path: 'login-failed' , component: LoginFailedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
