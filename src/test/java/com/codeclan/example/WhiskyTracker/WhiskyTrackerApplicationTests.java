package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.getWhiskiesByYear(1995);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.getDistilleriesByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetWhiskiesFromDistilleryWithAge(){
		List<Whisky> found = whiskyRepository.findWhiskiesFromDistilleryWithAge(1L, 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void canGetWhiskiesByRegion(){
		List<Whisky> found = whiskyRepository.findWhiskiesByRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void findDistillariesByWhiskyAge(){
		List<Distillery> found = distilleryRepository.findDistillariesByWhiskyAge(12);
		assertEquals(2, found.size());
	}

}
