import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class DNSEntry implements Comparable{
    private List<String> entry;

    DNSEntry(List<String> entry){
        this.entry = entry;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<entry.size(); i++){
            builder.append(entry.get(i));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Object o) {
        return entry.get(0).compareTo(o.toString());
    }
}
