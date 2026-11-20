package com.atilika.kuromoji.util;

import com.atilika.kuromoji.dict.GenericDictionaryEntry;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class UnknownDictionaryEntryParser extends DictionaryEntryLineParser {
    public GenericDictionaryEntry parse(String str) {
        String[] line = DictionaryEntryLineParser.parseLine(str);
        String str2 = line[0];
        short s = Short.parseShort(line[1]);
        short s2 = Short.parseShort(line[2]);
        short s3 = Short.parseShort(line[3]);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(line).subList(4, 10));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList(line).subList(10, line.length));
        return new GenericDictionaryEntry.Builder().surface(str2).leftId(s).rightId(s2).wordCost(s3).pos(arrayList).features(arrayList2).build();
    }
}
