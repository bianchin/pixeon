package pixeon.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String healthcareInstitutionId;

    private String patientName;

    private String patientAge;

    private String patientGender;

    private String physicianName;

    private String physicianCRM;

    private String procedureName;

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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public String getPhysicianCRM() {
        return physicianCRM;
    }

    public void setPhysicianCRM(String physicianCRM) {
        this.physicianCRM = physicianCRM;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}
