package pixeon.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
public class Exam {

    @Id
    private String id;

    private String healthcareInstitutionId;

    @NotNull (message = "You must place a valid Patient")
    @Valid
    private Patient patient;

    @NotNull (message = "You must place a valid Physician")
    @Valid
    private Physician physician;

    @NotNull
    private String procedureName;

    private Boolean retrieved = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHealthcareInstitutionId() {
        return healthcareInstitutionId;
    }

    public void setHealthcareInstitutionId(String healthcareInstitutionId) {
        this.healthcareInstitutionId = healthcareInstitutionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Boolean getRetrieved() {
        return retrieved;
    }

    public void setRetrieved(Boolean retrieved) {
        this.retrieved = retrieved;
    }
}
