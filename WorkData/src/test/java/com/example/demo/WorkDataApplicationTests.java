package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Domain.WorkData;
import com.example.demo.Mapper.WorkDataMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkDataApplicationTests {

	@Autowired
	WorkDataMapper workDataMapper;

	@Autowired
	TestRestTemplate restTemplate;
	WorkData workData1;
	WorkData workData2;

	@Before
	public void setup() {
		workDataMapper.deleteAll();
		workData1 = new WorkData();
		workData2 = new WorkData();

		workData1.setData_id("18");
		workData1.setData_name("NW01");
		workData1.setCalc_year(10);
		workData1.setCalc_month(1);
		workData1.setCalc_day(30);

		workData2.setData_id("18");
		workData2.setData_name("NW01");
		workData2.setCalc_year(10);
		workData2.setCalc_month(1);
		workData2.setCalc_day(30);
		workDataMapper.create(workData1);
		workDataMapper.create(workData2);
	}

	@Test
	public void testGetWorkData() throws Exception {
		ResponseEntity<List<WorkData>> response = restTemplate.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<WorkData>>() {
				});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
