import { Component, OnInit } from '@angular/core';
import { AppConfiguration } from 'src/app/kabina/services/app-config.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'kabina-ui';
  landingPageLink: any;

  constructor(public appConfiguration: AppConfiguration,
    private router: Router) { 
    }

  ngOnInit() {
    this.landingPageLink = this.appConfiguration.landingPageLink;
    this.router.navigate(this.landingPageLink);
  }
}
