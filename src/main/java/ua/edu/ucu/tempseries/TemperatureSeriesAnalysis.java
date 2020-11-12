package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries = {};
    static final double absZero = -273.0;
    static final double delta = 0.00001;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSer) {
        absZeroCheck(temperatureSer);
        this.temperatureSeries = temperatureSer;
    }

    public double sum(double[] temperatureSeries) {
        double sum = 0;
        for (double temperature : temperatureSeries) {
            sum += temperature;
        }
        return sum;
    }

    public void absZeroCheck(double[] temperatureSeries) {
        for (double temperature : temperatureSeries) {
            if (temperature < absZero) {
                throw new InputMismatchException();
            }
        }
    }

    public void checkIllegalArgument(double[] temperatureSeries) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        checkIllegalArgument(temperatureSeries);
        return sum(temperatureSeries)/temperatureSeries.length;
    }

    public double deviation() {
        double deviance = 0;
        checkIllegalArgument(temperatureSeries);
        double average = average();
        for (double temperature : temperatureSeries) {
            deviance += (average - temperature)*(average - temperature);
        }
        deviance = Math.sqrt(deviance / (temperatureSeries.length));
        return deviance;
    }

    private double findExtremum(boolean val) {
        checkIllegalArgument(temperatureSeries);
        double extremum = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (val) {
                if (temperatureSeries[i] > extremum) {
                    extremum = temperatureSeries[i];
                }
            }
            else {
                if (temperatureSeries[i] < extremum) {
                    extremum = temperatureSeries[i];
                }
            }
        }
        return extremum;
    }

    public double min() {
        return findExtremum(false);
    }

    public double max() {
        return findExtremum(true);
    }

    public double findTempClosestToZero() {

        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkIllegalArgument(temperatureSeries);
        double closest = temperatureSeries[0];
        double minDistance = Math.abs(tempValue - closest);
        double distance;
        for (double temperature : temperatureSeries) {
            distance = Math.abs(tempValue - temperature);
            if (distance < minDistance) {
                minDistance = distance;
                closest = temperature;
            }
            else if (Math.abs(distance - minDistance) < delta) {
                if (temperature > closest) {
                    closest = temperature;
                }
            }
        }
        return closest;
    }

    private double[] findRange(double tempValue, boolean val) {
        checkIllegalArgument(temperatureSeries);
        double[] appropriate = new double[temperatureSeries.length];
        int sz = 0;
        int j = 0;

            if (val) {
                for (double temperature : temperatureSeries) {
                    if (temperature < tempValue) {
                        appropriate[j] = temperature;
                        j++;
                        sz++;
                    }
                }
            }
            else {
                    for (double temperature : temperatureSeries) {
                        if (temperature  > tempValue) {
                            appropriate[j] = temperature;
                            j++;
                            sz++;
                        }
                    }
            }
        double[] strippedList = new double[sz];
        System.arraycopy(appropriate, 0, strippedList, 0, sz);

        return strippedList;
    }


    public double[] findTempsLessThen(double tempValue) {
        return findRange(tempValue, true);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findRange(tempValue, false);
    }

    public TempSummaryStatistics summaryStatistics() {
        checkIllegalArgument(temperatureSeries);
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        checkIllegalArgument(temps);
        absZeroCheck(temps);
        int len = temperatureSeries.length + temps.length;
        int capacity = temperatureSeries.length;
        while (capacity < len) {
            capacity *= 2;
        }
        double[] newSeries = new double[capacity];
        System.arraycopy(temperatureSeries, 0, newSeries, 0,
                temperatureSeries.length);
        System.arraycopy(temps, 0, newSeries, 0, temperatureSeries.length);
        this.temperatureSeries = newSeries;

        return temperatureSeries.length;
    }
}
