package com.example.mylife2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LifePojo {
    @PrimaryKey(autoGenerate = true)
    public int  count;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "rating")
    public int  rating;

    @ColumnInfo(name = "description")
    public String description;

    @Override
    public String toString() {
        return "LifePojo{" +
                "count=" + count +
                ", date='" + date + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
