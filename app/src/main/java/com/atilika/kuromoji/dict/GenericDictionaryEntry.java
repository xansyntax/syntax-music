package com.atilika.kuromoji.dict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class GenericDictionaryEntry extends DictionaryEntryBase implements Serializable {
    private final List<String> features;
    private final List<String> posFeatures;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class Builder {
        private short leftId;
        private short rightId;
        private String surface;
        private short wordCost;
        private List<String> pos = new ArrayList();
        private List<String> features = new ArrayList();

        public GenericDictionaryEntry build() {
            return new GenericDictionaryEntry(this);
        }

        public Builder features(List<String> list) {
            this.features = list;
            return this;
        }

        public Builder leftId(short s) {
            this.leftId = s;
            return this;
        }

        public Builder pos(List<String> list) {
            this.pos = list;
            return this;
        }

        public Builder rightId(short s) {
            this.rightId = s;
            return this;
        }

        public Builder surface(String str) {
            this.surface = str;
            return this;
        }

        public Builder wordCost(short s) {
            this.wordCost = s;
            return this;
        }
    }

    public GenericDictionaryEntry(Builder builder) {
        super(builder.surface, builder.leftId, builder.rightId, builder.wordCost);
        this.posFeatures = builder.pos;
        this.features = builder.features;
    }

    public List<String> getFeatures() {
        return this.features;
    }

    public List<String> getPosFeatures() {
        return this.posFeatures;
    }
}
