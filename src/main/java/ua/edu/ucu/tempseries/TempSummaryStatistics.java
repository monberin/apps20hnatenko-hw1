package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis temperatureSeriesAnalysis) {
        this.avgTemp = temperatureSeriesAnalysis.average();
        this.devTemp = temperatureSeriesAnalysis.deviation();
        this.minTemp = temperatureSeriesAnalysis.min();
        this.maxTemp = temperatureSeriesAnalysis.max();
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }
}