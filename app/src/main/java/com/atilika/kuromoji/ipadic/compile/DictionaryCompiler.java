package com.atilika.kuromoji.ipadic.compile;

import com.atilika.kuromoji.compile.DictionaryCompilerBase;
import com.atilika.kuromoji.compile.TokenInfoDictionaryCompilerBase;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DictionaryCompiler extends DictionaryCompilerBase {
    public static void main(String[] strArr) throws IOException {
        new DictionaryCompiler().build(strArr);
    }

    @Override // com.atilika.kuromoji.compile.DictionaryCompilerBase
    public TokenInfoDictionaryCompilerBase getTokenInfoDictionaryCompiler(String str) {
        return new TokenInfoDictionaryCompiler(str);
    }
}
