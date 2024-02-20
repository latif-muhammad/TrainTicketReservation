package models;

public class Trains {
    private int trainId;
    private String trainType;
    private String from;
    private String to;
    private String time;
    private String fare;
    private int maxStandardOccupancy;
    private int maxLuxuryOccupancy;
    private int maxSuperLuxOccupancy;

    public Trains(int train_id,String trainType, String from,String to, String time, String fare,int maxStandardOccupancy,
                  int maxLuxuryOccupancy,int maxSuperLuxOccupancy){
        this.maxStandardOccupancy = maxStandardOccupancy;
        this.maxLuxuryOccupancy = maxLuxuryOccupancy;
        this.maxSuperLuxOccupancy = maxSuperLuxOccupancy;
        this.trainId = train_id;
        this.trainType=trainType;
        this.fare = fare;
        this.from = from;
        this.time = time;
        this.to = to;
    }

    public int getTrainId() {
        return trainId;
    }

    public String getTrainType() {
        return trainType;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTime() {
        return time;
    }

    public String getFare() {
        return fare;
    }

    public int getMaxStandardOccupancy() {
        return maxStandardOccupancy;
    }

    public int getMaxLuxuryOccupancy() {
        return maxLuxuryOccupancy;
    }

    public int getMaxSuperLuxOccupancy() {
        return maxSuperLuxOccupancy;
    }
}
