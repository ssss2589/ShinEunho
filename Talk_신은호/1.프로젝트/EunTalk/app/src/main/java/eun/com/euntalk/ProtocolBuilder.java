package eun.com.euntalk;

import java.util.ArrayList;
import java.util.HashMap;

public class ProtocolBuilder {
    public static final int JOINGAME = 1001;
    public static final int HOSTGAME = 1002;
    public static final int RESPONSE_GAMELIST = 1003;
    public final static int DAY_LIGHT = 300;
    public final static int DAY_NIGHT = 301;
    public final static int BROAD_CAST = 502;
    public final static int VOTE = 103;
    public final static int SHOOT = 104;
    public final static int HEAL = 105;
    public final static int RESEARCH = 106;
    public final static int SPY_RESEARCH = 107;
    private StringBuilder protocol;
    private int count = 0;

    public ProtocolBuilder() {
        protocol = new StringBuilder("{");
    }

    public ProtocolBuilder(int protocol1) {
        protocol = new StringBuilder("{ \"protocol\" : \"" + protocol1 + "\" ");
    }

    public ProtocolBuilder addObj(String key, String value) {
        switch (count) {
            case 0:
                protocol.append("\"" + key + "\":\"" + value + "\"");
                count = 1;
                break;
            default:
                protocol.append(",\"" + key + "\":\"" + value + "\"");
                break;
        }
        return this;
    }

    public ProtocolBuilder addObj(String key, HashMap<String, String> map) {
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

    public ProtocolBuilder addArr(String key, ArrayList<HashMap<String, String>> map1) {
        protocol.append("\"" + key + "\":[");
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
}
