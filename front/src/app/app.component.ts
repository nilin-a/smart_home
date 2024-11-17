import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {NgIf} from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, UserProfileComponent, NgIf, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [ApiService],
})
export class AppComponent {
  title = 'Умный дом';

  showProfile = false;

  devices: any[] = [];

  toggleProfile() {
    this.showProfile = !this.showProfile;
  }

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getAirConditioners().subscribe(response => {
      this.devices = response;
      console.log('Devices:', this.devices);
    });
  }
}
