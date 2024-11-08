import { Component, Output, EventEmitter } from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  @Output() profileClicked = new EventEmitter<void>();

  openProfile() {
    this.profileClicked.emit();
  }

  showDevicesMenu = true;
  devices = [
    { id: 1, name: 'Устройство 1' },
    { id: 2, name: 'Устройство 2' },
    // Добавьте устройства из сервиса или заглушек
  ];

  addDevice() {
    // Логика для добавления нового устройства
  }

  openAllDevices() {
    // Логика для открытия списка всех устройств
  }

  openDevice(deviceId: number) {
    // Логика для открытия информации об устройстве
  }

  logout() {
    // Логика для выхода из системы
  }
}
