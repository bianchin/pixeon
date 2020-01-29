package pixeon.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by gian on 29/01/20.
 */
public class Patient {

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    @Size(max = 1, message = "Gender must be M, F or I")
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
