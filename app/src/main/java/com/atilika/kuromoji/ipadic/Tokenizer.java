package com.atilika.kuromoji.ipadic;

import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.dict.CharacterDefinitions;
import com.atilika.kuromoji.dict.ConnectionCosts;
import com.atilika.kuromoji.dict.Dictionary;
import com.atilika.kuromoji.dict.InsertedDictionary;
import com.atilika.kuromoji.dict.TokenInfoDictionary;
import com.atilika.kuromoji.dict.UnknownDictionary;
import com.atilika.kuromoji.trie.DoubleArrayTrie;
import com.atilika.kuromoji.util.SimpleResourceResolver;
import com.atilika.kuromoji.viterbi.TokenFactory;
import com.atilika.kuromoji.viterbi.ViterbiNode;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Tokenizer extends TokenizerBase {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class Builder extends TokenizerBase.Builder {
        private static final int DEFAULT_KANJI_LENGTH_THRESHOLD = 2;
        private static final int DEFAULT_KANJI_PENALTY = 3000;
        private static final int DEFAULT_OTHER_LENGTH_THRESHOLD = 7;
        private static final int DEFAULT_OTHER_PENALTY = 1700;
        private int kanjiPenaltyLengthTreshold = 2;
        private int kanjiPenalty = DEFAULT_KANJI_PENALTY;
        private int otherPenaltyLengthThreshold = 7;
        private int otherPenalty = DEFAULT_OTHER_PENALTY;
        private boolean nakaguroSplit = false;

        public Builder() {
            this.totalFeatures = 9;
            this.readingFeature = 7;
            this.partOfSpeechFeature = 0;
            this.tokenFactory = new TokenFactory<Token>() { // from class: com.atilika.kuromoji.ipadic.Tokenizer.Builder.1
                @Override // com.atilika.kuromoji.viterbi.TokenFactory
                public Token createToken(int i, String str, ViterbiNode.Type type, int i2, Dictionary dictionary) {
                    return new Token(i, str, type, i2, dictionary);
                }
            };
        }

        @Override // com.atilika.kuromoji.TokenizerBase.Builder
        public Tokenizer build() {
            return new Tokenizer(this);
        }

        public Builder isSplitOnNakaguro(boolean z) {
            this.nakaguroSplit = z;
            return this;
        }

        public Builder kanjiPenalty(int i, int i2) {
            this.kanjiPenaltyLengthTreshold = i;
            this.kanjiPenalty = i2;
            return this;
        }

        @Override // com.atilika.kuromoji.TokenizerBase.Builder
        public void loadDictionaries() {
            ArrayList arrayList = new ArrayList();
            this.penalties = arrayList;
            arrayList.add(Integer.valueOf(this.kanjiPenaltyLengthTreshold));
            this.penalties.add(Integer.valueOf(this.kanjiPenalty));
            this.penalties.add(Integer.valueOf(this.otherPenaltyLengthThreshold));
            this.penalties.add(Integer.valueOf(this.otherPenalty));
            SimpleResourceResolver simpleResourceResolver = new SimpleResourceResolver(getClass());
            this.resolver = simpleResourceResolver;
            try {
                this.doubleArrayTrie = DoubleArrayTrie.newInstance(simpleResourceResolver);
                this.connectionCosts = ConnectionCosts.newInstance(this.resolver);
                this.tokenInfoDictionary = TokenInfoDictionary.newInstance(this.resolver);
                CharacterDefinitions characterDefinitionsNewInstance = CharacterDefinitions.newInstance(this.resolver);
                this.characterDefinitions = characterDefinitionsNewInstance;
                if (this.nakaguroSplit) {
                    characterDefinitionsNewInstance.setCategories((char) 12539, new String[]{"SYMBOL"});
                }
                this.unknownDictionary = UnknownDictionary.newInstance(this.resolver, this.characterDefinitions, this.totalFeatures);
                this.insertedDictionary = new InsertedDictionary(this.totalFeatures);
            } catch (Exception e) {
                PathKt$$ExternalSyntheticBUOutline0.m("Could not load dictionaries.", (Throwable) e);
            }
        }

        public Builder mode(TokenizerBase.Mode mode) {
            this.mode = mode;
            return this;
        }

        public Builder otherPenalty(int i, int i2) {
            this.otherPenaltyLengthThreshold = i;
            this.otherPenalty = i2;
            return this;
        }
    }

    public Tokenizer() {
        this(new Builder());
    }

    @Override // com.atilika.kuromoji.TokenizerBase
    public List<Token> tokenize(String str) {
        return createTokenList(str);
    }

    private Tokenizer(Builder builder) {
        configure(builder);
    }
}
