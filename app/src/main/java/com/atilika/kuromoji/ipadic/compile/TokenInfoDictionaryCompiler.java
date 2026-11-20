package com.atilika.kuromoji.ipadic.compile;

import com.atilika.kuromoji.compile.TokenInfoDictionaryCompilerBase;
import com.atilika.kuromoji.dict.GenericDictionaryEntry;
import com.atilika.kuromoji.util.DictionaryEntryLineParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TokenInfoDictionaryCompiler extends TokenInfoDictionaryCompilerBase<DictionaryEntry> {
    public TokenInfoDictionaryCompiler(String str) {
        super(str);
    }

    public List<String> extractOtherFeatures(DictionaryEntry dictionaryEntry) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dictionaryEntry.getBaseForm());
        arrayList.add(dictionaryEntry.getReading());
        arrayList.add(dictionaryEntry.getPronunciation());
        return arrayList;
    }

    public List<String> extractPosFeatures(DictionaryEntry dictionaryEntry) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dictionaryEntry.getPartOfSpeechLevel1());
        arrayList.add(dictionaryEntry.getPartOfSpeechLevel2());
        arrayList.add(dictionaryEntry.getPartOfSpeechLevel3());
        arrayList.add(dictionaryEntry.getPartOfSpeechLevel4());
        arrayList.add(dictionaryEntry.getConjugationType());
        arrayList.add(dictionaryEntry.getConjugatedForm());
        return arrayList;
    }

    @Override // com.atilika.kuromoji.compile.TokenInfoDictionaryCompilerBase
    public GenericDictionaryEntry generateGenericDictionaryEntry(DictionaryEntry dictionaryEntry) {
        List<String> listExtractPosFeatures = extractPosFeatures(dictionaryEntry);
        return new GenericDictionaryEntry.Builder().surface(dictionaryEntry.getSurface()).leftId(dictionaryEntry.getLeftId()).rightId(dictionaryEntry.getRightId()).wordCost(dictionaryEntry.getWordCost()).pos(listExtractPosFeatures).features(extractOtherFeatures(dictionaryEntry)).build();
    }

    @Override // com.atilika.kuromoji.compile.TokenInfoDictionaryCompilerBase
    public DictionaryEntry parse(String str) {
        return new DictionaryEntry(DictionaryEntryLineParser.parseLine(str));
    }
}
