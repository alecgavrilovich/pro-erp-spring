package com.alecgavrilovich.procurement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alecgavrilovich.procurement.domain.Dobavljac;

public interface IDobavljacRepo extends CrudRepository<Dobavljac, Integer>{

}
