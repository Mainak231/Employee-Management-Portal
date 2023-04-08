import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Employee } from '../Employee';
import { AuthService } from '../services/auth.service';
import { FetchDetailsService } from '../services/fetch-details.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit{

  employeeId:string ='';
  empDetails:any='';
  checkAdmin = false;

  constructor(private fetchService : FetchDetailsService,private route:ActivatedRoute,
              private authSerivce : AuthService){}

  ngOnInit(): void {
    if(this.authSerivce.getUserRole() == "ROLE_ADMIN"){
      this.checkAdmin = true;
    }
    else{
      this.checkAdmin = false;
    }
    this.employeeId = this.route.snapshot.params['id'];
    this.fetchService.getEmployee(this.employeeId).subscribe(
           (res:Employee[]) => {
               console.log(res);
               this.empDetails = res;
    });
  }

}
