package com.viniporto.apiChampsLol;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChampRepository extends MongoRepository<Champ, String>{
    
}
