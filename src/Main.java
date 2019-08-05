import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntryExtractor extractor = new EntryExtractor(new File("C:\\Users\\Loren\\Desktop\\dhcptestconf.txt"));
        List<DNSEntry> dnsEntries = extractor.extractEntries();

        dnsEntries.sort(Comparator.naturalOrder());

        for(int entryIndex = 0; entryIndex<dnsEntries.size(); entryIndex++){
            System.out.println(dnsEntries.get(entryIndex).toString());
        }
    }
}
