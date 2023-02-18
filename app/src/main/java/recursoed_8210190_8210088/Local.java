package recursoed_8210190_8210088;

public class Local {
    private int id;
    private double longitude;
    private double latitude;
    private double energy;

    public Local(int id, double longitude, double latitude, double energy) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.energy = energy;
    }

    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getEnergy() {
        return energy;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    
    
}
