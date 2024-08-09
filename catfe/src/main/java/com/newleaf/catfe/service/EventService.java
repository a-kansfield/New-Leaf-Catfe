package com.newleaf.catfe.service;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.CreateEventFormBean;
import com.newleaf.catfe.util.ConversionUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventService {

    @Autowired
    private ConversionUtil conversionUtil;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private CatDAO catDAO;
    @Getter
    private String dir = "../../../pub/assets/imgs/events/";

    public Event findOrCreateEvent(Integer id) {
        Event event = eventDAO.findById(id);
        if (event == null) {
            event = new Event();
        }
        return event;
    }

    public Event saveEvent(Event event, CreateEventFormBean form) {

        event.setTitle(form.getTitle());
        event.setStartDate(form.getStartDate());
        event.setEndDate(form.getEndDate());
        event.setDescription(form.getDescription());
        event.setCapacity(form.getCapacity());
        event.setImageURL(dir + form.getImageURL());
        Cat cat = catDAO.findById(form.getFeaturedCat());
        event.setCat(cat);
        event.setFeaturedCat(cat.getId());

        event.setServesAlcohol(
                conversionUtil.stringToBool(form.getServesAlcohol())
        );
        event = eventDAO.save(event);
        return event;

    }

    public CreateEventFormBean populateEventForm(Event event) {
        String url = conversionUtil.truncateURL(event.getImageURL(), dir);
        CreateEventFormBean form = new CreateEventFormBean();

        form.setId(event.getId());

        form.setTitle(event.getTitle());
        form.setStartDate(event.getStartDate());
        form.setEndDate(event.getEndDate());
        form.setDescription(event.getDescription());
        form.setCapacity(event.getCapacity());

        form.setFeaturedCat(event.getCat().getId());
        form.setServesAlcohol(conversionUtil.boolToString(event.isServesAlcohol()));

        form.setImageURL(url);

        return form;
    }
//    public Date convertDate(String date){
//        Date result = new Date();
//        String pattern = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        date = date + ":00";
//        log.debug("Date String: " + date);
//        try {
////            result = dateFormat.parse(date);
//            result = DateUtils.parseDate(date, new String[] {"yyyy-MM-dd HH:mm:ss"});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//        return result;
//    }


}
