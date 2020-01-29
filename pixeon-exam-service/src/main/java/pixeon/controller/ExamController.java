package pixeon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pixeon.model.Exam;
import pixeon.service.ExamService;

@RestController
@RequestMapping(value = "/api/{healthcare}/exams", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> save(@PathVariable("healthcare") String healthcare, @RequestBody @Validated Exam exam) {
        exam.setHealthcareInstitutionId(healthcare);
        return ResponseEntity.ok(examService.save(exam).getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //@PostAuthorize("returnObject.body.healthcareInstitutionId == #healthcare")
    public ResponseEntity<Exam> findById(@PathVariable("healthcare") String healthcare, @PathVariable("id") String id){
        return ResponseEntity.ok(examService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    //@PostAuthorize("returnObject.body.healthcareInstitutionId == #healthcare")
    public ResponseEntity<Iterable<Exam>> findAll(@PathVariable("healthcare") String healthcare){
        return ResponseEntity.ok().body(examService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("healthcare") String healthcare, @PathVariable("id") String id){
        examService.delete(id);
        return ResponseEntity.ok().build();
    }
}
