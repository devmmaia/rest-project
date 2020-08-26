package com.moises.javatest.usecases;

import com.moises.javatest.models.DepartmentEntity;

public interface UpdateDepartmentUseCase {
	public DepartmentEntity executar(DepartmentEntity department);
}
