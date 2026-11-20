package com.atilika.kuromoji.dict;

import com.atilika.kuromoji.buffer.BufferEntry;
import com.atilika.kuromoji.buffer.StringValueMapBuffer;
import com.atilika.kuromoji.buffer.TokenInfoBuffer;
import com.atilika.kuromoji.buffer.WordIdMap;
import com.atilika.kuromoji.util.DictionaryEntryLineParser;
import com.atilika.kuromoji.util.ResourceResolver;
import com.atilika.kuromoji.util.StringUtils;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TokenInfoDictionary implements Dictionary {
    public static final String FEATURE_MAP_FILENAME = "tokenInfoFeaturesMap.bin";
    private static final String FEATURE_SEPARATOR = ",";
    private static final int LEFT_ID = 0;
    public static final String POS_MAP_FILENAME = "tokenInfoPartOfSpeechMap.bin";
    private static final int RIGHT_ID = 1;
    public static final String TARGETMAP_FILENAME = "tokenInfoTargetMap.bin";
    public static final String TOKEN_INFO_DICTIONARY_FILENAME = "tokenInfoDictionary.bin";
    private static final int TOKEN_INFO_OFFSET = 3;
    private static final int WORD_COST = 2;
    protected StringValueMapBuffer posValues;
    protected StringValueMapBuffer stringValues;
    protected TokenInfoBuffer tokenInfoBuffer;
    protected WordIdMap wordIdMap;

    private String extractMultipleFeatures(int i, int[] iArr) {
        if (iArr.length == 0) {
            return getAllFeatures(i);
        }
        if (iArr.length == 1) {
            return extractSingleFeature(i, iArr[0]);
        }
        String[] allFeaturesArray = getAllFeaturesArray(i);
        String[] strArr = new String[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            strArr[i2] = DictionaryEntryLineParser.escape(allFeaturesArray[iArr[i2]]);
        }
        return StringUtils.join(strArr, FEATURE_SEPARATOR);
    }

    private String extractSingleFeature(int i, int i2) {
        boolean zIsPartOfSpeechFeature = this.tokenInfoBuffer.isPartOfSpeechFeature(i2);
        TokenInfoBuffer tokenInfoBuffer = this.tokenInfoBuffer;
        if (zIsPartOfSpeechFeature) {
            return this.posValues.get(tokenInfoBuffer.lookupPartOfSpeechFeature(i, i2));
        }
        return this.stringValues.get(tokenInfoBuffer.lookupFeature(i, i2));
    }

    public static TokenInfoDictionary newInstance(ResourceResolver resourceResolver) {
        TokenInfoDictionary tokenInfoDictionary = new TokenInfoDictionary();
        tokenInfoDictionary.setup(resourceResolver);
        return tokenInfoDictionary;
    }

    private void setup(ResourceResolver resourceResolver) {
        this.tokenInfoBuffer = new TokenInfoBuffer(resourceResolver.resolve(TOKEN_INFO_DICTIONARY_FILENAME));
        this.stringValues = new StringValueMapBuffer(resourceResolver.resolve(FEATURE_MAP_FILENAME));
        this.posValues = new StringValueMapBuffer(resourceResolver.resolve(POS_MAP_FILENAME));
        this.wordIdMap = new WordIdMap(resourceResolver.resolve(TARGETMAP_FILENAME));
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getAllFeatures(int i) {
        String[] allFeaturesArray = getAllFeaturesArray(i);
        for (int i2 = 0; i2 < allFeaturesArray.length; i2++) {
            allFeaturesArray[i2] = DictionaryEntryLineParser.escape(allFeaturesArray[i2]);
        }
        return StringUtils.join(allFeaturesArray, FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String[] getAllFeaturesArray(int i) {
        boolean z;
        BufferEntry bufferEntryLookupEntry = this.tokenInfoBuffer.lookupEntry(i);
        int length = bufferEntryLookupEntry.posInfos.length;
        int length2 = bufferEntryLookupEntry.featureInfos.length;
        if (length == 0) {
            length = bufferEntryLookupEntry.tokenInfos.length - 3;
            z = true;
        } else {
            z = false;
        }
        String[] strArr = new String[length + length2];
        if (z) {
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = this.posValues.get(bufferEntryLookupEntry.tokenInfos[i2 + 3]);
            }
        } else {
            for (int i3 = 0; i3 < length; i3++) {
                strArr[i3] = this.posValues.get(bufferEntryLookupEntry.posInfos[i3] & 255);
            }
        }
        for (int i4 = 0; i4 < length2; i4++) {
            strArr[i4 + length] = this.stringValues.get(bufferEntryLookupEntry.featureInfos[i4]);
        }
        return strArr;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getFeature(int i, int... iArr) {
        return iArr.length == 1 ? extractSingleFeature(i, iArr[0]) : extractMultipleFeatures(i, iArr);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getLeftId(int i) {
        return this.tokenInfoBuffer.lookupTokenInfo(i, 0);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getRightId(int i) {
        return this.tokenInfoBuffer.lookupTokenInfo(i, 1);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getWordCost(int i) {
        return this.tokenInfoBuffer.lookupTokenInfo(i, 2);
    }

    public int[] lookupWordIds(int i) {
        return this.wordIdMap.lookUp(i);
    }
}
