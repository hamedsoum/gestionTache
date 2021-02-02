import { Component, OnInit } from '@angular/core';
import { Graph } from '../model/graph';
import { TachesService } from '../services/taches.service';
import {FormControl, FormGroup} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { ChartType } from 'chart.js';



@Component({
  selector: 'app-graphe',
  templateUrl: './graphe.component.html',
  styleUrls: ['./graphe.component.css']
})
export class GrapheComponent implements OnInit {
  selectedValue!: string;

 
  selectGaphValue!: string;
  graphs: Graph[] = [];
  projets: Graph[] = [];
  

  states = [
    { projet: 'ACR'},
    { projet: 'MIs'},
    {projet: 'ADV'},
    {projet: 'BFD'}
  ];

  form = new FormGroup({
    state: new FormControl(this.states[0]),
  });
 
  grapheChoise = '';

  constructor(private tacheService : TachesService) { 
    
  }
  ngOnInit(): void {
    this.retrieveGraph();
    
  }
 // Doughnut
 public doughnutChartLabels:string[] = ['tache 1', 'tache 2', 'tache 3', 'tache 4'];
 public demodoughnutChartData:number[] = [];
 public doughnutChartType : ChartType = 'doughnut';
 
 // events
 public chartClicked(e:any):void {
   console.log(e);
 }


 public chartHovered(e:any):void {
   console.log(e);
  }

  retrieveGraph(){
    this.tacheService.getAllGraph()
    .subscribe(
      (data: any) => {
      this.graphs = data;
      
    },
      (error: any) =>{
      console.log(error);
     }
    )
  }

  selectGaph(event : any){
    this.selectGaphValue = event.target.value;
    console.log(this.selectGaphValue);
  }

  searchGraphbyProjet(){
    
    console.log(this.selectedValue);
    
      this.tacheService.findGraphByProjet(this.selectedValue)
      .subscribe(
        data => {
          this.projets = data;
          console.log(this.projets);
        },
        error => {
          console.log(error);
        });
  }
}
    



