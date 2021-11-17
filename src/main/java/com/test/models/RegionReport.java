package com.test.models;

import javax.persistence.*;

@Entity
@Table(name = "RegionReport")
public class RegionReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Region;
    private String Country;
    private Integer OrderCount;
    private Double AverageUnitsSold;
    private Double AverageUnitPrice;
    private Double AverageUnitCost;
    private Double TotalRevenue;
    private Double TotalCost;
    private Double TotalProfit;

    public RegionReport(String region, String country, Integer orderCount, Double averageUnitsSold,
                        Double averageUnitPrice, Double averageUnitCost, Double totalRevenue,
                        Double totalCost, Double totalProfit) {
        Region = region;
        Country = country;
        OrderCount = orderCount;
        AverageUnitsSold = averageUnitsSold;
        AverageUnitPrice = averageUnitPrice;
        AverageUnitCost = averageUnitCost;
        TotalRevenue = totalRevenue;
        TotalCost = totalCost;
        TotalProfit = totalProfit;
    }

    public RegionReport() {}

    public String getRegion() {
        return Region;
    }

    public Integer getId() {
        return Id;
    }

    public String getCountry() {
        return Country;
    }

    public Integer getOrderCount() {
        return OrderCount;
    }

    public Double getAverageUnitsSold() {
        return AverageUnitsSold;
    }

    public Double getAverageUnitPrice() {
        return AverageUnitPrice;
    }

    public Double getAverageUnitCost() {
        return AverageUnitCost;
    }

    public Double getTotalRevenue() {
        return TotalRevenue;
    }

    public Double getTotalCost() {
        return TotalCost;
    }

    public Double getTotalProfit() {
        return TotalProfit;
    }

    @Override
    public String toString() {
        return this.Id + "," + this.Country + "," + this.OrderCount
                + "," + this.AverageUnitsSold + "," + this.AverageUnitPrice
                + "," + this.AverageUnitCost + "," + this.TotalRevenue
                + "," + this.TotalCost + "," + this.TotalProfit;
    }
}