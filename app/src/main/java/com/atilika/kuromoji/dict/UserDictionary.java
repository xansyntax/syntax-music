package com.atilika.kuromoji.dict;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.trie.PatriciaTrie;
import com.atilika.kuromoji.util.DictionaryEntryLineParser;
import com.atilika.kuromoji.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class UserDictionary implements Dictionary {
    private static final int CUSTOM_DICTIONARY_WORD_ID_OFFSET = 100000000;
    private static final String DEFAULT_FEATURE = "*";
    private static final String FEATURE_SEPARATOR = ",";
    private static final int LEFT_ID = 5;
    private static final int RIGHT_ID = 5;
    private static final int WORD_COST = -100000;
    private final int partOfSpeechFeature;
    private final int readingFeature;
    private final int totalFeatures;
    private int wordId = CUSTOM_DICTIONARY_WORD_ID_OFFSET;
    private PatriciaTrie<int[]> entries = new PatriciaTrie<>();
    private Map<Integer, String> readings = new HashMap();
    private Map<Integer, String> partOfSpeech = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class UserDictionaryMatch {
        private final int matchLength;
        private final int matchStartIndex;
        private final int wordId;

        public UserDictionaryMatch(int i, int i2, int i3) {
            this.wordId = i;
            this.matchStartIndex = i2;
            this.matchLength = i3;
        }

        public int getMatchLength() {
            return this.matchLength;
        }

        public int getMatchStartIndex() {
            return this.matchStartIndex;
        }

        public int getWordId() {
            return this.wordId;
        }
    }

    public UserDictionary(InputStream inputStream, int i, int i2, int i3) throws IOException {
        this.totalFeatures = i;
        this.readingFeature = i2;
        this.partOfSpeechFeature = i3;
        read(inputStream);
    }

    private boolean isCustomSegmentation(String str, String str2) {
        return !str.equals(str2);
    }

    private List<UserDictionaryMatch> makeMatchDetails(int i, int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length - 1);
        int i2 = 0;
        int i3 = iArr[0];
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            arrayList.add(new UserDictionaryMatch(i3, i + i2, i5));
            i2 += i5;
            i3++;
        }
        return arrayList;
    }

    private String[] split(String str) {
        return str.split("\\s+");
    }

    public void addEntry(String str) {
        String[] strArrSplit;
        String[] strArrSplit2;
        String[] line = DictionaryEntryLineParser.parseLine(str);
        int i = 0;
        String str2 = line[0];
        String str3 = line[1];
        String str4 = line[2];
        String str5 = line[3];
        if (isCustomSegmentation(str2, str3)) {
            strArrSplit2 = split(str3);
            strArrSplit = split(str4);
        } else {
            strArrSplit = new String[]{str4};
            strArrSplit2 = new String[]{str3};
        }
        if (strArrSplit2.length != strArrSplit.length) {
            throw new RuntimeException(Fragment$5$$ExternalSyntheticOutline0.m("User dictionary entry not properly formatted: ", str));
        }
        int[] iArr = new int[strArrSplit2.length + 1];
        iArr[0] = this.wordId;
        while (i < strArrSplit2.length) {
            int i2 = i + 1;
            iArr[i2] = strArrSplit2[i].length();
            this.readings.put(Integer.valueOf(this.wordId), strArrSplit[i]);
            this.partOfSpeech.put(Integer.valueOf(this.wordId), str5);
            this.wordId++;
            i = i2;
        }
        this.entries.put(str2, iArr);
    }

    public List<UserDictionaryMatch> findUserDictionaryMatches(String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < str.length(); i2++) {
            int i3 = 0;
            while (true) {
                i = i2 + i3;
                if (i >= str.length() || !this.entries.containsKeyPrefix(str.substring(i2, i + 1))) {
                    break;
                }
                i3++;
            }
            if (i3 > 0) {
                int[] iArr = this.entries.get(str.substring(i2, i));
                if (iArr != null) {
                    arrayList.addAll(makeMatchDetails(i2, iArr));
                }
            }
        }
        return arrayList;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getAllFeatures(int i) {
        return StringUtils.join(getAllFeaturesArray(i), FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String[] getAllFeaturesArray(int i) {
        String[] strArr = new String[this.totalFeatures];
        for (int i2 = 0; i2 < this.totalFeatures; i2++) {
            strArr[i2] = getFeature(i, i2);
        }
        return strArr;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getFeature(int i, int... iArr) {
        if (iArr.length == 0 || iArr.length == this.totalFeatures) {
            return getAllFeatures(i);
        }
        String[] strArr = new String[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 == this.readingFeature) {
                strArr[i2] = this.readings.get(Integer.valueOf(i));
            } else if (i3 == this.partOfSpeechFeature) {
                strArr[i2] = this.partOfSpeech.get(Integer.valueOf(i));
            } else {
                strArr[i2] = DEFAULT_FEATURE;
            }
        }
        return StringUtils.join(strArr, FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getLeftId(int i) {
        return 5;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getRightId(int i) {
        return 5;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getWordCost(int i) {
        return WORD_COST;
    }

    public void read(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.replaceAll("#.*$", "").trim();
            if (!strTrim.isEmpty()) {
                addEntry(strTrim);
            }
        }
    }
}
