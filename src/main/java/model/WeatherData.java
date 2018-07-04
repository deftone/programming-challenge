package model;


/**
 * Created by deftone on 04.07.18.
 */

public class WeatherData {

    private int day;
    private int maxTemperature;
    private int minTemperature;

    public WeatherData(int day, int maxTemperature, int minTemperature){
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemperature(){
        return this.maxTemperature;
    }

    public int getMinTemperature(){
        return this.minTemperature;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    //    Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP
//    1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5

}
