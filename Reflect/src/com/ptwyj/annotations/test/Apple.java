package com.ptwyj.annotations.test;

import com.ptwyj.annotations.SerializedName;

/**
 * Created by Administrator on 2016-03-11.
 */
public class Apple {

    @SerializedName("ID")
    private Integer id = 1;

    @SerializedName("NAME")
    private String name = "yijun";

    @SerializedName("WEIGHT")
    private double weight;

    @SerializedName("WAY_OUT")
    private String wayOut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWayOut() {
        return wayOut;
    }

    public void setWayOut(String wayOut) {
        this.wayOut = wayOut;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", wayOut='" + wayOut + '\'' +
                '}';
    }


}
