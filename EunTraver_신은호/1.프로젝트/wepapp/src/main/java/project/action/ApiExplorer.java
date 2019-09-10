package project.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import project.VO.BusVO;

public class ApiExplorer implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ur = "boot/busData.jsp";
		String go=GoCity(request.getParameter("go"));
		String back=BackCity(request.getParameter("back"));
		String str=request.getParameter("date");
		String delim = "-";
		String date="";
		StringTokenizer st=new StringTokenizer(str,delim,false);
		int countTokens = st.countTokens();
		for(int i=0;i<countTokens;i++) {
			String token =st.nextToken();
			date+=token;
		}
		System.out.println(date);
		 StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/ExpBusInfoService/getStrtpntAlocFndExpbusInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=0hat6wdsByCYKkWFvLP5G4O41ue2nGy2Wm4NccNe8RSSj2t0I9bluljNnrLFFB2adkNz9nvhgyRXE9MBwd2rmw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
	        if(go!=null) {
	        urlBuilder.append("&" + URLEncoder.encode("depTerminalId","UTF-8") + "=" + URLEncoder.encode(go, "UTF-8")); /*출발터미널ID*/
	        }else {
	        	ur="";
	        }
	        urlBuilder.append("&" + URLEncoder.encode("arrTerminalId","UTF-8") + "=" + URLEncoder.encode(back, "UTF-8")); /*도착터미널ID*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*출발일*/
	        urlBuilder.append("&" + URLEncoder.encode("busGradeId","UTF-8") + "=" + URLEncoder.encode(request.getParameter("grade"), "UTF-8")); /*버스등급ID*/
	        String url = urlBuilder.toString();
			try {
				ArrayList<BusVO> buslist = new ArrayList<BusVO>();
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder;
				dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				doc.getDocumentElement().normalize();
			    //System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
			    NodeList nList = doc.getElementsByTagName("item");
			    for(int temp = 0; temp < nList.getLength(); temp++){		
			    	Node nNode = (Node) nList.item(temp);
			    	if(nNode.getNodeType() == Node.ELEMENT_NODE){
			    		BusVO bus = new BusVO();				
			    		Element eElement = (Element) nNode;
			    		bus.setGocity(getTagValue("arrPlaceNm", eElement));
			    		bus.setEndcity(getTagValue("depPlaceNm", eElement));
			    		bus.setGotime(getTagValue("depPlandTime", eElement));
			    		bus.setEndtime(getTagValue("arrPlandTime", eElement));
			    		bus.setGrade(getTagValue("gradeNm", eElement));
			    		bus.setPrice(getTagValue("charge", eElement));
			    		buslist.add(bus);
			    	}
			    	int size=buslist.size();
			    	request.setAttribute("items", buslist);
			    	request.setAttribute("itemsize", size);
			    }
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher(ur).forward(request, response);
	}
			    private static String getTagValue(String tag, Element eElement) {
				    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
				    Node nValue = (Node) nlList.item(0);
				    if(nValue == null) 
				        return null;
				    return nValue.getNodeValue();
				}

	public String GoCity(String go) {
		switch (go) {
		case "서울경부":
			return "NAEK010";
		case "센트럴":
			return "NAEK020";
		case "동서울":
			return "NAEK032";
		case "인천":
			return "NAEK100";
		case "부천":
			return "NAEK101";
		case "수원":
			return "NAEK110";
		case "오산":
			return "NAEK127";
		case "성남":
			return "NAEK120";
		case "광명":
			return "NAEK126";
		case "안성":
			return "NAEK132";
		case "용인":
			return "NAEK150";
		case "구리":
			return "NAEK169";
		case "의정부":
			return "NAEK170";
		case "강릉":
			return "NAEK200";
		case "동해":
			return "NAEK210";
		case "삼척":
			return "NAEK220";
		case "속초":
			return "NAEK230";
		case "원주":
			return "NAEK240";
		case "양양":
			return "NAEK270";
		case "춘천":
			return "NAEK250";
		case "대전":
			return "NAEK300";
		case "천안":
			return "NAEK310";
		case "공주":
			return "NAEK320";
		case "세종":
			return "NAEK352";
		case "논산":
			return "NAEK370";
		case "청주":
			return "NAEK400";
		case "충주":
			return "NAEK420";
		case "광주":
			return "NAEK500";
		case "목포":
			return "NAEK505";
		case "여수":
			return "NAEK510";
		case "순천":
			return "NAEK515";
		case "광양":
			return "NAEK520";
		case "나주":
			return "NAEK530";
		case "고흥":
			return "NAEK540";
		case "보성":
			return "NAEK554";
		case "벌교":
			return "NAEK555";
		case "영광":
			return "NAEK560";
		case "전주":
			return "NAEK602";
		case "군산":
			return "NAEK610";
		case "익산":
			return "NAEK615";
		case "김제":
			return "NAEK620";
		case "순창":
			return "NAEK645";
		case "부산":
			return "NAEK700";
		case "마산":
			return "NAEK705";
		case "창원":
			return "NAEK710";
		case "울산":
			return "NAEK715";
		case "통영":
			return "NAEK730";
		case "김해":
			return "NAEK735";
		case "대구":
			return "NAEK807";
		case "구미":
			return "NAEK810";
		case "경주":
			return "NAEK815";
		case "김천":
			return "NAEK815";
		case "포항":
			return "NAEK830";
		case "안동":
			return "NAEK840";
		}
		return null;
	}

	public String BackCity(String back) {
		switch (back) {
		case "서울경부":
			return "NAEK010";
		case "센트럴":
			return "NAEK020";
		case "동서울":
			return "NAEK032";
		case "인천":
			return "NAEK100";
		case "부천":
			return "NAEK101";
		case "수원":
			return "NAEK110";
		case "오산":
			return "NAEK127";
		case "성남":
			return "NAEK120";
		case "광명":
			return "NAEK126";
		case "안성":
			return "NAEK132";
		case "용인":
			return "NAEK150";
		case "구리":
			return "NAEK169";
		case "의정부":
			return "NAEK170";
		case "강릉":
			return "NAEK200";
		case "동해":
			return "NAEK210";
		case "삼척":
			return "NAEK220";
		case "속초":
			return "NAEK230";
		case "원주":
			return "NAEK240";
		case "양양":
			return "NAEK270";
		case "춘천":
			return "NAEK250";
		case "대전":
			return "NAEK300";
		case "천안":
			return "NAEK310";
		case "공주":
			return "NAEK320";
		case "세종":
			return "NAEK352";
		case "논산":
			return "NAEK370";
		case "청주":
			return "NAEK400";
		case "충주":
			return "NAEK420";
		case "광주":
			return "NAEK500";
		case "목포":
			return "NAEK505";
		case "여수":
			return "NAEK510";
		case "순천":
			return "NAEK515";
		case "광양":
			return "NAEK520";
		case "나주":
			return "NAEK530";
		case "고흥":
			return "NAEK540";
		case "보성":
			return "NAEK554";
		case "벌교":
			return "NAEK555";
		case "영광":
			return "NAEK560";
		case "전주":
			return "NAEK602";
		case "군산":
			return "NAEK610";
		case "익산":
			return "NAEK615";
		case "김제":
			return "NAEK620";
		case "순창":
			return "NAEK645";
		case "부산":
			return "NAEK700";
		case "마산":
			return "NAEK705";
		case "창원":
			return "NAEK710";
		case "울산":
			return "NAEK715";
		case "통영":
			return "NAEK730";
		case "김해":
			return "NAEK735";
		case "대구":
			return "NAEK807";
		case "구미":
			return "NAEK810";
		case "경주":
			return "NAEK815";
		case "김천":
			return "NAEK815";
		case "포항":
			return "NAEK830";
		case "안동":
			return "NAEK840";
		}
		return null;
	}

}