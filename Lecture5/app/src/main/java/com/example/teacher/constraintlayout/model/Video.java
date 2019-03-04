package com.example.teacher.constraintlayout.model;

public class Video {

    private String name;
    private int msDuration;
    private int volume;
    private String format;

    public Video(String name, int msDuration, int volume, String format) {
        this.name = name;
        this.msDuration = msDuration;
        this.volume = volume;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMsDuration() {
        return msDuration;
    }

    public void setMsDuration(int msDuration) {
        this.msDuration = msDuration;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
