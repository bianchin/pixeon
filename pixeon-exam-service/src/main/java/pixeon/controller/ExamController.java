package pixeon.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pixeon.model.Exam;
import pixeon.service.ExamService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/healthcares/{healthcare}/exams", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> save(@PathVariable("healthcare") String healthcare, @RequestBody @Validated Exam exam) {
        exam.setHealthcareInstitutionId(healthcare);
        return ResponseEntity.ok(examService.save(exam).getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity save(
            @PathVariable("healthcare") String healthcare,
            @PathVariable("id") String id,
            @RequestBody @Validated Exam exam) {
        examService.update(exam);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PostAuthorize("returnObject.body.healthcareInstitutionId == #healthcare")
    public ResponseEntity<Exam> retrieve(@PathVariable("healthcare") String healthcare, @PathVariable("id") String id){
        return ResponseEntity.ok(examService.retrieve(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Exam>> findAll(@PathVariable("healthcare") String healthcare){
        return ResponseEntity
                .ok().body(examService.findByHealthcareInstitutionId(healthcare));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("healthcare") String healthcare, @PathVariable("id") String id){
        examService.delete(id);
        return ResponseEntity.ok().build();
    }
}
