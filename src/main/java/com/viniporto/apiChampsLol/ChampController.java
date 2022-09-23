package com.viniporto.apiChampsLol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ChampController {
    
    @Autowired
    private ChampRepository repository;

    @GetMapping("/champs")
    public List<Champ> getChamps(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) List<String> filters,
                                 @RequestParam(required = false) Integer sortingMethod){ 
        List<Champ> champsList = repository.findAll();
        if(sortingMethod == null){
            sortingMethod = 2;
        }
        if(name == null && filters == null){
            return sortChampsByMethod(champsList, sortingMethod);
        }else if(name != null && filters == null){
            return searchChampsByName(sortChampsByMethod(champsList, sortingMethod), name);
        }else if(name == null && filters != null){
            return searchChampsByFilters(filters, sortChampsByMethod(champsList, sortingMethod));
        }
        return sortChampsByMethod(searchChampsByFilters(filters, searchChampsByName(champsList, name)), sortingMethod);
    }

    //data de lançamento ⇩ -> 1
    //data de lancamento ⇧ -> 2
    //rp ⇩ -> 3
    //rp ⇧ -> 4
    //ea ⇩ -> 5
    //ea ⇧ -> 6
    //alfabetico ⇩ -> 7
    //alfabetico ⇧ -> 8

    public List<Champ> searchChampsByFilters(List<String> filters, List<Champ> champsList){
        List<Champ> newList = new ArrayList<>();
        for (Champ champ : champsList) {
            if(hasRole(champ.getRole(), filters)){
                newList.add(champ);
            }
        }
        return newList;
    }

    public boolean hasRole(String role[], List<String> filters){
        int counter = 0; 
        for(int i = 0; i < role.length; i++){
            for(int j = 0; j < filters.size(); j++){
                if(role[i].toLowerCase().equals(filters.get(j).toLowerCase())){
                    counter += 1; 
                }
            }
        }
        return counter == filters.size(); //tem que ter todos os filtros passado por parâmetro, por
                                           //isso pesquisa se o número de filtros encontrados foi igual
                                           //ao número de filtros passados por parâmetros
    }

    public List<Champ> sortChampsByMethod(List<Champ> champsList, int sortingMethod){
        if(sortingMethod < 1 || sortingMethod > 8){
            return champsList; //método inválido, não lança erro, apenas retorna a lista para simplificar
        }
        //método de número impar é crescente
        if(sortingMethod % 2 == 0){
            sortChamps(champsList, sortingMethod, 1);
        }else{
            sortChamps(champsList, sortingMethod, 0);
        }
        return champsList;
    }

    public void sortChamps(List<Champ> champsList, int sortingMethod, int decrescent){ 
        Collections.sort(champsList, new Comparator<Champ>() {
            @Override
            public int compare(Champ champ1, Champ champ2) {
                switch(sortingMethod){
                    case 1:
                    case 2:
                        return compareByReleaseDate(champ1, champ2, decrescent);
                    case 3:
                    case 4:
                        return compareByRP(champ1, champ2, decrescent);
                    case 5:
                    case 6:
                        return compareByEA(champ1, champ2, decrescent);
                    case 7:
                    case 8:
                        return compareByAlphabeticalOrder(champ1, champ2, decrescent);
                }
                return decrescent;
            }
        });
    }

    public int compareByAlphabeticalOrder(Champ champ1, Champ champ2, int decrescent){
        if(decrescent == 0){
            return champ1.getName().compareToIgnoreCase(champ2.getName());
        }
        return (champ1.getName().compareToIgnoreCase(champ2.getName())) * -1;
    }
    
    public int compareByReleaseDate(Champ champ1, Champ champ2, int decrescent){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        try{
            if(decrescent == 0){
                return format.parse(champ1.getReleaseDate()).compareTo(format.parse(champ2.getReleaseDate()));
            }
            return (format.parse(champ1.getReleaseDate()).compareTo(format.parse(champ2.getReleaseDate()))) * -1;
        }catch (Exception e){
            return 0;
        }
    }

    public int compareByEA(Champ champ1, Champ champ2, int decrescent){
        if(decrescent == 0){
            return champ1.getEaPrice() - champ2.getEaPrice();
        }
        return champ2.getEaPrice() - champ1.getEaPrice();
    }

    public int compareByRP(Champ champ1, Champ champ2, int decrescent){
        if(decrescent == 0){
            return champ1.getRpPrice() - champ2.getRpPrice();
        }
        return champ2.getRpPrice() - champ1.getRpPrice();
    }

    public List<Champ> searchChampsByName(List<Champ> champsList, String name){
        List<Champ> newChampsList = new ArrayList<>();
        for (Champ champ : champsList) {
            if(champ.getName().toLowerCase().contains(name.toLowerCase())){
                newChampsList.add(champ);
            }
        }
        return newChampsList;
    }

    @PostMapping("/champs")
    public Champ addChamp(@RequestBody Champ champ){
        return repository.save(champ);
    }

    @DeleteMapping("/champs")
    public List<Champ> deleteChamp(@RequestBody Champ champ){
        repository.deleteById(champ.getId());
        return repository.findAll();
    }

    @PutMapping("/champs")
    public Champ changeChamp(@RequestBody Champ champ){
        return repository.save(champ);
    }
}
