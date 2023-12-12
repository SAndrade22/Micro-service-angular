import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { CursoService } from '../../services/curso.service';
import { Curso } from '../../domain/curso';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.scss'
})
export class CursosComponent {
  curso = { nombre: '', descripcion: '' };
  constructor(private cursoService: CursoService) {}
  @Output() cursoIngresado = new EventEmitter<any>();


  ingresarCurso(curso: any): void {
    console.log('Curso data:', curso);
    this.cursoService.ingresarCurso(curso).subscribe(
      (response) => {
        console.log('Curso ingresado exitosamente:', response);
      },
      (error) => {
        console.error('Error ingresando curso:', error);
      }
    );
  }
}



/*
export class CursosComponent implements OnInit{
  descripcion: string = 'b'; // Declarar la propiedad 'apellido'
  nombre: string = 'b'; // Declarar la propiedad 'apellido'

  cursos: any[] = [];

  constructor(private cursoService: CursoService) {}

  ngOnInit(): void {
    this.cursoService.getAllCursos().subscribe(
      (data) => {
        this.cursos = data;
      },
      (error) => {
        console.error('Error fetching cursos:', error);
      }
    );
  }
  ingresarCurso(curso: any): void {
    console.log('Curso data:', curso);
    console.log('Nombre:', this.nombre);
    console.log('Descripcion:', this.descripcion);
  
    this.cursoService.ingresarCurso(curso).subscribe(
      (response) => {
        console.log('Curso ingresado exitosamente:', response);
      },
      (error) => {
        console.error('Error ingresando curso:', error);
      }
    );
  }
  
}

*/
