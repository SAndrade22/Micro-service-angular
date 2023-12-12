import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngresarEstudiantesComponent } from './pages/ingresar-estudiantes/ingresar-estudiantes.component';
import { CursosComponent } from './pages/cursos/cursos.component';  // Ajusta según sea necesario
import { ListarCursosComponent } from './pages/listar-cursos/listar-cursos.component';
import { ListarEstudiantesComponent } from './pages/listar-estudiantes/listar-estudiantes.component';

const routes: Routes = [
  { path: 'ingresar-estudiantes', component: IngresarEstudiantesComponent },
  { path: 'cursos', component: CursosComponent },
  { path: 'listar-estudiantes', component: ListarEstudiantesComponent },
  { path: 'listar-cursos', component: ListarCursosComponent },
  // ...otras rutas según sea necesario
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
