package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Evgen
 */
public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public String toString() {
        return history.toString();
    }
    
    public double maxValue() {
        double max = 0.0;
        if (!history.isEmpty()) {
            for (Double d : history) {
                max = Math.max(max, d);
            }
        }
        return max;
    }
    
    public double minValue() {
        double min = 0.0;
        if (!history.isEmpty()) {
            min = history.get(0);
            for (Double d : history) {
                min = Math.min(min, d);
            }
        }
        return min;
    }
    
    public double average() {
        double average = 0.0;
        if (!history.isEmpty()) {
            double sum = 0.0;
            for (double d : history) {
                sum += d;
            }
            average = sum / history.size();
        }
        return average;
    }
    
    public double greatestFluctuation() {
        if (history.size() > 1) {
            double greatestFluctuation = Math.abs(history.get(0) - history.get(1));
            if (history.size() == 2) {
                return greatestFluctuation;
            }
            
           
            for (int i = 1; i < history.size() - 1; i++) {
                greatestFluctuation = Math.max(greatestFluctuation,
                        Math.abs(history.get(i) - history.get(i + 1)));
            }
            return greatestFluctuation;
        }
        return 0.0;
    }
    
    public double variance() {
        double variance = 0.0;
        
        if (history.size() > 1) {
            
            double average = average();
            double sum = 0.0;
            for ( double d : history) {
                sum = sum + Math.pow(d - average, 2);
            }
            
            variance = sum / (history.size() - 1);
        }
        return variance;
    }
}
