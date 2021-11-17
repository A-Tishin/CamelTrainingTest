package com.test.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private Integer Id;
    private String Region;
    private String Country;
    private String ItemType;
    private String SalesChannel;
    private String OrderPriority;
    private String OrderDate;
    private Long OrderID;
    private String ShipDate;
    private Integer UnitsSold;
    private Double UnitPrice;
    private Double UnitCost;
    private Double TotalRevenue;
    private Double TotalCost;
    private Double TotalProfit;

    public Data(String region, String country, String itemType, String salesChannel,
                String orderPriority, String orderDate, Long orderID, String shipDate,
                Integer unitsSold, Double unitPrice, Double unitCost, Double totalRevenue,
                Double totalCost, Double totalProfit) {
        Region = region;
        Country = country;
        ItemType = itemType;
        SalesChannel = salesChannel;
        OrderPriority = orderPriority;
        OrderDate = orderDate;
        OrderID = orderID;
        ShipDate = shipDate;
        UnitsSold = unitsSold;
        UnitPrice = unitPrice;
        UnitCost = unitCost;
        TotalRevenue = totalRevenue;
        TotalCost = totalCost;
        TotalProfit = totalProfit;
    }

    public Data() {
    }

    public Integer getId() {
        return Id;
    }

    public String getRegion() {
        return Region;
    }

    public String getCountry() {
        return Country;
    }

    public String getItemType() {
        return ItemType;
    }

    public String getSalesChannel() {
        return SalesChannel;
    }

    public String getOrderPriority() {
        return OrderPriority;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public Long getOrderID() {
        return OrderID;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public Integer getUnitsSold() {
        return UnitsSold;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public Double getUnitCost() {
        return UnitCost;
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
        return this.Id + "," + this.Region + "," + this.Country + "," + this.SalesChannel
                + "," + this.OrderPriority + "," + this.OrderDate
                + "," + this.OrderID + "," + this.ShipDate + "," + this.UnitsSold + ","
                + this.UnitPrice + "," + this.UnitCost + "," + this.TotalRevenue
                + "," + this.TotalCost + "," + this.TotalProfit;
    }

    public List<String> toList() {
        List<String> list = new ArrayList<>();
        list.add(this.Id.toString());
        list.add(this.Region);
        list.add(this.Country);
        list.add(this.ItemType);
        list.add(this.SalesChannel);
        list.add(this.OrderPriority);
        list.add(this.OrderDate);
        list.add(this.OrderID.toString());
        list.add(this.ShipDate);
        list.add(this.UnitsSold.toString());
        list.add(this.UnitPrice.toString());
        list.add(this.UnitPrice.toString());
        list.add(this.UnitCost.toString());
        list.add(this.TotalRevenue.toString());
        list.add(this.TotalCost.toString());
        list.add(this.TotalProfit.toString());
        return list;
    }
}