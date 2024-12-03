import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EvenementComponent } from './evenement/evenement.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS,  withInterceptorsFromDi } from '@angular/common/http';
import { EvenementService } from './services/evenement.service';


import { provideHttpClient, withFetch } from '@angular/common/http';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';

/*
function initializeKeycloak(keycloak: KeycloakService) {
  return () => {
    if (typeof window !== 'undefined') {
      return keycloak.init({
        config: {
          url: 'http://localhost:8085',
          realm: 'maram-realm',
          clientId: 'env-app',
        },
        initOptions: {
          onLoad: 'login-required',
          checkLoginIframe: true,
          redirectUri: window.location.origin + '/evenements',  
          silentCheckSsoRedirectUri: window.location.origin + '/assets/silent-check-sso.html', 
        },
        
      });
    } else {
      return Promise.resolve();
    }
  };
}*/

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8085',
        realm: 'maram-realm',
        clientId: 'env-app',
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: false
      }
    });
}


@NgModule({ declarations: [
        AppComponent,
        EvenementComponent,
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule,
        FormsModule,
        KeycloakAngularModule], providers: [
        provideClientHydration(),
        provideHttpClient(withFetch()),
        EvenementService,
        {
            provide: APP_INITIALIZER,
            useFactory: initializeKeycloak,
            multi: true,
            deps: [KeycloakService]
        },
        provideHttpClient(withInterceptorsFromDi())
    ] })
export class AppModule { }
