
import java.lang.reflect.Method;
import java.util.HashMap;


public class ParseMap<G> {

	public HashMap<String, String> parseMap(G item) {
		HashMap<String, String> map = new HashMap<String, String>();
		Method[] methods = item.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if (!"void".equals(methods[i].getReturnType().toString())) {
				try {
					StringBuilder build = new StringBuilder(methods[i].getName().toLowerCase());
					if (!build.toString().equals("tostring")) {
						build.delete(0, 3);
						Object ob = methods[i].invoke(item);
						map.put(build.toString(), ob.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public void putVO(HashMap<String, String> item, G vo) {
		try {
			Object[] k = item.keySet().toArray();

			Method[] methods2 = vo.getClass().getDeclaredMethods();

			for (int i = 0; i < methods2.length; i++) {
				if ("void".equals(methods2[i].getReturnType().toString())) {
					String name = methods2[i].getName().toLowerCase();
					StringBuilder build = new StringBuilder(name);

					if ("set".equals(build.substring(0, 3).toString())) {
						name = new StringBuilder(name).delete(0, 3).toString();
						try {
							for (int v = 0; v < k.length; v++) {
								if (name.equals(k[v])) {

									String type = methods2[i].getParameterTypes()[0].getTypeName();
									switch (type) {
									case "int":
										methods2[i].invoke(vo, Integer.parseInt(item.get(k[v])));
										break;

									case "boolean":
										methods2[i].invoke(vo, Boolean.parseBoolean(item.get(k[v])));
										break;
									case "java.lang.String":
										methods2[i].invoke(vo, (String) item.get(k[v]));
										break;

									}
									break;
								}
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
