package com.atilika.kuromoji.compile;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.buffer.BufferEntry;
import com.atilika.kuromoji.buffer.FeatureInfoMap;
import com.atilika.kuromoji.buffer.StringValueMapBuffer;
import com.atilika.kuromoji.buffer.WordIdMap;
import com.atilika.kuromoji.dict.DictionaryEntryBase;
import com.atilika.kuromoji.dict.GenericDictionaryEntry;
import com.atilika.kuromoji.dict.TokenInfoDictionary;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TokenInfoDictionaryCompilerBase<T extends DictionaryEntryBase> implements Compiler {
    private String encoding;
    protected List<BufferEntry> bufferEntries = new ArrayList();
    protected FeatureInfoMap posInfo = new FeatureInfoMap();
    protected FeatureInfoMap otherInfo = new FeatureInfoMap();
    protected WordIdMapCompiler wordIdsCompiler = new WordIdMapCompiler();
    protected List<GenericDictionaryEntry> dictionaryEntries = null;
    private List<String> surfaces = new ArrayList();

    public TokenInfoDictionaryCompilerBase(String str) {
        this.encoding = str;
    }

    private List<Byte> createPosFeatureIds(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(it.next().byteValue()));
        }
        return arrayList;
    }

    private boolean entriesFitInAByte(int i) {
        return i <= 255;
    }

    public void addMapping(int i, int i2) {
        this.wordIdsCompiler.addMapping(i, i2);
    }

    public void analyzeTokenInfo(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, this.encoding));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            this.posInfo.mapFeatures(generateGenericDictionaryEntry(parse(line)).getPosFeatures());
        }
    }

    public InputStream combinedSequentialFileInputStream(File file) {
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = getCsvFiles(file).iterator();
        while (it.hasNext()) {
            arrayList.add(new FileInputStream(it.next()));
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public abstract GenericDictionaryEntry generateGenericDictionaryEntry(T t);

    @Deprecated
    public List<BufferEntry> getBufferEntries() {
        return this.bufferEntries;
    }

    public List<File> getCsvFiles(File file) {
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.atilika.kuromoji.compile.TokenInfoDictionaryCompilerBase.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(".csv");
            }
        };
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, file.listFiles(filenameFilter));
        Collections.sort(arrayList);
        return arrayList;
    }

    @Deprecated
    public List<GenericDictionaryEntry> getDictionaryEntries() {
        return this.dictionaryEntries;
    }

    public List<String> getSurfaces() {
        return this.surfaces;
    }

    @Deprecated
    public WordIdMap getWordIdMap() throws IOException {
        File fileCreateTempFile = File.createTempFile("kuromoji-wordid-", ".bin");
        fileCreateTempFile.deleteOnExit();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
        this.wordIdsCompiler.write(bufferedOutputStream);
        bufferedOutputStream.close();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileCreateTempFile));
        WordIdMap wordIdMap = new WordIdMap(bufferedInputStream);
        bufferedInputStream.close();
        return wordIdMap;
    }

    public abstract T parse(String str);

    public void readTokenInfo(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, this.encoding));
        int entryCount = this.posInfo.getEntryCount();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            GenericDictionaryEntry genericDictionaryEntryGenerateGenericDictionaryEntry = generateGenericDictionaryEntry(parse(line));
            short leftId = genericDictionaryEntryGenerateGenericDictionaryEntry.getLeftId();
            short rightId = genericDictionaryEntryGenerateGenericDictionaryEntry.getRightId();
            short wordCost = genericDictionaryEntryGenerateGenericDictionaryEntry.getWordCost();
            List<Integer> listMapFeatures = this.posInfo.mapFeatures(genericDictionaryEntryGenerateGenericDictionaryEntry.getPosFeatures());
            List<Integer> listMapFeatures2 = this.otherInfo.mapFeatures(genericDictionaryEntryGenerateGenericDictionaryEntry.getFeatures());
            BufferEntry bufferEntry = new BufferEntry();
            bufferEntry.tokenInfo.add(Short.valueOf(leftId));
            bufferEntry.tokenInfo.add(Short.valueOf(rightId));
            bufferEntry.tokenInfo.add(Short.valueOf(wordCost));
            if (entriesFitInAByte(entryCount)) {
                bufferEntry.posInfo.addAll(createPosFeatureIds(listMapFeatures));
            } else {
                Iterator<Integer> it = listMapFeatures.iterator();
                while (it.hasNext()) {
                    bufferEntry.tokenInfo.add(Short.valueOf(it.next().shortValue()));
                }
            }
            bufferEntry.features.addAll(listMapFeatures2);
            this.bufferEntries.add(bufferEntry);
            this.surfaces.add(genericDictionaryEntryGenerateGenericDictionaryEntry.getSurface());
            List<GenericDictionaryEntry> list = this.dictionaryEntries;
            if (list != null) {
                list.add(genericDictionaryEntryGenerateGenericDictionaryEntry);
            }
        }
    }

    @Deprecated
    public void setDictionaryEntries(List<GenericDictionaryEntry> list) {
        this.dictionaryEntries = list;
    }

    public void write(String str) throws IOException {
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m(str);
        String str2 = File.separator;
        sbM.append(str2);
        sbM.append(TokenInfoDictionary.TOKEN_INFO_DICTIONARY_FILENAME);
        writeDictionary(sbM.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        writeMap(IntIntPair$$ExternalSyntheticOutline0.m(sb, str2, TokenInfoDictionary.POS_MAP_FILENAME), this.posInfo);
        writeMap(str + str2 + TokenInfoDictionary.FEATURE_MAP_FILENAME, this.otherInfo);
        writeWordIds(str + str2 + TokenInfoDictionary.TARGETMAP_FILENAME);
    }

    public void writeDictionary(String str) throws IOException {
        new TokenInfoBufferCompiler(new FileOutputStream(str), this.bufferEntries).compile();
    }

    public void writeMap(String str, FeatureInfoMap featureInfoMap) throws IOException {
        new StringValueMapBuffer(featureInfoMap.invert()).write(new FileOutputStream(str));
    }

    public void writeWordIds(String str) throws IOException {
        this.wordIdsCompiler.write(new FileOutputStream(str));
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() {
    }
}
