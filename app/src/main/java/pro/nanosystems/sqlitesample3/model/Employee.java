package pro.nanosystems.sqlitesample3.model;

import java.io.Serializable;

public class Employee  implements Serializable{
    private Integer _id;
    private String code;
    private String name;
    private Integer job;

    public Employee() {
    }

    public Employee(Integer _id, String code, String name, Integer job) {
        this._id = _id;
        this.code = code;
        this.name = name;
        this.job = job;
    }

    public Employee(String code, String name, Integer job) {
        this.code = code;
        this.name = name;
        this.job = job;
    }

    public Integer get_id() {
        return _id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getJob() {
        return job;
    }
}
