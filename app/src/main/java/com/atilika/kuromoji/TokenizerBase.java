package com.atilika.kuromoji;

import com.atilika.kuromoji.dict.CharacterDefinitions;
import com.atilika.kuromoji.dict.ConnectionCosts;
import com.atilika.kuromoji.dict.Dictionary;
import com.atilika.kuromoji.dict.InsertedDictionary;
import com.atilika.kuromoji.dict.TokenInfoDictionary;
import com.atilika.kuromoji.dict.UnknownDictionary;
import com.atilika.kuromoji.dict.UserDictionary;
import com.atilika.kuromoji.trie.DoubleArrayTrie;
import com.atilika.kuromoji.util.ResourceResolver;
import com.atilika.kuromoji.viterbi.TokenFactory;
import com.atilika.kuromoji.viterbi.ViterbiBuilder;
import com.atilika.kuromoji.viterbi.ViterbiFormatter;
import com.atilika.kuromoji.viterbi.ViterbiLattice;
import com.atilika.kuromoji.viterbi.ViterbiNode;
import com.atilika.kuromoji.viterbi.ViterbiSearcher;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TokenizerBase {
    protected EnumMap<ViterbiNode.Type, Dictionary> dictionaryMap = new EnumMap<>(ViterbiNode.Type.class);
    private InsertedDictionary insertedDictionary;
    private boolean split;
    protected TokenFactory tokenFactory;
    private TokenInfoDictionary tokenInfoDictionary;
    private UnknownDictionary unknownDictionary;
    private UserDictionary userDictionary;
    private ViterbiBuilder viterbiBuilder;
    private ViterbiFormatter viterbiFormatter;
    private ViterbiSearcher viterbiSearcher;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public enum Mode {
        NORMAL,
        SEARCH,
        EXTENDED
    }

    private <T extends TokenBase> List<T> createTokenList(int i, String str) {
        ArrayList arrayList = new ArrayList();
        for (ViterbiNode viterbiNode : this.viterbiSearcher.search(this.viterbiBuilder.build(str))) {
            int wordId = viterbiNode.getWordId();
            if (viterbiNode.getType() != ViterbiNode.Type.KNOWN || wordId != -1) {
                arrayList.add(this.tokenFactory.createToken(wordId, viterbiNode.getSurface(), viterbiNode.getType(), viterbiNode.getStartIndex() + i, this.dictionaryMap.get(viterbiNode.getType())));
            }
        }
        return arrayList;
    }

    private List<Integer> getSplitPositions(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf("。", i);
            int iIndexOf2 = str.indexOf("、", i);
            int iMax = (iIndexOf < 0 || iIndexOf2 < 0) ? Math.max(iIndexOf, iIndexOf2) : Math.min(iIndexOf, iIndexOf2);
            if (iMax < 0) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(iMax));
            i = iMax + 1;
        }
    }

    private void initDictionaryMap() {
        this.dictionaryMap.put(ViterbiNode.Type.KNOWN, this.tokenInfoDictionary);
        this.dictionaryMap.put(ViterbiNode.Type.UNKNOWN, this.unknownDictionary);
        this.dictionaryMap.put(ViterbiNode.Type.USER, this.userDictionary);
        this.dictionaryMap.put(ViterbiNode.Type.INSERTED, this.insertedDictionary);
    }

    public void configure(Builder builder) {
        builder.loadDictionaries();
        this.tokenFactory = builder.tokenFactory;
        TokenInfoDictionary tokenInfoDictionary = builder.tokenInfoDictionary;
        this.tokenInfoDictionary = tokenInfoDictionary;
        UnknownDictionary unknownDictionary = builder.unknownDictionary;
        this.unknownDictionary = unknownDictionary;
        UserDictionary userDictionary = builder.userDictionary;
        this.userDictionary = userDictionary;
        this.insertedDictionary = builder.insertedDictionary;
        this.viterbiBuilder = new ViterbiBuilder(builder.doubleArrayTrie, tokenInfoDictionary, unknownDictionary, userDictionary, builder.mode);
        this.viterbiSearcher = new ViterbiSearcher(builder.mode, builder.connectionCosts, this.unknownDictionary, builder.penalties);
        this.viterbiFormatter = new ViterbiFormatter(builder.connectionCosts);
        this.split = builder.split;
        initDictionaryMap();
    }

    public void debugLattice(OutputStream outputStream, String str) throws IOException {
        outputStream.write(this.viterbiFormatter.format(this.viterbiBuilder.build(str)).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }

    public void debugTokenize(OutputStream outputStream, String str) throws IOException {
        ViterbiLattice viterbiLatticeBuild = this.viterbiBuilder.build(str);
        outputStream.write(this.viterbiFormatter.format(viterbiLatticeBuild, this.viterbiSearcher.search(viterbiLatticeBuild)).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }

    public List<? extends TokenBase> tokenize(String str) {
        return createTokenList(str);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static abstract class Builder {
        protected CharacterDefinitions characterDefinitions;
        protected ConnectionCosts connectionCosts;
        protected DoubleArrayTrie doubleArrayTrie;
        protected InsertedDictionary insertedDictionary;
        protected ResourceResolver resolver;
        protected TokenFactory tokenFactory;
        protected TokenInfoDictionary tokenInfoDictionary;
        protected UnknownDictionary unknownDictionary;
        protected UserDictionary userDictionary = null;
        protected Mode mode = Mode.NORMAL;
        protected boolean split = true;
        protected List<Integer> penalties = Collections.EMPTY_LIST;
        protected int totalFeatures = -1;
        protected int readingFeature = -1;
        protected int partOfSpeechFeature = -1;

        public abstract <T extends TokenizerBase> T build();

        public void loadDictionaries() {
            try {
                this.doubleArrayTrie = DoubleArrayTrie.newInstance(this.resolver);
                this.connectionCosts = ConnectionCosts.newInstance(this.resolver);
                this.tokenInfoDictionary = TokenInfoDictionary.newInstance(this.resolver);
                CharacterDefinitions characterDefinitionsNewInstance = CharacterDefinitions.newInstance(this.resolver);
                this.characterDefinitions = characterDefinitionsNewInstance;
                this.unknownDictionary = UnknownDictionary.newInstance(this.resolver, characterDefinitionsNewInstance, this.totalFeatures);
                this.insertedDictionary = new InsertedDictionary(this.totalFeatures);
            } catch (Exception e) {
                PathKt$$ExternalSyntheticBUOutline0.m("Could not load dictionaries.", (Throwable) e);
            }
        }

        public Builder userDictionary(String str) throws IOException {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            userDictionary(bufferedInputStream);
            bufferedInputStream.close();
            return this;
        }

        public Builder userDictionary(InputStream inputStream) {
            this.userDictionary = new UserDictionary(inputStream, this.totalFeatures, this.readingFeature, this.partOfSpeechFeature);
            return this;
        }
    }

    public <T extends TokenBase> List<T> createTokenList(String str) {
        int i = 0;
        if (!this.split) {
            return createTokenList(0, str);
        }
        List<Integer> splitPositions = getSplitPositions(str);
        if (splitPositions.size() == 0) {
            return createTokenList(0, str);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = splitPositions.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue() + 1;
            arrayList.addAll(createTokenList(i, str.substring(i, iIntValue)));
            i = iIntValue;
        }
        if (i < str.length()) {
            arrayList.addAll(createTokenList(i, str.substring(i)));
        }
        return arrayList;
    }
}
