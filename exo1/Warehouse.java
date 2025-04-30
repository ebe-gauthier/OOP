package exo1;

public class Warehouse {
    private String warehouseId;
    private String location;
    private int capacity;
    private String managerName;

    public Warehouse(String id, String location, int capacity, String manager) {
        this.warehouseId = id;
        this.location = location;
        this.capacity = capacity;
        this.managerName = manager;
    }

    public void displayWarehouse() {
        System.out.printf("Warehouse: %s | Location: %s | Capacity: %d | Manager: %s\n",
                warehouseId, location, capacity, managerName);
    }
}

