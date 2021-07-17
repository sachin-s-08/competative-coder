package com.practice.tutorial.Tutorial;

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
 
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hal=\"http://sita.aero/hal\" xmlns:ns=\"http://sita.aero/WTR_BagsSearchRQ/2/0\" xmlns:ns1=\"http://www.iata.org/IATA/2007/00\" xmlns:ns2=\"http://sita.aero/wtr/common/2/0\">\r\n" + 
        		"<soapenv:Header xmlns:ca=\"http://com.dlh.zambas.japi\">\r\n" + 
        		"<ca:ApplicationID>ARTOS</ca:ApplicationID>\r\n" + 
        		"<ca:CallerID>TT:BLRD:4312</ca:CallerID>\r\n" + 
        		"<ca:CustomerID>LH</ca:CustomerID>\r\n" + 
        		"<ca:CallID>123456</ca:CallID>\r\n" + 
        		" <wsse:Security soapenv:actor=\"http://schemas.xmlsoap.org/soap/actor/next\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n" + 
        		"<wsse:BinarySecurityToken EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\" ValueType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3\" wsu:Id=\"DESMONCertificate\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">MIIUFTCCEv2gAwIBAgIBATANBgkqhkiG9w0BAQsFADAxMQwwCgYDVQQKDANMU1kxDzANBgNVBAsMBkRFU01PTjEQMA4GA1UEAwwHTEgtVEVTVDAeFw0yMTAzMTcwOTQzNTZaFw0yMTAzMTgyMTQ4NTZaMIH+MRIwEAYKCZImiZPyLGQBGRYCREUxEzARBgoJkiaJk/IsZAEZFgNETEgxEzARBgoJkiaJk/IsZAEZFgNMU1kxGjAYBgoJkiaJk/IsZAEZFgpERVNNT04tTEFCMRAwDgYDVQQLDAdDT01QQU5ZMQwwCgYDVQQLDANMUEExETAPBgNVBAsMCFNFUlZJQ0VTMQ8wDQYDVQQLDAZERVNNT04xEjAQBgNVBAsMCVNFUlYyU0VSVjELMAkGA1UECwwCTEgxFDASBgNVBAsMC0NJVFAtTVctREVWMRQwEgYDVQQLDAsxNzEuMTcuMjkuMTERMA8GA1UEAwwIRURTVEVTVFQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQD67BneVxcdzKDwqyLGMv9T5ROvFvD8AdNXh9K6jAw6rb1DpnKZIQjD4jCjrFR8Ac3+zgtfP0Rw+I7ZIHVjaopSj9GNUN5b46x15IMqEXjhOc5gT30baWDeeQ95Ki78Ke+xTP07VuW3k9Q2DQtDWFUHk4/zRRW33szvNI6jJ4cs9HmRAKgkHpptQvtHCMMmPoC4ai8iclDk28gJElb9hj4sbXTpkFPSzMN1iEEBxrp07QaWm6gV6jIWz7UPHnWX4kLlrUzSKocsT07DiemCB8ADJ/esMgoK1EV4EJHg91EfnccrKi90on/aMgZD+qjmnnBApdf76TP/1xRQQD2//z+VAgMBAAGjghBoMIIQZDAMBgcrBgEEgxANBAE0MBIGBysGAQSDEAwEB0xILVRFU1QwggjHBgcrBgEEgxALBIIIulpBTUJBU19ERVVUU0NIRV9CQUhOI1pBTUJBUyM0VEU3SVZWVUhNR0VNQlpQMlBYV1pHR0xHSlZJS0JaU0dRNEpQMzZERUU1SlNSWTJTUjJBPT09PSNMSCMjIyBaQU1CQVNfU1RBUl9CQUdIVUIjWkFNQkFTIyNMSCMjIyBMSF9HX1NVUEVSX1VTRVJfQUxMX0lOVkVOVE9SWV9VUERBVEVfUklHSFRTI0dMT0JBTCMjTEgjIyNBTFRFQUdVSSxBTU9TLDFBX0lOVlVJLDFBX0FETUlOVUkgTEhfR19BUFBMX0VXX0xJRE8jR0xPQkFMIyNMSCNFVyMjRVdfTElETyxURVNUX0FQUCBMSF9HX0FQUExfRVdfREFTI0dMT0JBTCMjTEgjRVcjI0VXX0RBUyxURVNUX0FQUCBaQU1CQVNfRVVST0NPTlRST0wjWkFNQkFTIyNMSCMjIyBaQU1CQVNfUE5SX0RFQ1JZUFQjWkFNQkFTIyNMSCNPUyMjIFpBTUJBU19DU0JfR0VUVVNFUiNaQU1CQVMjIyMjIyBaQU1CQVNfQk9PS0lOR0NPTV9IT1RFTE9GRkVSI1pBTUJBUyMjTEgjIyMgWkFNQkFTX0NSTV9DUkVESVRNSUxFU0ZPUkZMSUdIVCNaQU1CQVMjI0xIIyMjIFpBTUJBU19GSV9BTlkjWkFNQkFTIyNMSCMjI1RFU1RfQVBQIFpBTUJBU19DUk1fQU5ZI1pBTUJBUyMjTEgjIyNURVNUX0FQUCxFMkVfTU9OSVRPUiBaQU1CQVNfRkxFWFBSSUNFUl9CRVNUUFJJQ0UjWkFNQkFTIyNMSCMjI0xIX0NPTSxMSE9QRU5BUEksVEVTVF9BUFAsQldfQkVTVFBSSSxMSENPTTIgWkFNQkFTX0VNU19ZSUVMRFRGVE9BTFRFQSNaQU1CQVMjI0xIIyMjIFpBTUJBU19DU0JfQU5ZI1pBTUJBUyMjTEgjIyNURVNUX0FQUCxFMkVfTU9OSVRPUiBMSF9HX1JFU1RSSUNURURfSU5WRU5UT1JZX0ZMSUdIVF9EQVRFX1ZJRVcjR0xPQkFMIyNMSCMjI1RFU1RfQVBQLEFNT1MgWkFNQkFTX0RDU19BTlkjWkFNQkFTIyNMSCMjI1RFU1RfQVBQIENVUF9CVENfUFJPRklMRSNDVVAjI0xIIyMjIFpBTUJBU19US1RfQU5ZI1pBTUJBUyMjTEgjIyNURVNUX0FQUCBMSF9HX0FQUExfWkVCUkFfVEVTVF9ST0xFI0dMT0JBTCMjTEgjIyNURVNUX0FQUCxBTU9TIE9JU19XRUJTRVJWSUNFU19NT0JJTEVQT1JUQUwjT0lTIyNMSCMjIyBaQU1CQVNfU01TX0FOWSNaQU1CQVMjI0xIIyMjVEVTVF9BUFAgWkFNQkFTX1JFU1BPTlNZU19NRVJHRV9TRU5EMSNaQU1CQVMjI0xIIyMjIFpBTUJBU19FTVNfVE1QVEVTVCNaQU1CQVMjIyMjIyBaQU1CQVNfVEtUX1JFQURPTkxZI1pBTUJBUyMjIyMjIFpBTUJBU19US1RfQUlEQSNaQU1CQVMjIyMjIyBaQU1CQVNfUE5SX0VOQ1JZUFQjWkFNQkFTIyNMSCNPUyMjIENPVVBPTkRCX0dFVFZBVCNDT1VQT05EQiMjTEgjT1MsTFgsU04jI1BBU05HUkxILFRFU1RfQVBQIExIX0dfQVBQTF9NRFdPUFNfVEVTVF9ST0xFI0dMT0JBTCMjTEgjIyNURVNUX0FQUCBaQU1CQVNfU1RBUl9BVVRPRE9DQ0hFQ0sjWkFNQkFTIyNMSCMjIyBaQU1CQVNfTk9USUZJQ0FUSU9OUyNaQU1CQVMjI0xIIyMjIExIX0dfQVBQTF9FV19JQ0FSR08jR0xPQkFMIyNMSCNFVyMjRVdfSUNBUkdPLFRFU1RfQVBQIFpBTUJBU19FTVNfVEFOR09fQ0xJRU5UUyNaQU1CQVMjI0xIIyMjIFpBTUJBU19CV19DRkkjWkFNQkFTIyNMSCMjI0xIR19BUFAgWkFNQkFTX1JFU1BPTlNZU19NQU5BR0VfTElTVFMjWkFNQkFTIyNMSCMjIyBaQU1CQVNfU01TX1NFTkQjWkFNQkFTIyNMSCMjIyBaQU1CQVNfUkVTUE9OU1lTX01FUkdFX1NFTkQjWkFNQkFTIyNMSCMjIyBXT1JMRFRSQUNFUi1XRUJTRVJWSUNFI1dPUkxEVFJBQ0VSIyNMSCMjIyBJUFNfUEFTU0VOR0VSI0lQUyMjTEgjIyMgVEFOR09fSU5GT19PUEVSI1RBTkdPIyMjIyMgQkVTVF9IVUJfQ09OTkVYI0JFU1QjI0xTWSNMSCMjIElQU19ET0NVTUVOVFMjSVBTIyNMSCMjIyBaQU1CQVNfQ09OQ1VSX1BST0ZJTEUjWkFNQkFTIyNMSCMjIyBaQU1CQVNfRU1TX1RFU1RRI1pBTUJBUyMjIyMjIE1EU19QU1dQT0xJQ1kjTURTIyNMSCMjIyBCRVNUX0dFVF9SRUJPT0tJTkdTI0JFU1QjI0xTWSNMSCMjIFpBTUJBU19EU1BfTE9DS0VSI1pBTUJBUyMjTEgjIyMgTEhfR19ERVNNT05URVNUX09TX1NIQVJFRCNHTE9CQUwjI09TI0xIIyNURVNUX0FQUCxLT0pBQyxHVUlERVJFUyBaQU1CQVNfQkFHX1BBWF9UUklQX0NPTlRBQ1QjWkFNQkFTIyNMSCMjIyBMSF8xX05HSV9JTlZfRkxJR0hUX0lOVkVOVE9SWV9WSUVXRVIjSU5WIyNMSCMjI0FMVEVBR1VJLENSRVdQT1JUQUwgU0FNQkFfWkFNQkFTX1I2I1NBTUJBIyNMSCMjIyBMSF9HX0FQUExfQ0xIQ0JFI0dMT0JBTCMjTEgjIyNDTEhfQ0JFIFpBTUJBU19PUEVOQVBJX01EUyNaQU1CQVMjI0xIIyMjMBIGBysGAQSDEAAEB0xILVRFU1QwDAYHKwYBBIMQDgQBTjAeBgcrBgEEgxACBBNqZW5zLmZpc2NoZXJAZGxoLmRlMIIEfAYHKwYBBIMQAQSCBG9aQU1CQVNfREVVVFNDSEVfQkFITiBaQU1CQVNfU1RBUl9CQUdIVUIgTEhfR19TVVBFUl9VU0VSX0FMTF9JTlZFTlRPUllfVVBEQVRFX1JJR0hUUyBMSF9HX0FQUExfRVdfTElETyBMSF9HX0FQUExfRVdfREFTIFpBTUJBU19FVVJPQ09OVFJPTCBaQU1CQVNfUE5SX0RFQ1JZUFQgWkFNQkFTX0NTQl9HRVRVU0VSIFpBTUJBU19CT09LSU5HQ09NX0hPVEVMT0ZGRVIgWkFNQkFTX0NSTV9DUkVESVRNSUxFU0ZPUkZMSUdIVCBaQU1CQVNfRklfQU5ZIFpBTUJBU19DUk1fQU5ZIFpBTUJBU19GTEVYUFJJQ0VSX0JFU1RQUklDRSBaQU1CQVNfRU1TX1lJRUxEVEZUT0FMVEVBIFpBTUJBU19DU0JfQU5ZIExIX0dfUkVTVFJJQ1RFRF9JTlZFTlRPUllfRkxJR0hUX0RBVEVfVklFVyBaQU1CQVNfRENTX0FOWSBDVVBfQlRDX1BST0ZJTEUgWkFNQkFTX1RLVF9BTlkgTEhfR19BUFBMX1pFQlJBX1RFU1RfUk9MRSBPSVNfV0VCU0VSVklDRVNfTU9CSUxFUE9SVEFMIFpBTUJBU19TTVNfQU5ZIFpBTUJBU19SRVNQT05TWVNfTUVSR0VfU0VORDEgWkFNQkFTX0VNU19UTVBURVNUIFpBTUJBU19US1RfUkVBRE9OTFkgWkFNQkFTX1RLVF9BSURBIFpBTUJBU19QTlJfRU5DUllQVCBDT1VQT05EQl9HRVRWQVQgTEhfR19BUFBMX01EV09QU19URVNUX1JPTEUgWkFNQkFTX1NUQVJfQVVUT0RPQ0NIRUNLIFpBTUJBU19OT1RJRklDQVRJT05TIExIX0dfQVBQTF9FV19JQ0FSR08gWkFNQkFTX0VNU19UQU5HT19DTElFTlRTIFpBTUJBU19CV19DRkkgWkFNQkFTX1JFU1BPTlNZU19NQU5BR0VfTElTVFMgWkFNQkFTX1NNU19TRU5EIFpBTUJBU19SRVNQT05TWVNfTUVSR0VfU0VORCBXT1JMRFRSQUNFUi1XRUJTRVJWSUNFIElQU19QQVNTRU5HRVIgVEFOR09fSU5GT19PUEVSIEJFU1RfSFVCX0NPTk5FWCBJUFNfRE9DVU1FTlRTIFpBTUJBU19DT05DVVJfUFJPRklMRSBaQU1CQVNfRU1TX1RFU1RRIE1EU19QU1dQT0xJQ1kgQkVTVF9HRVRfUkVCT09LSU5HUyBaQU1CQVNfRFNQX0xPQ0tFUiBMSF9HX0RFU01PTlRFU1RfT1NfU0hBUkVEIFpBTUJBU19CQUdfUEFYX1RSSVBfQ09OVEFDVCBMSF8xX05HSV9JTlZfRkxJR0hUX0lOVkVOVE9SWV9WSUVXRVIgU0FNQkFfWkFNQkFTX1I2IExIX0dfQVBQTF9DTEhDQkUgWkFNQkFTX09QRU5BUElfTURTMIIB6wYHKwYBBIMQEwSCAd5CWEc0bW1Rc0YrZTlqOEYvTmh0VlRUNEhwZ2MwTHdDem0vUjhWMDViMFFZUGRsS0Y0TjVVRjQrMVo3VC9VdXFxaUpHZnVjY2xuUU0zCloySkZOKzhMTmc1bjRsTUo1QVhWeExlNmc3bHRaVndrazlJN1pnQ1BnMWVoc0FaUC9PVmdSVk1telJwM3BuNG1RWjY0eVcwTVVaUHcKcDZqcCtNWU1YaWlPL0kwbzFoa1JKNGxZUitvc2pjYi82cHN0VHd3QjZLeHRYc0MvYzVnWGFtYnNENGs4ZVdpWkJ2blU4T0NMYXVuTgp3N2F6QzArUEJhQ0xlbXZkSmp3UExuUUZ6aUtaTVU2NUVtaUlFTWgzV29qc3VObGdOOXZVUlNWbnpNMTM2Q3B2ZkhDb21CV1UzdEdwCmhTQWlKVUM3UnFXRDc3a1lTa0lIK2NZalpWb3h3SVZnT3FDTkFRejVHUnFteTBSYTNUbmlBZWNFNFRNMHRKbEd0VVk5dGZLeEYxV3EKVmZnTWdMTE5ZaTBsdkc0eHdJVmdPcUNOQVp2NkljdG91UHNxTjJkaVJUZnZDellPWitKVENlUUYxY1MzdW9PNWJXVmNKSlBTTzJZQQpqNE9UejVDMmk3cmFrQT09MBEGBysGAQSDEAMEBjE4MDMwMjATBgcrBgEEgxASBAhFRFNURVNUVDBYBgcrBgEEgxAGBE1aQU1CQVNfREVVVFNDSEVfQkFITjo0VEU3SVZWVUhNR0VNQlpQMlBYV1pHR0xHSlZJS0JaU0dRNEpQMzZERUU1SlNSWTJTUjJBPT09PTANBgcrBgEEgxAIBAJMSDAMBgcrBgEEgxAPBAFOMBYGBysGAQSDEBEEC0NJVFAtTVctREVWMA0GBysGAQSDEBQEAkxIMA0GCSqGSIb3DQEBCwUAA4IBAQAb+Bykj3EKJXtCJ5NWLEiXcoURWFUIYDbHtE1CgPCjq73gM2GmQUKkl1PDqOvrFJChff6ve/lfkjVR5aoFcdZyqJQSWWuc4WvmQV3vjM1haVeN1k6xCL7QPQGGKaQNikr7VwB9s4Loq2ZBTMqn/XiRWLcDySdV+56hXByArxGFk+J3Zgmq4cEsA5DN2GBKLGsmblTOn56T0dxdFslr3FWli0hs2ztQ1hhS2d3psmhWAWsoj3F01YSH34IRhlhub4XpVK1cf18Eyqfnk6ZGlHygUFW2AwfD3C4EXHFToB89TZudu1oltD1FxANln+RnAHSQdmB/h0bavHcdxpm4290C</wsse:BinarySecurityToken>\r\n" + 
        		"</wsse:Security>\r\n" + 
        		"<ns1:extBackend>SITA</ns1:extBackend>\r\n" + 
        		"</soapenv:Header>\r\n" + 
        		"<soapenv:Body>\r\n" + 
        		"<ns:WTR_BagsSearchRQ EchoToken=\"\" TimeStamp=\"\" Target=\"Production\" Version=\"\" TransactionIdentifier=\"\" SequenceNmbr=\"\" TransactionStatusCode=\"\" PrimaryLangID=\"\" AltLangID=\"\" RetransmissionIndicator=\"\">\r\n" + 
        		"<ns:POS>\r\n" + 
        		"<!--1 to 5 repetitions:-->\r\n" + 
        		"  \r\n" + 
        		"</ns:POS>\r\n" + 
        		"  \r\n" + 
        		"<ns:QuickOnhandOption SearchByQOH=\"false\"/>\r\n" + 
        		"</ns:WTR_BagsSearchRQ>\r\n" + 
        		"</soapenv:Body>\r\n" + 
        		"</soapenv:Envelope>";
         
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
