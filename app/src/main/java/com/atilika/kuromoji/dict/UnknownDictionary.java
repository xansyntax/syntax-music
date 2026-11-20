package com.atilika.kuromoji.dict;

import com.atilika.kuromoji.io.IntegerArrayIO;
import com.atilika.kuromoji.io.StringArrayIO;
import com.atilika.kuromoji.util.ResourceResolver;
import com.atilika.kuromoji.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class UnknownDictionary implements Dictionary {
    private static final String DEFAULT_FEATURE = "*";
    private static final String FEATURE_SEPARATOR = ",";
    public static final String UNKNOWN_DICTIONARY_FILENAME = "unknownDictionary.bin";
    private final CharacterDefinitions characterDefinition;
    private final int[][] costs;
    private final int[][] entries;
    private final String[][] features;
    private final int totalFeatures;

    public UnknownDictionary(CharacterDefinitions characterDefinitions, int[][] iArr, int[][] iArr2, String[][] strArr, int i) {
        this.characterDefinition = characterDefinitions;
        this.entries = iArr;
        this.costs = iArr2;
        this.features = strArr;
        this.totalFeatures = i;
    }

    public static UnknownDictionary newInstance(ResourceResolver resourceResolver, CharacterDefinitions characterDefinitions, int i) throws IOException {
        InputStream inputStreamResolve = resourceResolver.resolve(UNKNOWN_DICTIONARY_FILENAME);
        return new UnknownDictionary(characterDefinitions, IntegerArrayIO.readArray2D(inputStreamResolve), IntegerArrayIO.readArray2D(inputStreamResolve), StringArrayIO.readArray2D(inputStreamResolve), i);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getAllFeatures(int i) {
        return StringUtils.join(getAllFeaturesArray(i), FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String[] getAllFeaturesArray(int i) {
        int i2 = this.totalFeatures;
        String[][] strArr = this.features;
        if (i2 == strArr.length) {
            return strArr[i];
        }
        String[] strArr2 = new String[i2];
        String[] strArr3 = strArr[i];
        for (int i3 = 0; i3 < strArr3.length; i3++) {
            strArr2[i3] = strArr3[i3];
        }
        for (int length = strArr3.length; length < this.totalFeatures; length++) {
            strArr2[length] = DEFAULT_FEATURE;
        }
        return strArr2;
    }

    public CharacterDefinitions getCharacterDefinition() {
        return this.characterDefinition;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getFeature(int i, int... iArr) {
        String[] allFeaturesArray = getAllFeaturesArray(i);
        String[] strArr = new String[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            strArr[i2] = allFeaturesArray[iArr[i2]];
        }
        return StringUtils.join(strArr, FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getLeftId(int i) {
        return this.costs[i][0];
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getRightId(int i) {
        return this.costs[i][1];
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getWordCost(int i) {
        return this.costs[i][2];
    }

    public int[] lookupWordIds(int i) {
        return this.entries[i];
    }

    public UnknownDictionary(CharacterDefinitions characterDefinitions, int[][] iArr, int[][] iArr2, String[][] strArr) {
        this(characterDefinitions, iArr, iArr2, strArr, strArr.length);
    }
}
