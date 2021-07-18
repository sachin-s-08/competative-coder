package com.coding.practice.coding.standard;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Tutorial {
	
	
	public static void main(String[] args) throws Exception 
    {
 
		//SOAP body
        String xml = "";
         
        InputSource inputXML = new InputSource( new StringReader( xml ) );
         
        XPath xPath = XPathFactory.newInstance().newXPath();
         
        String result = xPath.evaluate("/soapenv:Envelope[1]/soapenv:Header[1]/ns1:extBackend[1]", inputXML);
 
        System.out.println(result);
    }
	
	

	public static int minimumMoves(List<Integer> a, List<Integer> m) {
		// Write your code here
		int count = 0;
		int i =0;
		for (Integer aEle : a) {
			Integer mEle = m.get(i);
			int[] mEleArr = getIntArr(mEle);
			int[] aEleArr = getIntArr(aEle);
			for (int j = 0; j < aEleArr.length; j++) {
				count += Math.abs(aEleArr[j] - mEleArr[j]);
			}
			i++;
			
		}
		return count;
	}

	public static int[] getIntArr (Integer myInt){
	        String temp = Integer.toString(myInt);
	        int[] intArr = new int[temp.length()];
	        for (int i = 0; i < temp.length(); i++)
	        {
	        intArr[i] = temp.charAt(i) - '0';
	        }return intArr;
	}
	
	 public static List<String> closestStraightCity1(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
		    // Write your code here
		// Write your code here
	    	Map<String,Integer> cityIndex = new HashMap<>();int i = 0;
	    	for (String city : c) {
				cityIndex.put(city, i);i++;
			}
	    	
	    	
	    	for (String query : q) {
	    		Integer cityIdx = cityIndex.get(query);
	    		
	    		Integer cmp = x.get(cityIdx);
	    		
	    		List<Integer> matching = getMin(cmp,x);
	    		
	    		for (String mat : q) {
//					y.get(index)
				}
	    		
	    	}
			return q;
	    	
	 }
	 
	 
	 public static List<Integer> getMin(int cmp, List<Integer> axis) {
		 int i = 0;List<Integer> matching = new ArrayList<>();
		 for (Integer cord : axis) {
			if(cord.equals(cmp)) {
				matching.add(i);
			}
			 
			 i++;
		}
		 return matching;
	 }
	
	
    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
    // Write your code here
    	Map<String,Integer> cityIndex = new HashMap<>();int i = 0;
    	for (String city : c) {
			cityIndex.put(city, i);i++;
		}
    	
    	Map<Integer,List<Integer>> xAxisCities = new HashMap<>();i=0;
    	for (Integer xAxis : x) {
    		if(xAxisCities.containsKey(xAxis)) {
    			List<Integer> citiesInSameAxis = xAxisCities.get(xAxis);citiesInSameAxis.add(i);
    			xAxisCities.put(xAxis, citiesInSameAxis)   ;			
    		}else {
    			List<Integer> citiesInSameAxis = new ArrayList<>();
    			citiesInSameAxis.add(i);
    			xAxisCities.put(xAxis, citiesInSameAxis)   ;			
    		}
    		i++;
		}
    	
    	
    	Map<Integer,List<Integer>> yAxisCities = new HashMap<>();i=0;
    	for (Integer yAxis : y) {
    		if(yAxisCities.containsKey(yAxis)) {
    			List<Integer> citiesInSameAxis = yAxisCities.get(yAxis);citiesInSameAxis.add(i);
    			yAxisCities.put(yAxis, citiesInSameAxis)   ;			
    		}else {
    			List<Integer> citiesInSameAxis = new ArrayList<>();
    			citiesInSameAxis.add(i);
    			yAxisCities.put(yAxis, citiesInSameAxis)   ;			
    		}
    		i++;
		}
    	
    	
    	List<String> retlst  = new ArrayList<>();
    	
    	for (String query : q) {
    		Integer cityIdx = cityIndex.get(query);
    		
    		Integer xAxisValue = x.get(cityIdx);
    		List<Integer> citiesInSameAxis = xAxisCities.get(xAxisValue);
    		String xAxisNeighbour = getNeighbour(citiesInSameAxis,cityIdx,x);
    		String xMinDist = xAxisNeighbour.split(":")[0];
    		
    		
    		Integer yAxisValue = y.get(cityIdx);
    		citiesInSameAxis = yAxisCities.get(yAxisValue);
    		String yAxisNeighbour = getNeighbour(citiesInSameAxis,cityIdx,y);
    		String yMinDist = yAxisNeighbour.split(":")[0];
    		
    		String ret ;
    		if(!xMinDist.equals("0") && !yMinDist.equals("0")) {
//    			ret = xMinDist < yMinDist ? xAxisNeighbour.split(":")[1] : 
    		}
    		
		}
		return retlst;
    	

    }
    
    
    public static String getNeighbour (List<Integer> citiesInSameAxis, Integer srcCity,List<Integer> axisArr) {
    	
    	Integer src = axisArr.get(srcCity);
    	
    	Integer res = 0;Integer ret = srcCity;
    	for (Integer cities : citiesInSameAxis) {
    		Integer dest = axisArr.get(cities);
    		int tmp = Math.abs(dest-src);
    		if(res!= 0 && res > tmp) {
    			res = tmp;ret = cities;
    		}
		}
    	
    	return res+":"+ret; 
    	
    }
}
