package leetcode.queue_stack;

import java.util.Stack;

public class HowManyDayWillWarmer {

	class TemperatureLog{
		private int day;
		private int temperature;
		public TemperatureLog(int day, int temperature) {
			this.day = day;
			this.temperature = temperature;
		}
		public int getDay() {
			return day;
		}
		public int getTemperature() {
			return temperature;
		}
	}
	
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<TemperatureLog> dayTemperatureStack = new Stack<>(); 
        for (int i = 0; i < T.length; i++) {
			while(!dayTemperatureStack.isEmpty()) {
				if(dayTemperatureStack.peek().getTemperature() < T[i]) {
					TemperatureLog log = dayTemperatureStack.pop();
					result[log.getDay()] = i - log.getDay();
				}else {
					break;
				}
			}
			dayTemperatureStack.push(new TemperatureLog(i, T[i]));
		}
        while(!dayTemperatureStack.isEmpty()) {
			TemperatureLog log = dayTemperatureStack.pop();
			result[log.getDay()] = 0;
		}
        return result;
    }
    
    public static void main(String[] args) {
		for(Integer i : new HowManyDayWillWarmer().dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(Integer i : new HowManyDayWillWarmer().dailyTemperatures(new int[] {})) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(Integer i : new HowManyDayWillWarmer().dailyTemperatures(new int[] {30,30,30})) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
	
}
