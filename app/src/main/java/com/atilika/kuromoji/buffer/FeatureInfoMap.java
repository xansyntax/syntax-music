package com.atilika.kuromoji.buffer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FeatureInfoMap {
    private Map<String, Integer> featureMap = new HashMap();
    private int maxValue = 0;

    public int getEntryCount() {
        return this.maxValue;
    }

    public TreeMap<Integer, String> invert() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (String str : this.featureMap.keySet()) {
            treeMap.put(this.featureMap.get(str), str);
        }
        return treeMap;
    }

    public List<Integer> mapFeatures(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            boolean zContainsKey = this.featureMap.containsKey(str);
            Map<String, Integer> map = this.featureMap;
            if (zContainsKey) {
                arrayList.add(map.get(str));
            } else {
                map.put(str, Integer.valueOf(this.maxValue));
                arrayList.add(Integer.valueOf(this.maxValue));
                this.maxValue++;
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FeatureInfoMap{featureMap=");
        sb.append(this.featureMap);
        sb.append(", maxValue=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.maxValue, '}');
    }
}
