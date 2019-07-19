package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class Logger {

	private Map<String, Integer> lastLogMap;
	
    /** Initialize your data structure here. */
    public Logger() {
        lastLogMap = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(lastLogMap.containsKey(message)) {
        	if(timestamp - lastLogMap.get(message) >= 10) {
        		lastLogMap.put(message, timestamp);
        		return true;
        	}else {
        		return false;
        	}
        }else {
        	lastLogMap.put(message, timestamp);
        	return true;
        }
    }
	
}
