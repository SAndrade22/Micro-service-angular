import { Component, OnInit } from '@angular/core';
import { CursoService } from '../../services/curso.service';
import { Curso } from '../../domain/curso';

@Component({
  selector: 'app-listar-cursos',
  templateUrl: './listar-cursos.component.html',
  styleUrl: './listar-cursos.component.scss'
})
export class ListarCursosComponent implements OnInit {

  cursos: Curso[] = [];
  curso = { nombre: '', descripcion: '' };

  constructor(private cursoService: CursoService) {}


  ngOnInit(): void {
    this.obtenerCursos();
  }

  obtenerCursos(): void {
    this.cursoService.getAllCursos().subscribe(
      (data) => {
        this.cursos = data;
      },
      (error) => {
        console.error('Error fetching cursos:', error);
      }
    );
  }
}
