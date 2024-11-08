import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  user = {
    username: 'user123',
    name: 'John Doe',
    password: '123456',
  };
  editingField: 'username' | 'name' | 'password' | null = null;
  formValue: string = '';

  editField(field: 'username' | 'name' | 'password') {
    this.editingField = field;
    this.formValue = this.user[field] || '';
  }

  getPlaceholder() {
    return this.editingField && this.user[this.editingField];
  }

  clearPlaceholder() {
    this.formValue = '';
  }

  saveChanges() {
    if (this.editingField) {
      if (this.editingField === 'password') {
        // Логика обновления пароля
      } else {
        this.user[this.editingField] = this.formValue;
      }
      this.editingField = null;
    }
  }

  closeEditForm() {
    this.editingField = null;
  }
}
