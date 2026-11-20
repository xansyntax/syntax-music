package com.atilika.kuromoji.compile;

import com.atilika.kuromoji.dict.GenericDictionaryEntry;
import com.atilika.kuromoji.io.IntegerArrayIO;
import com.atilika.kuromoji.io.StringArrayIO;
import com.atilika.kuromoji.util.UnknownDictionaryEntryParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class UnknownDictionaryCompiler implements Compiler {
    protected Map<String, Integer> categoryMap;
    protected List<GenericDictionaryEntry> dictionaryEntries = new ArrayList();
    private OutputStream output;

    public UnknownDictionaryCompiler(Map<String, Integer> map, OutputStream outputStream) {
        this.categoryMap = map;
        this.output = outputStream;
    }

    private int[] toArray(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() throws IOException {
        IntegerArrayIO.writeArray2D(this.output, makeCosts());
        IntegerArrayIO.writeArray2D(this.output, makeCategoryReferences());
        StringArrayIO.writeArray2D(this.output, makeFeatures());
        this.output.close();
    }

    public List<GenericDictionaryEntry> getDictionaryEntries() {
        return this.dictionaryEntries;
    }

    public int[] getEntryIndices(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dictionaryEntries.size(); i++) {
            if (this.dictionaryEntries.get(i).getSurface().equals(str)) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return toArray(arrayList);
    }

    public int[][] makeCategoryReferences() {
        int[][] iArr = new int[this.categoryMap.size()][];
        for (String str : this.categoryMap.keySet()) {
            iArr[this.categoryMap.get(str).intValue()] = getEntryIndices(str);
        }
        return iArr;
    }

    public int[][] makeCosts() {
        int[][] iArr = new int[this.dictionaryEntries.size()][];
        for (int i = 0; i < this.dictionaryEntries.size(); i++) {
            GenericDictionaryEntry genericDictionaryEntry = this.dictionaryEntries.get(i);
            iArr[i] = new int[]{genericDictionaryEntry.getLeftId(), genericDictionaryEntry.getRightId(), genericDictionaryEntry.getWordCost()};
        }
        return iArr;
    }

    public String[][] makeFeatures() {
        String[][] strArr = new String[this.dictionaryEntries.size()][];
        for (int i = 0; i < this.dictionaryEntries.size(); i++) {
            GenericDictionaryEntry genericDictionaryEntry = this.dictionaryEntries.get(i);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(genericDictionaryEntry.getPosFeatures());
            arrayList.addAll(genericDictionaryEntry.getFeatures());
            strArr[i] = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return strArr;
    }

    public void printFeatures(String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(i);
            for (String str : strArr[i]) {
                System.out.println("\t" + str);
            }
        }
    }

    public void readUnknownDefinition(InputStream inputStream, String str) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, str));
        UnknownDictionaryEntryParser unknownDictionaryEntryParser = new UnknownDictionaryEntryParser();
        while (true) {
            String line = lineNumberReader.readLine();
            if (line == null) {
                return;
            }
            this.dictionaryEntries.add(unknownDictionaryEntryParser.parse(line));
        }
    }
}
