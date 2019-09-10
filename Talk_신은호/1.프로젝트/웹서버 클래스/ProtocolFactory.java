import java.util.ArrayList;
import java.util.HashMap;

public class ProtocolFactory {
	private StringBuilder protocol;
	private int count = 0;

	public ProtocolFactory() {
		protocol = new StringBuilder("{");
	}

	public ProtocolFactory(int protocol1) {
		protocol = new StringBuilder("{ \"protocol\" : \"" + protocol1 + "\" ");
	}

	public ProtocolFactory addObj(String key, String value) {
	
			protocol.append(",\"" + key + "\":\"" + value + "\"");
		
		return this;
	}

	public ProtocolFactory addObj(String key, HashMap<String, String> map) {
		Object[] k = map.keySet().toArray();
			protocol.append(",\""+key+"\" : {");
		for (int i = 0; i < k.length; i++) {
			switch (i) {
			case 0:
				protocol.append("\"" + k[i] + "\" : \"" + map.get(k[i]) + "\"");
				;
				break;

			default:
				protocol.append(",\"" + k[i] + "\" : \"" + map.get(k[i]) + "\"");
				break;

			}
		}
		protocol.append("}");
		return this;
	}

	public ProtocolFactory addArr(String key, ArrayList<HashMap<String, String>> map1) {
		protocol.append(",\"" + key + "\":[");
		int i2 = 0;
		for (HashMap<String, String> map : map1) {
			Object[] k = map.keySet().toArray();
			switch (i2) {

			case 0:
				protocol.append("{");
				++i2;
				break;

			default:
				protocol.append(",{");
				break;

			}
			for (int i = 0; i < k.length; i++) {
				switch (i) {
				case 0:
					protocol.append("\"" + k[i] + "\" : \"" + map.get(k[i]) + "\"");
					;
					break;

				default:
					protocol.append(",\"" + k[i] + "\" : \"" + map.get(k[i]) + "\"");
					break;

				}
			}
			protocol.append("}");
		}
		protocol.append("]");
		return this;
	}

	@Override
	public String toString() {

		protocol.append("}");
		return protocol.toString();
	}

//	public static void main(String[] args) throws Exception {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("name", "");
//		map.put("age", "21");
//		map.put("favrit", "");
//
//		ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();
//		arr.add(map);
//		String msg = new ProtocolFactory(1999).addArr("uservo", arr).toString();
//
//		JSONObject ob = (JSONObject) new JSONParser().parse(msg);
//		JSONArray arr2 = (JSONArray) ob.get("uservo");
//		for (int i = 0; i < arr2.size(); i++) {
//			JSONObject ob2 = (JSONObject) arr2.get(i);
//			Object[] arrob = ob2.keySet().toArray();
//			for (Object sob : arrob) {
//				System.out.print(sob + " : " + ob2.get(sob).toString() + " ");
//			}
//			System.out.println();
//		}
//	}

}
