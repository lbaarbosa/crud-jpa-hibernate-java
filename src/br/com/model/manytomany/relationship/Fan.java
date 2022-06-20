package br.com.model.manytomany.relationship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "fans")
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "fanList", cascade = CascadeType.PERSIST)
    private List<Team> teamList = new ArrayList<>();

    public Fan() {
        super();
    }

    public Fan(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
