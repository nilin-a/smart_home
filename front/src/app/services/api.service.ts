import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root', // Автоматически регистрируется как провайдер
})
export class ApiService {
  private baseUrl = 'http://localhost:8080'; // URL бэкенда

  constructor(private http: HttpClient) {}

  // Получение устройств
  getAirConditioners(): Observable<any> {
    return this.http.get(`${this.baseUrl}/air-conditioners`);
  }

  // Пример добавления устройства
  addAirConditioner(device: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/air-conditioners-info`, device);
  }
}
