package br.com.model.manytomany.relationship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "fanList_teams",
            joinColumns = @JoinColumn(
                    name = "team_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fan_id",
                    referencedColumnName = "id"
            )

    )
    private List<Fan> fanList;

    public Team() {
        super();
    }

    public Team(String name) {
        super();
        this.name = name;
    }

    public Long getIg() {
        return id;
    }

    public void setIg(Long ig) {
        this.id = ig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fan> getFanList() {
        if(fanList == null) {
            fanList = new ArrayList<>();
        }
        return fanList;
    }

    public void setFanList(List<Fan> fanList) {
        this.fanList = fanList;
    }

    public void insertFan(Fan fan) {
        if (fan != null && !getFanList().contains(fan)) {
            getFanList().add(fan);
            if(!fan.getTeamList().contains(this)) {
                fan.getTeamList().add(this);
            }
        }
    }
}
