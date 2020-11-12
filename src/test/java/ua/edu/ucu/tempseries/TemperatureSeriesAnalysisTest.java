package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    static final double DELTA = 0.00001;

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, DELTA);
    }



    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }


    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.7416573867739;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, DELTA);
    }



    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, DELTA);
    }



    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, DELTA);
    }



    @Test
    public void testcloseToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testcloseToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }


    @Test
    public void testcloseToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, DELTA);
    }



    @Test
    public void testcloseToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(12);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testcloseToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }


    @Test
    public void testcloseToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1;

        double actualResult = seriesAnalysis.findTempClosestToValue(-2);

        assertEquals(expResult, actualResult, DELTA);
    }


    @Test
    public void testLessThenValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult,DELTA);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testLessThenValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsLessThen(1);
    }


    @Test
    public void testMoreThenValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3, -5, 1};

        double[] actualResult = seriesAnalysis.findTempsLessThen(4);

        assertArrayEquals(expResult, actualResult,DELTA);
    }


    @Test
    public void testGreaterThenValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult,DELTA);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testGreaterThenValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsGreaterThen(1);
    }


    @Test
    public void testGreaterThenValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5, 1};

        double[] actualResult = seriesAnalysis.findTempsLessThen(2);

        assertArrayEquals(expResult, actualResult,DELTA);
    }


    @Test
    public void testTempStatsWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult,DELTA);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testTempStatsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }


    @Test
    public void testTempStats() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        TempSummaryStatistics result = seriesAnalysis.summaryStatistics();

        assertEquals(1.0, result.getAvgTemp(), DELTA);
        assertEquals(3.7416573867739413, result.getDevTemp(), DELTA);
        assertEquals(-5.0, result.getMinTemp(), DELTA);
        assertEquals(5.0, result.getMaxTemp(), DELTA);

    }


    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 16;

        int actualResult = seriesAnalysis.addTemps(15.0, -15.0, 4.5, 12, 200);
        assertEquals(expResult, actualResult);
    }


    @Test(expected = InputMismatchException.class)
    public void testAddLessThenZeroTemps() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.addTemps(15.0, -15.0, -280.0);
    }
}
