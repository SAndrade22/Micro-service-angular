import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IngresarEstudiantesComponent } from './pages/ingresar-estudiantes/ingresar-estudiantes.component';
import { CursosComponent } from './pages/cursos/cursos.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './pages/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListarEstudiantesComponent } from './pages/listar-estudiantes/listar-estudiantes.component';
import { ListarCursosComponent } from './pages/listar-cursos/listar-cursos.component'; // Importa el módulo de MatToolbar
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    IngresarEstudiantesComponent,
    CursosComponent,
    HeaderComponent,
    ListarEstudiantesComponent,
    ListarCursosComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
