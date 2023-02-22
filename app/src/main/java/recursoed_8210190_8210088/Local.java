package recursoed_8210190_8210088;

/**
 * Classe que representa um local
 * @author David Francisco (8210088)
 * @author Guilherme Silva (8210190)
 */
public class Local {
    private int id;
    private double longitude;
    private double latitude;
    private double energy;

    /**
     * Construtor da classe Local
     * @param id Identificador do local
     * @param longitude Longitude do local
     * @param latitude Latitude do local
     * @param energy  Energia do local
     */
    public Local(int id, double longitude, double latitude, double energy) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.energy = energy;
    }

    /**
    * Retorna o identificador do local
    * @return Identificador do local
    */
    public int getId() {
        return id;
    }

    /**
    * Retorna a longitude do local
    * @return Longitude do local
    */
    public double getLongitude() {
        return longitude;
    }

    /**
    * Retorna a latitude do local
    * @return Latitude do local
    */
    public double getLatitude() {
        return latitude;
    }

    /**
    * Retorna a energia do local
    * @return Energia do local
    */
    public double getEnergy() {
        return energy;
    }

    /**
    * Define a longitude do local
    * @param longitude nova longitude do local
    */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
    * Define a latitude do local
    * @param latitude nova latitude do local
    */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
    * Define a energia do local
    * @param energy nova energia do local
    */
    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
