import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { TachesService } from 'src/app/services/taches.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { Tache } from 'src/app/model/tache';
import { FormControl } from '@angular/forms';
import { Techno } from 'src/app/model/techno';


@Component({
  selector: 'app-taches-list',
  templateUrl: './taches-list.component.html',
  styleUrls: ['./taches-list.component.css']
})
export class TachesListComponent implements OnInit {
  
  client = '';
  technos!: Techno[];
 technologie  = {
   id : '',
  technologie : new FormControl('')
 }
  submitted = false;
   
  
  currentTutorial = null;
  currentIndex = -1;
  taches : any;
  techs : any;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort)
  sort!: MatSort;

  constructor(private tacheService : TachesService) { 
    
  }
  
  
  ngOnInit(): void {
    this.retrieveTaches();
    this.retrieveTechs();
  }

  retrieveTaches(){
    this.tacheService.getAllTaches()
    .subscribe(
      data => {
      this.taches = data;
      console.log(this.taches);
    },
    error =>{
      console.log(error);
     }
    )
  }

  searchClient(): void {
    this.tacheService.findByClient(this.client)
      .subscribe(
        data => {
          this.taches = data;
          
        },
        error => {
          console.log(error);
        });
  }
  

  retrieveTechs(){
    this.tacheService.getAllTechs()
    .subscribe(
      data => {
      this.techs = data;
    },
    error =>{
      console.log(error);
    })
  }
  addNewTech(){
    const data = {
      id : this.technologie.id = '',
      technologie : this.technologie.technologie.value
    };
    console.log(data);
    this.tacheService.createTech(data).
    subscribe(res =>{
      
      this.submitted = true;
      this.technologie  = {
        id : '',
       technologie : new FormControl('')
      }
        this.retrieveTechs();
        
    },
    error =>{
      console.log(error);
    }
    )
    };

    setActiveTutorial(tutorial : any, index : any): void {
      this.currentTutorial = tutorial;
      this.currentIndex = index;
    }

    deleteTutorial(tech : Techno): void {
      this.tacheService.deleteTech(tech).subscribe();
      this.retrieveTechs();

      /*this.tacheService.deleteTech()
        .subscribe(
          response => {
            console.log(response);
            this.retrieveTechs();
          },
          error => {
            console.log(error);
          });*/
    }
    

    /**/
  }

  
