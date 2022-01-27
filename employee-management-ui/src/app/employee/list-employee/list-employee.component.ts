import { Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../../model/employee.model";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  employees: Employee[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    this.router.navigate(['list-employee']);
    this.apiService.getEmployees()
      .subscribe( data => {
        this.employees = data;
      });
  }

  deleteEmployee(employee: Employee): void {
    this.apiService.deleteEmployee(employee.id)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee);
      })
  };

  editEmployee(employee: Employee): void {
    window.localStorage.removeItem("editEmployeeId");
    window.localStorage.setItem("editEmployeeId", employee.id.toString());
    this.router.navigate(['edit-employee']);
  };

  addEmployee(): void {
    this.router.navigate(['add-employee']);
  };
}
