package com.moises.javatest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moises.javatest.models.DepartmentEntity;

@Component
public class RepositoryFacadeImpl implements RepositoryFacade {

	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentEntity createDepartment(DepartmentEntity department) {
		return departmentRepository.save(department);

	}

	public Optional<DepartmentEntity> findDepartment(Long id) {
		
		return departmentRepository.findById(id);
	}

	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}

	public DepartmentEntity updateDepartment(DepartmentEntity department) {
		return departmentRepository.save(department);
	}
	public List<DepartmentEntity> listDepartments() {
		return departmentRepository.findAll();
	}

}
