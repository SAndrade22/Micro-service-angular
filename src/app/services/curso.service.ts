import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CursoService {
  private apiUrl = 'http://localhost:8090'; // Replace with your Spring Boot backend URL

  constructor(private http: HttpClient) {}

  getAllCursos(): Observable<any[]> {
    const url = `${this.apiUrl}/api/cursos`; // Adjust the URL based on your API endpoint
    return this.http.get<any[]>(url);
  }

  ingresarCurso(curso: any): Observable<any> {
    const url = `${this.apiUrl}/api/cursos`; // Adjust the URL based on your API endpoint
    return this.http.post(url, curso);
  }
}


