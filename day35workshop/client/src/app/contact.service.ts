
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Contact } from "./models";
import { firstValueFrom } from "rxjs";

@Injectable()
export class ContactService{

    constructor(private http: HttpClient) {}

    saveContact(contact: Contact): Promise<Contact> {

        // Create the form
        const payload = new HttpParams()
            .set("name", contact.name)
            .set("email", contact.email)
            .set("phone", contact.phone)

        // Set the headers
        const headers = new HttpHeaders()
            .set("Content-Type", "application/x-www-form-urlencoded")
            .set("Accept", "application/json")

        return firstValueFrom(
            this.http.post<Contact>('http://localhost:8080/contact', payload.toString(), {headers})
        )
    }
}