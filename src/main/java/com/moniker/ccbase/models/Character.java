package com.moniker.ccbase.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Basics
    @NotBlank(message = "Character name is mandatory")
    private String name;
    @NotBlank(message = "Character race is mandatory")
    private String race;
    @NotBlank(message = "Character class is mandatory")
    private String char_class;
    @NotBlank(message = "Character background is mandatory")
    private String back_ground;
    @NotNull(message = "Character level is required")
    private int level;

    //Ability Scores
    @NotNull(message = "Character strength is required")
    private int strength;
    @NotNull(message = "Character dexterity is required")
    private int dexterity;
    @NotNull(message = "Character constitution is required")
    private int constitution;
    @NotNull(message = "Character intelligence is required")
    private int intelligence;
    @NotNull(message = "Character Wisdom is required")
    private int wisdom;
    @NotNull(message = "Character charisma is required")
    private int charisma;

    public Character(){}

    public Character(long id, String name, String race, String char_class,
                     String back_ground, int level, int strength, int dexterity,
                     int constitution, int intelligence, int wisdom, int charisma)
    {
        this.id = id;
        this.name = name;
        this.race = race;
        this.char_class = char_class;
        this.back_ground = back_ground;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String charClass) {
        this.char_class = charClass;
    }

    public String getBack_ground() {
        return back_ground;
    }

    public void setBack_ground(String backGround) {
        this.back_ground = backGround;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
