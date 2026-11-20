package com.atilika.kuromoji.compile;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.dict.CharacterDefinitions;
import com.atilika.kuromoji.dict.ConnectionCosts;
import com.atilika.kuromoji.dict.UnknownDictionary;
import com.atilika.kuromoji.trie.DoubleArrayTrie;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DictionaryCompilerBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private void buildConnectionCosts(String str, String str2) throws IOException {
        ProgressLog.begin("compiling connection costs");
        ConnectionCostsCompiler connectionCostsCompiler = new ConnectionCostsCompiler(new FileOutputStream(new File(str2, ConnectionCosts.CONNECTION_COSTS_FILENAME)));
        connectionCostsCompiler.readCosts(new FileInputStream(new File(str, "matrix.def")));
        connectionCostsCompiler.compile();
        ProgressLog.end();
    }

    private void buildTokenInfoDictionary(String str, String str2, String str3, boolean z) throws IOException {
        ProgressLog.begin("compiling tokeninfo dict");
        TokenInfoDictionaryCompilerBase tokenInfoDictionaryCompiler = getTokenInfoDictionaryCompiler(str3);
        ProgressLog.println("analyzing dictionary features");
        tokenInfoDictionaryCompiler.analyzeTokenInfo(tokenInfoDictionaryCompiler.combinedSequentialFileInputStream(new File(str)));
        ProgressLog.println("reading tokeninfo");
        tokenInfoDictionaryCompiler.readTokenInfo(tokenInfoDictionaryCompiler.combinedSequentialFileInputStream(new File(str)));
        tokenInfoDictionaryCompiler.compile();
        List<String> surfaces = tokenInfoDictionaryCompiler.getSurfaces();
        ProgressLog.begin("compiling double array trie");
        DoubleArrayTrie doubleArrayTrieBuild = DoubleArrayTrieCompiler.build(surfaces, z);
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m(str2);
        String str4 = File.separator;
        FileOutputStream fileOutputStream = new FileOutputStream(IntIntPair$$ExternalSyntheticOutline0.m(sbM, str4, DoubleArrayTrie.DOUBLE_ARRAY_TRIE_FILENAME));
        doubleArrayTrieBuild.write(fileOutputStream);
        fileOutputStream.close();
        try {
            ProgressLog.println("validating saved double array trie");
            DoubleArrayTrie doubleArrayTrie = DoubleArrayTrie.read(new FileInputStream(str2 + str4 + DoubleArrayTrie.DOUBLE_ARRAY_TRIE_FILENAME));
            for (String str5 : surfaces) {
                if (doubleArrayTrie.lookup(str5) < 0) {
                    ProgressLog.println("failed to look up [" + str5 + "]");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProgressLog.end();
        ProgressLog.begin("processing target map");
        for (int i = 0; i < surfaces.size(); i++) {
            tokenInfoDictionaryCompiler.addMapping(doubleArrayTrieBuild.lookup(surfaces.get(i)), i);
        }
        tokenInfoDictionaryCompiler.write(str2);
        ProgressLog.end();
        ProgressLog.end();
    }

    public void build(String[] strArr) throws IOException {
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        boolean z = Boolean.parseBoolean(strArr[3]);
        ProgressLog.println("dictionary compiler");
        ProgressLog.println("");
        ProgressLog.println("input directory: " + str);
        ProgressLog.println("output directory: " + str2);
        ProgressLog.println("input encoding: " + str3);
        ProgressLog.println("compact tries: " + z);
        ProgressLog.println("");
        build(str, str2, str3, z);
    }

    public void buildUnknownWordDictionary(String str, String str2, String str3) throws IOException {
        ProgressLog.begin("compiling unknown word dict");
        CharacterDefinitionsCompiler characterDefinitionsCompiler = new CharacterDefinitionsCompiler(new BufferedOutputStream(new FileOutputStream(new File(str2, CharacterDefinitions.CHARACTER_DEFINITIONS_FILENAME))));
        characterDefinitionsCompiler.readCharacterDefinition(new BufferedInputStream(new FileInputStream(new File(str, "char.def"))), str3);
        characterDefinitionsCompiler.compile();
        UnknownDictionaryCompiler unknownDictionaryCompiler = new UnknownDictionaryCompiler(characterDefinitionsCompiler.makeCharacterCategoryMap(), new FileOutputStream(new File(str2, UnknownDictionary.UNKNOWN_DICTIONARY_FILENAME)));
        unknownDictionaryCompiler.readUnknownDefinition(new BufferedInputStream(new FileInputStream(new File(str, "unk.def"))), str3);
        unknownDictionaryCompiler.compile();
        ProgressLog.end();
    }

    public abstract TokenInfoDictionaryCompilerBase getTokenInfoDictionaryCompiler(String str);

    public void build(String str, String str2, String str3, boolean z) throws IOException {
        new File(str2).mkdirs();
        buildTokenInfoDictionary(str, str2, str3, z);
        buildUnknownWordDictionary(str, str2, str3);
        buildConnectionCosts(str, str2);
    }
}
