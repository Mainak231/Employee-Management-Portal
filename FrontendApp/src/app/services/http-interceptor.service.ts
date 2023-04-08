import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor(private authService : AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let username = this.authService.getUsername();
    let pass = this.authService.password
    let token = this.authService.getBasicAuthToken();
    
    // let basicToken = 'Basic '+ btoa(username+":"+pass)

      if(username && token){
          request = request.clone({
            setHeaders : {
              Authorization : token
            }
          })
      }
      return next.handle(request);
  }
}
