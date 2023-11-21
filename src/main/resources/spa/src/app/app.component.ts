import { Component } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';

  public isLoggedIn = false;

  constructor(private readonly keycloak: KeycloakService) { }

  public async ngOnInit() {
    this.isLoggedIn = await this.keycloak.isLoggedIn();
  }

  public login() {
    this.keycloak.login();
  }

  public logout() {
    let redirectURI: string = "http://localhost:4200/dashboard";
    this.keycloak.logout(redirectURI);
  }
}
