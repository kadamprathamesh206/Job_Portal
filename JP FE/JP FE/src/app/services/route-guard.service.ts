import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    if (localStorage.getItem("user")) {
      const user = JSON.parse(localStorage.getItem("user") || "");
      console.log("user", user);
      if (user.type == "1") {
        return true;
      } else if (user.type == "2") {
        this.router.navigate(['/home/appointments']);
        return false;
      } else if (user.type == "3") {
        this.router.navigate(['/home/book-appointment']);
        return false;
      }
    }
    this.router.navigate(['/login']);
    return false;
  }

}
