import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import * as XLSX from 'xlsx';
import { DataService } from '../../services/data.service'
import { UserListComponent } from "../../components/user-list/user-list.component";
@Component({
  selector: 'app-read-xlsx',
  templateUrl: './read-xlsx.component.html',
  styleUrls: ['./read-xlsx.component.scss']
})
export class ReadXlsxComponent implements OnInit {
  willDownload = false;
  dataFromReadXlsx:any;
  constructor(private dataService:DataService) { }

  ngOnInit() {
    
  }
  onFileChange(ev) {
    let workBook = null;
    let jsonData = null;
    const reader = new FileReader();
    const file = ev.target.files[0];
    reader.onload = (event) => {
      const data = reader.result;
      workBook = XLSX.read(data, { type: 'binary' });
      jsonData = workBook.SheetNames.reduce((initial, name) => {
        const sheet = workBook.Sheets[name];
        initial[name] = XLSX.utils.sheet_to_json(sheet);
        //console.log(initial);
        return initial;
      }, {});
      //console.log(jsonData);
      const dataString = JSON.stringify(jsonData);
      
      //document.getElementById('output').innerHTML = dataString.slice(0, 300).concat("...");
      //this.setDownload(dataString);
       
      this.sendData(dataString);
    }
    reader.readAsBinaryString(file);
  }
  setDownload(data) {
    this.willDownload = true;
    setTimeout(() => {
      const el = document.querySelector("#download");
      el.setAttribute("href", `data:text/json;charset=utf-8,${encodeURIComponent(data)}`);
      el.setAttribute("download", 'xlsxtojson.json');
    }, 1000)
  }
  sendData(data){
    this.dataService.sendData(data);
  }

}
