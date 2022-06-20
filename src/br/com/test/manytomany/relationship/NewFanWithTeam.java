package br.com.test.manytomany.relationship;

import br.com.infrastructure.DataAccessObject;
import br.com.model.manytomany.relationship.Fan;
import br.com.model.manytomany.relationship.Team;

public class NewFanWithTeam {
    public static void main(String[] args) {

        Team team1 = new Team("Los Angeles RAMS");
        Team team2 = new Team("Cincinnati BENGALS");

        Fan fan1 = new Fan("Lucas");
        Fan fan2 = new Fan("Ivan");

//        //deprecated way of inserting
//        team1.getFanList().add(fan1);
//        fan1.getTeamList().add(team1);
//
//        team1.getFanList().add(fan2);
//        fan2.getTeamList().add(team1);
//
//        team2.getFanList().add(fan1);
//        fan1.getTeamList().add(team2);
//
//        team2.getFanList().add(fan2);
//        fan2.getTeamList().add(team2);
//
//        DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();
//        dataAccessObject.beginTransaction()
//                .insert(fan1)
//                .insert(fan2)
//                .insert(team1)
//                .insert(team2)
//                .commitTransaction()
//                .close();

        team1.insertFan(fan1);
        team1.insertFan(fan2);
        team2.insertFan(fan1);

        DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();
        dataAccessObject.atomicInsert(team1);
    }
}
