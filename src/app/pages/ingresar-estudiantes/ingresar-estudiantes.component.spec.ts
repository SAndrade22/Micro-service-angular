import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresarEstudiantesComponent } from './ingresar-estudiantes.component';

describe('IngresarEstudiantesComponent', () => {
  let component: IngresarEstudiantesComponent;
  let fixture: ComponentFixture<IngresarEstudiantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IngresarEstudiantesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IngresarEstudiantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
