import { Injectable } from '@angular/core';
import { HttpClient, HttpClientJsonpModule, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Techno } from '../model/techno';
import { Tache } from '../model/tache';
import { Graph } from '../model/graph';



const tache_URL = "http://localhost:8080/api/taches";

const techs_URL = "http://localhost:8080/api/techs";

const graph_URL = "http://localhost:8080/api/Graph";
@Injectable({
  providedIn: 'root'
})
export class TachesService  {

  constructor(private http : HttpClient) { }
/*tache*/
  getAllTaches(): Observable<Tache[]> {
    return this.http.get<Tache[]>(tache_URL);
  }

  findByClient(client: any): Observable<Tache[]> {
    return this.http.get<Tache[]>(`${tache_URL}?client=${client}`);
  }

  /*techno */

  getAllTechs(): Observable<any> {
    return this.http.get(techs_URL);
  }

  createTech(data: Techno): Observable<Techno> {
    return this.http.post<Techno>(techs_URL, data);
  }

  updateTech(id : string, data : Techno): Observable<any> {
    return this.http.put(`${techs_URL}/${id}`, data);
  }

  deleteTech(tech : Techno | string): Observable<Techno> {
    const id = typeof tech === "string" ? tech : tech.id;

    return this.http.delete<Techno>(`${techs_URL}/${id}`);
  }

  /*graph */
  getAllGraph(): Observable<any> {
    return this.http.get(graph_URL);
  }  
  
  findGraphByProjet(projet: any): Observable<Graph[]> {
    return this.http.get<Graph[]>(`${graph_URL}?projet=${projet}`);
  }
}
