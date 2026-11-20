package com.atilika.kuromoji.compile;

import com.atilika.kuromoji.trie.DoubleArrayTrie;
import com.atilika.kuromoji.trie.Trie;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DoubleArrayTrieCompiler {
    public static DoubleArrayTrie build(List<String> list, boolean z) {
        Trie trie = new Trie();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            trie.add(it.next());
        }
        DoubleArrayTrie doubleArrayTrie = new DoubleArrayTrie(z);
        doubleArrayTrie.build(trie);
        return doubleArrayTrie;
    }
}
