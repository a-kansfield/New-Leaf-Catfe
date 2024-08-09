package com.newleaf.catfe;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.CreateEventFormBean;
import com.newleaf.catfe.service.CatService;
import com.newleaf.catfe.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CatfeApplicationTests {

	@Autowired
	private CatDAO catDAO;

	@Autowired
	private CatService catService;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private EventService eventService;


//	@Test
//	void contextLoads() {
//	}


	@ParameterizedTest		//DAO Test 1
	@CsvSource({"1,Tink", "2,Tonks", "3,Hank","4,Marzipan"})
	public void findCatById(int id, String name){
		Cat cat = catDAO.findById(id);

		assert cat.getName().equals(name);
	}


	@Test					//DAO Test 2
	public void findEventByCat(){
		Cat cat = catDAO.findById(2);

		List<Event> events = eventDAO.findByCat(cat);

		// This will break as soon as the selected cat has more than one event tied to it.
		assert events.size() == 1;
		assert events.get(0).getId() == 3;
	}

	@Test					//DAO Test 3
	public void getEventDetails(){
		Map<String,Object> eventDetails = eventDAO.getEventDetails(1);

		// Check that we are still getting cat information from event details query.
		assert eventDetails.containsKey("name");
		assert eventDetails.containsValue("Tink");
	}

	@Test
	public void createEvent() throws ParseException {
		Event event = new Event();
		CreateEventFormBean form = new CreateEventFormBean();
		Date date = new SimpleDateFormat( "yyyy-MM-dd hh:mm" ).parse("2025-05-20 12:00");
		form.setTitle("Test");
		form.setDescription("abc");
		form.setStartDate(date);
		form.setEndDate(date);
		form.setFeaturedCat(4);
		event = eventService.saveEvent(event, form);

		List<Event> events = eventDAO.findByTitle("Test");
		assert !events.isEmpty();

		events.stream().forEach(e -> {
			eventDAO.delete(e);
		});
	}
}
