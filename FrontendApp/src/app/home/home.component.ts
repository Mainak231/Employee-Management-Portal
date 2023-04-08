import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Employee } from '../Employee';
import { AuthService } from '../services/auth.service';
import { CrudService } from '../services/crud.service';
import { FetchDetailsService } from '../services/fetch-details.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  showTable = false;

  empList: Employee[] = [];

  firstnames: string[] = []
  lastnames: string[] = []


  username: string = ''

  emp_id: string = '';

  checkAdmin = false;

  constructor(private authService: AuthService, private router: Router,
    private fetchService: FetchDetailsService, private crudService: CrudService) { }

  ngOnInit(): void {
    this.username = this.authService.getUsername();

    console.log(this.authService.getUserRole())
    if (this.authService.getUserRole() == "ROLE_ADMIN") {
      this.checkAdmin = true;
    }
    else {
      this.checkAdmin = false;
    }
  }
  handleLogout() {
    this.authService.deleteToken();
    this.router.navigate(['login'])
  }

  showEmpTable() {
    this.showTable = true;

    this.fetchService.getAllEmployees().subscribe((res) => {
      setTimeout(() => {
        // console.log(res[0].name.firstName);
        this.empList = res;
        console.log(this.empList)

        for (let i = 0; i < this.empList.length; i++) {
          this.firstnames[i] = res[i].name.firstName
          this.lastnames[i] = res[i].name.lastName
        }
      },2000);
    });
  }

  handleRegister() {
    this.router.navigateByUrl('register')
  }

  // showUserDetails(employeeId:string){
  //   console.log(employeeId);
  //   this.fetchService.getEmployee(employeeId).subscribe(
  //     (res) => {
  //         console.log(res);
  //         this.router.navigate(["/userDetail"]);
  //     }
  //   )
  // }

  sendId(id: string) {
    console.log(id)
    this.emp_id = id;
  }
  deleteEmployeeDetails(id: string) {
    console.log("Edit button clicked -- ", id)
    this.crudService.deleteDetails(+id).subscribe(
      (res) => {
        // console.log(res);

        if (id == this.authService.getUserId()) {
          this.router.navigate(['login']);
        }
        else {
          this.showEmpTable();
        }

      }
    )

  }
}
