package com.code;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    //primary key
    @Id
//auto_increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playerName;
    private Long score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Player [id=" + id + ", playerName=" + playerName + ", score=" + score +"]";
    }

}

