import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "android/MemberList.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		FriendDAO DAO = FriendDAO.getInstance();
		ArrayList<MemberVO> memList = new ArrayList<>();
		ArrayList<FriendVO> friendList = new ArrayList<>();
		String id = request.getParameter("id");
		friendList = DAO.search(id);
		memList = memberDAO.memberList();
		ArrayList<HashMap<String, String>> itemList = new ArrayList<HashMap<String, String>>();

		Iterator<MemberVO> it = memList.iterator();
		while (it.hasNext()) {
			MemberVO mem = it.next();
			if (mem.getId().equals(id)) {
				it.remove();
			} else {
				for (FriendVO frend : friendList) {
					if (frend.getFid().equals(mem.getName().trim())) {
						mem.setFrendstats(1);
						break;
					}
				}
				HashMap<String, String> item = new ParseMap<MemberVO>().parseMap(mem);
				itemList.add(item);
			}
		}
		String protocol = new ProtocolFactory(0).addArr("member", itemList).toString();
		System.out.println(protocol);
		request.setAttribute("protocol", protocol);

//		System.out.println(friendList.size());
//		int fsize = friendList.size();
//		request.setAttribute("size", fsize);
//		request.setAttribute("memberList", memList);
//		request.setAttribute("FriendList", friendList);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
