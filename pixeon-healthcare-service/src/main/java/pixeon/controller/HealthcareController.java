package pixeon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pixeon.exception.ErrorMessage;
import pixeon.model.Healthcare;
import pixeon.service.HealthcareService;

@RestController
@RequestMapping(value = "/api/healthcares", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthcareController {

    @Autowired
    private HealthcareService healthcareService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Healthcare> save(@RequestBody Healthcare healthcare){
        return ResponseEntity.ok(healthcareService.save(healthcare));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Healthcare>> findAll(){
        return ResponseEntity.ok().body(healthcareService.findAll());
    }

    @RequestMapping(value = "/{id}/charge", method = RequestMethod.POST)
    public ResponseEntity charge(@PathVariable("id") String id) {

        Boolean charged = healthcareService.charge(id);
        if (charged==false) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage("Insufficient pixon coin"));
        }




        return ResponseEntity.ok().build();



    }

}
