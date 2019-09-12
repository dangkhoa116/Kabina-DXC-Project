import { Component, OnInit, TemplateRef, ViewChild, AfterViewInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { User } from "../../models/user.model";
import { NgForm,FormBuilder,Validators, FormGroup }   from '@angular/forms';
import { ReadXlsxComponent } from '../read-xlsx/read-xlsx.component';
import { DataService } from '../../services/data.service'
import { element } from '@angular/core/src/render3';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  
  public hideBtn = true;
  public receivedData:any;
  public userList: any;
  public currentUser: User;
  public userModel: User;
  public config: any;
  public configModal: any;
  public maxSize: number = 7;
  public directionLinks: boolean = true;
  public autoHide: boolean = false;
  public responsive: boolean = true;
 
  modalRef: BsModalRef;


  constructor(private _userService: UserService,
    private modalService: BsModalService,
    private dataService: DataService,
    private fb:FormBuilder
    ) { 
      
      
    }
    
  ngOnInit() {
    this.getAccounts();
    
    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
    };
    this.loadDataFromXlsx();
  }
  getAccounts() {
    this._userService.getUserList().subscribe(
      data => {
        this.userList = data;
      },
      err => {
        alert(err);
      });
  }
  loadDataFromXlsx() {
    this.dataService.myMethod$.subscribe(
      data => { 
        this.receivedData = data;
        this.hideBtn = false;
      },
      err => {
        alert(err);
      }
    );
  }

  addListUser() {
    let users:any[]= [];
    let dataName = Object.getOwnPropertyNames(JSON.parse(this.receivedData)).toString();
    users = JSON.parse(this.receivedData);
    for(let user of users[dataName])
    {
      this.onSubmitList(user);
    }
    this.getAccounts();
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
  modalDelete(template: TemplateRef<any>,user: any)
  {
    this.currentUser = user;
    this.modalRef = this.modalService.show(template, {class: 'modal-lg'});
  }
  modalEdit(template: TemplateRef<any>,user: any) {
    this.currentUser = user;
    this.modalRef = this.modalService.show(template, {class: 'modal-sm',ignoreBackdropClick: true});
  }
  modalAddUser(template: TemplateRef<any>){
    this.modalRef = this.modalService.show(template, {class: 'modal-sm',ignoreBackdropClick: true});
  }
  confirm(): void {
    this.modalRef.hide();
    //alert("Comfirm!");
  }
  decline() {
    //alert("declined!");
    this.modalRef.hide();
  }
  confirmDelete(user:any) {
    this.modalRef.hide();
    this._userService.deleteUser(user.userId).subscribe(
      data => {
        this.getAccounts();
      },
      err => {
        alert(err);
      });;
    this.getAccounts();
  }
  onSubmit(form: NgForm){
    this.modalRef.hide();
    this.userModel = form.value;
    this._userService.addUser(this.userModel).subscribe(
      data => {
        
        this.getAccounts();
      },
      err => {
        console.log(err);
        this.getAccounts();
      });;
  }
  onSubmitList(user:any){
    this.userModel = user;
    this._userService.addUser(this.userModel).subscribe(
      data => {
      },
      err => {
        console.log(err);
        this.getAccounts();
      });;
  }
  onSubmitEdit(form: NgForm){
    this.modalRef.hide();
    this.userModel = form.value;
    this._userService.editUser(this.userModel).subscribe(
      data => {
        this.getAccounts();
      },
      err => {
        alert(err);
        this.getAccounts();
      });;
  }

}
