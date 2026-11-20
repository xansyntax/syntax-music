package com.atilika.kuromoji.dict;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.io.IntegerArrayIO;
import com.atilika.kuromoji.io.StringArrayIO;
import com.atilika.kuromoji.util.ResourceResolver;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CharacterDefinitions {
    public static final String CHARACTER_DEFINITIONS_FILENAME = "characterDefinitions.bin";
    private static final String DEFAULT_CATEGORY = "DEFAULT";
    public static final int GROUP = 1;
    public static final int INVOKE = 0;
    private static final int LENGTH = 2;
    private final int[][] categoryDefinitions;
    private final String[] categorySymbols;
    private final int[][] codepointMappings;
    private final int[] defaultCategory = lookupCategories(new String[]{DEFAULT_CATEGORY});

    public CharacterDefinitions(int[][] iArr, int[][] iArr2, String[] strArr) {
        this.categoryDefinitions = iArr;
        this.codepointMappings = iArr2;
        this.categorySymbols = strArr;
    }

    private int[] lookupCategories(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            int i2 = -1;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.categorySymbols;
                if (i3 >= strArr2.length) {
                    break;
                }
                if (str.equals(strArr2[i3])) {
                    i2 = i3;
                }
                i3++;
            }
            if (i2 < 0) {
                throw new RuntimeException(IntIntPair$$ExternalSyntheticOutline0.m("No category '", str, "' found"));
            }
            iArr[i] = i2;
        }
        return iArr;
    }

    public static CharacterDefinitions newInstance(ResourceResolver resourceResolver) {
        InputStream inputStreamResolve = resourceResolver.resolve(CHARACTER_DEFINITIONS_FILENAME);
        return new CharacterDefinitions(IntegerArrayIO.readSparseArray2D(inputStreamResolve), IntegerArrayIO.readSparseArray2D(inputStreamResolve), StringArrayIO.readArray(inputStreamResolve));
    }

    public int[] lookupDefinition(int i) {
        return this.categoryDefinitions[i];
    }

    public void setCategories(char c, String[] strArr) {
        this.codepointMappings[c] = lookupCategories(strArr);
    }

    public int[] lookupCategories(char c) {
        int[] iArr = this.codepointMappings[c];
        return iArr == null ? this.defaultCategory : iArr;
    }
}
