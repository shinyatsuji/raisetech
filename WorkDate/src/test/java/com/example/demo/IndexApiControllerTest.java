package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Domain.WorkDateType;
import com.example.demo.Mapper.WorkDateMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexApiControllerTest {

	@Autowired
	WorkDateMapper workDateMapper;

	@Autowired
	TestRestTemplate restTemplate;
	WorkDateType workDateType1;
	WorkDateType workDateType2;

	@Before
	public void setup() {
//		workDateMapper.deleteAll();
		workDateType1 = new WorkDateType();
		workDateType2 = new WorkDateType();

		workDateType1.setWorkDateId("NW01");
		workDateType1.setWorkDateName("大分前");
		workDateType1.setInputAddOrSubYear(10);
		workDateType1.setInputAddOrSubMonth(1);
		workDateType1.setInputAddOrSubDay(30);

		workDateType2.setWorkDateId("NW02");
		workDateType2.setWorkDateName("かなり前");
		workDateType2.setInputAddOrSubYear(10);
		workDateType2.setInputAddOrSubMonth(1);
		workDateType2.setInputAddOrSubDay(30);
		workDateMapper.createWorkDateType(workDateType1);
		workDateMapper.createWorkDateType(workDateType2);
	}

	@Test
	public void testGetWorkDate() throws Exception {
		ResponseEntity<List<WorkDateType>> response = restTemplate.exchange("/index", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<WorkDateType>>() {
				});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		WorkDateType wd1 = response.getBody().get(0);
		assertThat(wd1.getWorkDateId()).isEqualTo(workDateType1.getWorkDateId());

	}
}
