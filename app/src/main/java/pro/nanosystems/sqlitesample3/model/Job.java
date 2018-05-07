package pro.nanosystems.sqlitesample3.model;

import java.io.Serializable;

public class Job implements Serializable {
    private Integer id;
    private String title;
    public Job() {
    }

    public Job(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Job(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
