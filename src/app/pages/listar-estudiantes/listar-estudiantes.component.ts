import { Component } from '@angular/core';
import { Inscripcion } from '../../domain/inscripcion';
import { EstudianteService } from '../../services/estudiante.service';

@Component({
  selector: 'app-listar-estudiantes',
  templateUrl: './listar-estudiantes.component.html',
  styleUrls: ['./listar-estudiantes.component.scss']  // Nota el uso de corchetes y la coma
})
export class ListarEstudiantesComponent {

  inscripciones: Inscripcion[] = [];
  inscripcion = { nombre: '', cedula: '', curso: '' };

  constructor(private estudianteService: EstudianteService) {}

  ngOnInit(): void {
    this.obtenerCursos();
  }

  obtenerCursos(): void {
    this.estudianteService.getAllEstudiantes().subscribe(
      (data) => {
        this.inscripciones = data;
      },
      (error) => {
        console.error('Error fetching cursos:', error);
      }
    );
  }
}
