package com.atilika.kuromoji.ipadic.compile;

import com.atilika.kuromoji.dict.DictionaryEntryBase;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DictionaryEntry extends DictionaryEntryBase {
    public static final int BASE_FORM = 10;
    public static final int CONJUGATION_FORM = 9;
    public static final int CONJUGATION_TYPE = 8;
    public static final int PART_OF_SPEECH_FEATURE = 0;
    public static final int PART_OF_SPEECH_LEVEL_1 = 4;
    public static final int PART_OF_SPEECH_LEVEL_2 = 5;
    public static final int PART_OF_SPEECH_LEVEL_3 = 6;
    public static final int PART_OF_SPEECH_LEVEL_4 = 7;
    public static final int PRONUNCIATION = 12;
    public static final int READING = 11;
    public static final int READING_FEATURE = 7;
    public static final int TOTAL_FEATURES = 9;
    private final String baseForm;
    private final String conjugatedForm;
    private final String conjugationType;
    private final String posLevel1;
    private final String posLevel2;
    private final String posLevel3;
    private final String posLevel4;
    private final String pronunciation;
    private final String reading;

    public DictionaryEntry(String[] strArr) {
        super(strArr[0], Short.parseShort(strArr[1]), Short.parseShort(strArr[2]), Short.parseShort(strArr[3]));
        this.posLevel1 = strArr[4];
        this.posLevel2 = strArr[5];
        this.posLevel3 = strArr[6];
        this.posLevel4 = strArr[7];
        this.conjugationType = strArr[8];
        this.conjugatedForm = strArr[9];
        this.baseForm = strArr[10];
        this.reading = strArr[11];
        this.pronunciation = strArr[12];
    }

    public String getBaseForm() {
        return this.baseForm;
    }

    public String getConjugatedForm() {
        return this.conjugatedForm;
    }

    public String getConjugationType() {
        return this.conjugationType;
    }

    public String getPartOfSpeechLevel1() {
        return this.posLevel1;
    }

    public String getPartOfSpeechLevel2() {
        return this.posLevel2;
    }

    public String getPartOfSpeechLevel3() {
        return this.posLevel3;
    }

    public String getPartOfSpeechLevel4() {
        return this.posLevel4;
    }

    public String getPronunciation() {
        return this.pronunciation;
    }

    public String getReading() {
        return this.reading;
    }
}
