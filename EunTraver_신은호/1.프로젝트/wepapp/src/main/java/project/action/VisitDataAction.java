package project.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import project.VO.VisitVO;

public class VisitDataAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String ur="boot/visitData.jsp";
		        String list=request.getParameter("list");
		        String visittype=request.getParameter("visittype");
		        String area=request.getParameter("area");
		        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=0hat6wdsByCYKkWFvLP5G4O41ue2nGy2Wm4NccNe8RSSj2t0I9bluljNnrLFFB2adkNz9nvhgyRXE9MBwd2rmw%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("����Ű (URL- Encode)", "UTF-8")); /*�������������п��� �߱޹��� ����Ű*/
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���� ������ ��ȣ*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*���񽺸�=���ø�*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (������), AND (�ȵ���̵�),WIN (��������), ETC*/
		        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode(list, "UTF-8")); /*, ��ǥ�̹����� �ݵ�� �ִ� ���� (O=�����, P=��ȸ��, Q=�����ϼ�, R=�����ϼ�)*/
		        urlBuilder.append("&" + URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*��з� �ڵ�*/
		        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(visittype, "UTF-8")); /*����Ÿ��(������, ���� ��) ID*/
		        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(area, "UTF-8")); /*�����ڵ�*/
		        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ñ����ڵ�(areaCode �ʼ�)*/
		        urlBuilder.append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ߺз� �ڵ�(cat1�ʼ�)*/
		        urlBuilder.append("&" + URLEncoder.encode("cat3","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�Һз� �ڵ�(cat1,cat2�ʼ�)*/
		        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*��� ���� (Y=���, N=����)*/
		       String url= urlBuilder.toString();
		       try {
		    	   ArrayList<VisitVO> visitlist = new ArrayList<VisitVO>();
		    	   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    	   DocumentBuilder dBuilder;
		    	   dBuilder = dbFactory.newDocumentBuilder();
		    	   Document doc = dBuilder.parse(url);
		    	   doc.getDocumentElement().normalize();
		    	   NodeList nList = doc.getElementsByTagName("item");
		    	   for(int temp = 0; temp < nList.getLength(); temp++) {
		    		   Node nNode = (Node) nList.item(temp);
		    		   if(nNode.getNodeType()==Node.ELEMENT_NODE) {
		    			   VisitVO visit = new VisitVO();
		    			   Element eElement = (Element) nNode;
		    			   visit.setAddress(getTagValue("addr1",eElement));
		    			   visit.setCat1(getTagValue("cat1",eElement));
		    			   visit.setCat2(getTagValue("cat2",eElement));
		    			   visit.setCat3(getTagValue("cat3",eElement));
		    			   visit.setImage(getTagValue("firstimage",eElement));
		    			   visit.setReadcount(getTagValue("readcount",eElement));
		    			   visit.setSigungucode(getTagValue("sigungucode",eElement));
		    			   visit.setTitle(getTagValue("title",eElement));
		    			   visit.setTel(getTagValue("tel",eElement));
		    			   visitlist.add(visit);
		    		   }
		    		   int size=visitlist.size();
		    		   request.setAttribute("visitList", visitlist);
		    		   request.setAttribute("visitsize", size);
		    	   }
		       }catch(Exception e) {
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
}


