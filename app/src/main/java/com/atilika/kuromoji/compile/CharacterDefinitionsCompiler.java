package com.atilika.kuromoji.compile;

import com.atilika.kuromoji.io.IntegerArrayIO;
import com.atilika.kuromoji.io.StringArrayIO;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class CharacterDefinitionsCompiler implements Compiler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<String, int[]> categoryDefinitions = new TreeMap();
    private List<Set<String>> codepointCategories = new ArrayList(new TreeSet());
    private OutputStream output;

    public CharacterDefinitionsCompiler(OutputStream outputStream) {
        this.output = outputStream;
        for (int i = 0; i < 65536; i++) {
            this.codepointCategories.add(null);
        }
    }

    private void addMapping(int i, String str) {
        Set<String> treeSet = this.codepointCategories.get(i);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            this.codepointCategories.set(i, treeSet);
        }
        treeSet.add(str);
    }

    private List<String> getCategories(String[] strArr) {
        return Arrays.asList(strArr).subList(1, strArr.length);
    }

    private boolean isCategoryEntry(String str) {
        return !str.startsWith("0x");
    }

    private String[] makeCharacterCategorySymbols() {
        Map<String, Integer> mapMakeCharacterCategoryMap = makeCharacterCategoryMap();
        TreeMap treeMap = new TreeMap();
        for (String str : mapMakeCharacterCategoryMap.keySet()) {
            treeMap.put(mapMakeCharacterCategoryMap.get(str), str);
        }
        String[] strArr = new String[treeMap.size()];
        for (Integer num : treeMap.keySet()) {
            strArr[num.intValue()] = (String) treeMap.get(num);
        }
        return strArr;
    }

    private int[][] makeCharacterDefinitions() {
        Map<String, Integer> mapMakeCharacterCategoryMap = makeCharacterCategoryMap();
        int[][] iArr = new int[mapMakeCharacterCategoryMap.size()][];
        for (String str : this.categoryDefinitions.keySet()) {
            iArr[mapMakeCharacterCategoryMap.get(str).intValue()] = this.categoryDefinitions.get(str);
        }
        return iArr;
    }

    private int[][] makeCharacterMappings() {
        Map<String, Integer> mapMakeCharacterCategoryMap = makeCharacterCategoryMap();
        int size = this.codepointCategories.size();
        int[][] iArr = new int[size][];
        for (int i = 0; i < size; i++) {
            Set<String> set = this.codepointCategories.get(i);
            if (set != null) {
                int[] iArr2 = new int[set.size()];
                Iterator<String> it = set.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr2[i2] = mapMakeCharacterCategoryMap.get(it.next()).intValue();
                    i2++;
                }
                iArr[i] = iArr2;
            }
        }
        return iArr;
    }

    private void parseCategory(String str) {
        String[] strArrSplit = str.split("\\s+");
        this.categoryDefinitions.put(strArrSplit[0], new int[]{Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3])});
    }

    private void parseMapping(String str) {
        String[] strArrSplit = str.split("\\s+");
        String str2 = strArrSplit[0];
        List<String> categories = getCategories(strArrSplit);
        if (!str2.contains("..")) {
            addMapping(Integer.decode(str2).intValue(), categories);
            return;
        }
        String[] strArrSplit2 = str2.split("\\.\\.");
        int iIntValue = Integer.decode(strArrSplit2[1]).intValue();
        for (int iIntValue2 = Integer.decode(strArrSplit2[0]).intValue(); iIntValue2 <= iIntValue; iIntValue2++) {
            addMapping(iIntValue2, categories);
        }
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() throws IOException {
        IntegerArrayIO.writeSparseArray2D(this.output, makeCharacterDefinitions());
        IntegerArrayIO.writeSparseArray2D(this.output, makeCharacterMappings());
        StringArrayIO.writeArray(this.output, makeCharacterCategorySymbols());
        this.output.close();
    }

    public Map<String, int[]> getCategoryDefinitions() {
        return this.categoryDefinitions;
    }

    public List<Set<String>> getCodepointCategories() {
        return this.codepointCategories;
    }

    public Map<String, Integer> makeCharacterCategoryMap() {
        TreeMap treeMap = new TreeMap();
        Iterator<String> it = this.categoryDefinitions.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            treeMap.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return treeMap;
    }

    public void readCharacterDefinition(InputStream inputStream, String str) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, str));
        while (true) {
            String line = lineNumberReader.readLine();
            if (line == null) {
                return;
            }
            String strReplaceAll = line.replaceAll("\\s*#.*", "");
            if (!strReplaceAll.isEmpty()) {
                if (isCategoryEntry(strReplaceAll)) {
                    parseCategory(strReplaceAll);
                } else {
                    parseMapping(strReplaceAll);
                }
            }
        }
    }

    private void addMapping(int i, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            addMapping(i, it.next());
        }
    }
}
