package com.atilika.kuromoji.dict;

import com.atilika.kuromoji.util.StringUtils;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class InsertedDictionary implements Dictionary {
    private static final String DEFAULT_FEATURE = "*";
    private static final String FEATURE_SEPARATOR = ",";
    private final String[] featuresArray;
    private final String featuresString;

    public InsertedDictionary(int i) {
        this.featuresArray = new String[i];
        int i2 = 0;
        while (true) {
            String[] strArr = this.featuresArray;
            if (i2 >= i) {
                this.featuresString = StringUtils.join(strArr, FEATURE_SEPARATOR);
                return;
            } else {
                strArr[i2] = DEFAULT_FEATURE;
                i2++;
            }
        }
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getAllFeatures(int i) {
        return this.featuresString;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String[] getAllFeaturesArray(int i) {
        return this.featuresArray;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public String getFeature(int i, int... iArr) {
        int length = iArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = DEFAULT_FEATURE;
        }
        return StringUtils.join(strArr, FEATURE_SEPARATOR);
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getLeftId(int i) {
        return 0;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getRightId(int i) {
        return 0;
    }

    @Override // com.atilika.kuromoji.dict.Dictionary
    public int getWordCost(int i) {
        return 0;
    }
}
