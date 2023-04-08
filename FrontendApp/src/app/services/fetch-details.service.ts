import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../Employee';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class FetchDetailsService {

  constructor(private http : HttpClient,private authService : AuthService) { }

  getAllEmployees():Observable<any>{

    return this.http.get(`http://localhost:8080/api/v1/getAllUsers`);
  }

  getEmployee(employeeId:string):Observable<any>{
    return this.http.get(`http://localhost:8080/api/v1/getUser/${employeeId}`)
  }
}
