package pixeon.model;

import javax.validation.constraints.NotNull;

/**
 * Created by gian on 29/01/20.
 */
public class Physician {

    @NotNull
    private String name;

    @NotNull
    private Integer crm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }
}
