package com.moises.javatest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//org.mockitod

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.moises.javatest.models.DepartmentEntity;
import com.moises.javatest.usecases.CreateDepartmentUseCase;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingDepartmentCRUDTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CreateDepartmentUseCase createDepartment;

	@Test
	public void assertListDepartmentsIsOk() throws Exception {
		this.mockMvc.perform(get("/api/departments")).andExpect(status().isOk());
	}

	@Test
	public void assertCreateDepartmentIsWorking() throws Exception {
		DepartmentEntity entity = getDepartment();
		when(this.createDepartment.executar(any(DepartmentEntity.class))).thenReturn(entity);
		this.mockMvc
				.perform(post("/api/departments").contentType(MediaType.APPLICATION_JSON)
						.content("{\"code\": \"DPT00001\",\"name\": \"Department Name\",\"location\": \"Location name\",\"city\": \"City name\"}"))
				.andExpect(status().isCreated());
	}
	
	private DepartmentEntity getDepartment() {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setId(1l);
		entity.setCity("City 1");
		entity.setCode("DPT00001");
		entity.setName("Department Name");
		entity.setLocation("Some location");
		entity.setCity("Some city");
		return entity;
	}

}
