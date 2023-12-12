// src/app/pages/ingresar-estudiantes/ingresar-estudiantes.component.ts
import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { EstudianteService } from '../../services/estudiante.service';
import { Inscripcion } from '../../domain/inscripcion';

@Component({
  selector: 'app-ingresar-estudiantes',
  templateUrl: './ingresar-estudiantes.component.html',
  styleUrls: ['./ingresar-estudiantes.component.scss']
})
export class IngresarEstudiantesComponent {

  // Define un tipo para el objeto inscripcion
  inscripcion: Inscripcion = { nombre: '', curso: '', cedula: '' };

  constructor(private estudianteService: EstudianteService) {}

  @Output() cursoIngresado = new EventEmitter<any>();

  ingresarEstudiante(inscripcion: Inscripcion): void {
    console.log('Estudiante data:', inscripcion);
    this.estudianteService.ingresarEstudiante(inscripcion).subscribe(
      (response) => {
        console.log('Estudiante ingresado exitosamente:', response);
      },
      (error) => {
        console.error('Error ingresando curso:', error);
      }
    );
  }
}
