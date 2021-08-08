package com.goit.petStoreProject.model.Data;

import com.goit.petStoreProject.view.View;

public class Order {

    long id;
    long petId;
    int quantity;
    String shipDate;
    String status;
    boolean complete;

    public Order(long id, long petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public Order() {
    }

    public static Order create(View view) {
        Order order = new Order();
        view.write("input integer id for new order");
        long id = Long.parseLong(view.read());
        view.write("input pet id");
        long petId = Long.parseLong(view.read());
        view.write("input quantity");
        int quantity = Integer.parseInt(view.read());
        view.write("input ship date");
        String shipDate = view.read();
        view.write("input status");
        String status = view.read();
        view.write("is order complete? (true/false)");
        boolean isComplite = Boolean.parseBoolean(view.read());
        order.setId(id);
        order.setPetId(petId);
        order.setQuantity(quantity);
        order.setShipDate(shipDate);
        order.setStatus(status);
        order.setComplete(isComplite);
        return order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "{\n\t" +
                "id=" + id +
                ",\n\t petId=" + petId +
                ",\t quantity=" + quantity +
                ",\n\t shipDate='" + shipDate + '\'' +
                ",\n\t status='" + status + '\'' +
                ",\t complete=" + complete +
                "\n}";
    }
}
