import { APP_INITIALIZER, NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';

import { AppModule } from './app.module';
import { AppComponent } from './app.component';

/*function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8085',
        realm: 'maram-realm',
        clientId: 'env-app'
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: true
        /* onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
        window.location.origin + '/assets/silent-check-sso.html' */
    /*  }
    });
}*/


@NgModule({
  imports: [
    AppModule,
    ServerModule,
    
  ],
  /*providers: [
    {
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService]
    }
    ],*/
  bootstrap: [AppComponent],
})
export class AppServerModule {}
