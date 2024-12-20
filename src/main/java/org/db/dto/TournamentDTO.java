package org.db.dto;

public class TournamentDTO {
    private int id;
    private final String name;
    private final char region;
    private float victoryPoints;

    public TournamentDTO(String name, char region, float victoryPoints) {
        this.name = name;
        this.region = region;
        this.victoryPoints = victoryPoints;
    }

    public TournamentDTO(int id, String name, char region, float victoryPoints) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.victoryPoints = victoryPoints;
    }

    public TournamentDTO(String name, char region) {
        this.name = name;
        this.region = region;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public char getRegion() {
        return region;
    }

    public float getVictoryPoints() {
        return victoryPoints;
    }
}