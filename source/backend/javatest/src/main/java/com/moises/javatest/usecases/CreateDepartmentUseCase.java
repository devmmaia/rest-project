package com.moises.javatest.usecases;

import com.moises.javatest.models.DepartmentEntity;

public interface CreateDepartmentUseCase {
	public DepartmentEntity executar(DepartmentEntity department);
}
