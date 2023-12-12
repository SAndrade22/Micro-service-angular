import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private apiUrl = 'http://localhost:8091'; // Replace with your Spring Boot backend URL

  constructor(private http: HttpClient) {}

  getAllEstudiantes(): Observable<any[]> {
    const url = `${this.apiUrl}/api/inscripciones`; // Adjust the URL based on your API endpoint
    return this.http.get<any[]>(url);
  }

  ingresarEstudiante(inscripcion: any): Observable<any> {
    const url = `${this.apiUrl}/api/inscripciones`; // Adjust the URL based on your API endpoint
    return this.http.post(url, inscripcion);
  }
}
