class ParkingSystem {
    // Index 1 corresponds to big, 2 to medium, and 3 to small
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        this.count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // If there is an available slot, park the car and decrement the count
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
