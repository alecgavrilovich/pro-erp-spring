package com.alecgavrilovich.procurement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.StavkaZZPId;

public interface IStavkaZZPRepo extends CrudRepository<StavkaZZP, StavkaZZPId> {

}
