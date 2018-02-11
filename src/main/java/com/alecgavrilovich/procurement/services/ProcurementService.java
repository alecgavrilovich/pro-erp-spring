package com.alecgavrilovich.procurement.services;

import java.util.List;

public interface ProcurementService<A, B> {

	List<A> listAll();

	A getById(Integer id);

	A saveOrUpdate(A targetObject);

	void delete(Integer id);

	A saveOrUpdateObjectForm(B targetObjectForm);
}
