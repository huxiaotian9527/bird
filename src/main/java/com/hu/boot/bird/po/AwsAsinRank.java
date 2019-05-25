package com.hu.boot.bird.po;

import java.io.Serializable;
import java.util.Date;

public class AwsAsinRank implements Serializable {
    private Long id;

    private String asin;

    private String rankName;

    private String rankScore;

    private Boolean type;

    private Date grabDay;

    private Byte grabHour;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public String getRankScore() {
        return rankScore;
    }

    public void setRankScore(String rankScore) {
        this.rankScore = rankScore == null ? null : rankScore.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Date getGrabDay() {
        return grabDay;
    }

    public void setGrabDay(Date grabDay) {
        this.grabDay = grabDay;
    }

    public Byte getGrabHour() {
        return grabHour;
    }

    public void setGrabHour(Byte grabHour) {
        this.grabHour = grabHour;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AwsAsinRank other = (AwsAsinRank) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAsin() == null ? other.getAsin() == null : this.getAsin().equals(other.getAsin()))
            && (this.getRankName() == null ? other.getRankName() == null : this.getRankName().equals(other.getRankName()))
            && (this.getRankScore() == null ? other.getRankScore() == null : this.getRankScore().equals(other.getRankScore()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getGrabDay() == null ? other.getGrabDay() == null : this.getGrabDay().equals(other.getGrabDay()))
            && (this.getGrabHour() == null ? other.getGrabHour() == null : this.getGrabHour().equals(other.getGrabHour()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAsin() == null) ? 0 : getAsin().hashCode());
        result = prime * result + ((getRankName() == null) ? 0 : getRankName().hashCode());
        result = prime * result + ((getRankScore() == null) ? 0 : getRankScore().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGrabDay() == null) ? 0 : getGrabDay().hashCode());
        result = prime * result + ((getGrabHour() == null) ? 0 : getGrabHour().hashCode());
        return result;
    }
}