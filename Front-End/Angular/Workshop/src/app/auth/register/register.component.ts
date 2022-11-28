import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { appEmailDomains } from 'src/app/shared/constants';
import { appEmailValidator, sameValueGroupValidator } from 'src/app/shared/validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  form = this.fb.group(
    {
      username: ['', [Validators.required]],
      email: ['', [Validators.required, appEmailValidator(appEmailDomains)]],
      ext: [''],
      tel: [''],
      pass: this.fb.group({
        password: [],
        rePassword: []
      }, {
        validators: [sameValueGroupValidator('password', 'rePassword')]
      })

    }
  )

  constructor(private fb: FormBuilder) { }

}
