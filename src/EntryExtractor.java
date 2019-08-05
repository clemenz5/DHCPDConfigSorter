import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class EntryExtractor {
    private File configFile;

    EntryExtractor(File configFile) {
        this.configFile = configFile;
    }

    List<DNSEntry> extractEntries() {
        List<DNSEntry> entries = new LinkedList<>();
        try {
            FileReader reader = new FileReader(configFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> lineList = new LinkedList<>();
            bufferedReader.lines().forEach(line -> lineList.add(line));


            for (int lineIndex = 0; lineIndex < lineList.size(); lineIndex++) {
                if (lineList.get(lineIndex).contains("{")) {
                    int entrySize = 0;
                    while (!lineList.get(lineIndex + entrySize).contains("}")) {
                        entrySize++;
                    }
                    entries.add(new DNSEntry(lineList.subList(lineIndex, lineIndex + entrySize+1)));
                    lineIndex = lineIndex + entrySize;
                }
            }
            return entries;
        } catch (IOException e) {
            return null;
        }
    }
}
