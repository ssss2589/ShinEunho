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
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*������ ��ȣ*/
	        if(go!=null) {
	        urlBuilder.append("&" + URLEncoder.encode("depTerminalId","UTF-8") + "=" + URLEncoder.encode(go, "UTF-8")); /*����͹̳�ID*/
	        }else {
	        	ur="";
	        }
	        urlBuilder.append("&" + URLEncoder.encode("arrTerminalId","UTF-8") + "=" + URLEncoder.encode(back, "UTF-8")); /*�����͹̳�ID*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*�����*/
	        urlBuilder.append("&" + URLEncoder.encode("busGradeId","UTF-8") + "=" + URLEncoder.encode(request.getParameter("grade"), "UTF-8")); /*�������ID*/
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
		case "������":
			return "NAEK010";
		case "��Ʈ��":
			return "NAEK020";
		case "������":
			return "NAEK032";
		case "��õ":
			return "NAEK100";
		case "��õ":
			return "NAEK101";
		case "����":
			return "NAEK110";
		case "����":
			return "NAEK127";
		case "����":
			return "NAEK120";
		case "����":
			return "NAEK126";
		case "�ȼ�":
			return "NAEK132";
		case "����":
			return "NAEK150";
		case "����":
			return "NAEK169";
		case "������":
			return "NAEK170";
		case "����":
			return "NAEK200";
		case "����":
			return "NAEK210";
		case "��ô":
			return "NAEK220";
		case "����":
			return "NAEK230";
		case "����":
			return "NAEK240";
		case "���":
			return "NAEK270";
		case "��õ":
			return "NAEK250";
		case "����":
			return "NAEK300";
		case "õ��":
			return "NAEK310";
		case "����":
			return "NAEK320";
		case "����":
			return "NAEK352";
		case "���":
			return "NAEK370";
		case "û��":
			return "NAEK400";
		case "����":
			return "NAEK420";
		case "����":
			return "NAEK500";
		case "����":
			return "NAEK505";
		case "����":
			return "NAEK510";
		case "��õ":
			return "NAEK515";
		case "����":
			return "NAEK520";
		case "����":
			return "NAEK530";
		case "����":
			return "NAEK540";
		case "����":
			return "NAEK554";
		case "����":
			return "NAEK555";
		case "����":
			return "NAEK560";
		case "����":
			return "NAEK602";
		case "����":
			return "NAEK610";
		case "�ͻ�":
			return "NAEK615";
		case "����":
			return "NAEK620";
		case "��â":
			return "NAEK645";
		case "�λ�":
			return "NAEK700";
		case "����":
			return "NAEK705";
		case "â��":
			return "NAEK710";
		case "���":
			return "NAEK715";
		case "�뿵":
			return "NAEK730";
		case "����":
			return "NAEK735";
		case "�뱸":
			return "NAEK807";
		case "����":
			return "NAEK810";
		case "����":
			return "NAEK815";
		case "��õ":
			return "NAEK815";
		case "����":
			return "NAEK830";
		case "�ȵ�":
			return "NAEK840";
		}
		return null;
	}

	public String BackCity(String back) {
		switch (back) {
		case "������":
			return "NAEK010";
		case "��Ʈ��":
			return "NAEK020";
		case "������":
			return "NAEK032";
		case "��õ":
			return "NAEK100";
		case "��õ":
			return "NAEK101";
		case "����":
			return "NAEK110";
		case "����":
			return "NAEK127";
		case "����":
			return "NAEK120";
		case "����":
			return "NAEK126";
		case "�ȼ�":
			return "NAEK132";
		case "����":
			return "NAEK150";
		case "����":
			return "NAEK169";
		case "������":
			return "NAEK170";
		case "����":
			return "NAEK200";
		case "����":
			return "NAEK210";
		case "��ô":
			return "NAEK220";
		case "����":
			return "NAEK230";
		case "����":
			return "NAEK240";
		case "���":
			return "NAEK270";
		case "��õ":
			return "NAEK250";
		case "����":
			return "NAEK300";
		case "õ��":
			return "NAEK310";
		case "����":
			return "NAEK320";
		case "����":
			return "NAEK352";
		case "���":
			return "NAEK370";
		case "û��":
			return "NAEK400";
		case "����":
			return "NAEK420";
		case "����":
			return "NAEK500";
		case "����":
			return "NAEK505";
		case "����":
			return "NAEK510";
		case "��õ":
			return "NAEK515";
		case "����":
			return "NAEK520";
		case "����":
			return "NAEK530";
		case "����":
			return "NAEK540";
		case "����":
			return "NAEK554";
		case "����":
			return "NAEK555";
		case "����":
			return "NAEK560";
		case "����":
			return "NAEK602";
		case "����":
			return "NAEK610";
		case "�ͻ�":
			return "NAEK615";
		case "����":
			return "NAEK620";
		case "��â":
			return "NAEK645";
		case "�λ�":
			return "NAEK700";
		case "����":
			return "NAEK705";
		case "â��":
			return "NAEK710";
		case "���":
			return "NAEK715";
		case "�뿵":
			return "NAEK730";
		case "����":
			return "NAEK735";
		case "�뱸":
			return "NAEK807";
		case "����":
			return "NAEK810";
		case "����":
			return "NAEK815";
		case "��õ":
			return "NAEK815";
		case "����":
			return "NAEK830";
		case "�ȵ�":
			return "NAEK840";
		}
		return null;
	}

}