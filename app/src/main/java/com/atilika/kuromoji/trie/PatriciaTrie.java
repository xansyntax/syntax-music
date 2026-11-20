package com.atilika.kuromoji.trie;

import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class PatriciaTrie<V> implements Map<String, V> {
    protected int entries = 0;
    private final KeyMapper<String> keyMapper = new StringKeyMapper();
    protected PatriciaNode<V> root;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface KeyMapper<K> {
        boolean isSet(int i, K k);

        String toBitString(K k);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class PatriciaNode<V> {
        private int bit;
        private String key;
        private PatriciaNode<V> left = null;
        private PatriciaNode<V> right = null;
        private V value;

        public PatriciaNode(String str, V v, int i) {
            this.key = str;
            this.value = v;
            this.bit = i;
        }

        public int getBit() {
            return this.bit;
        }

        public String getKey() {
            return this.key;
        }

        public PatriciaNode<V> getLeft() {
            return this.left;
        }

        public PatriciaNode<V> getRight() {
            return this.right;
        }

        public V getValue() {
            return this.value;
        }

        public void setLeft(PatriciaNode<V> patriciaNode) {
            this.left = patriciaNode;
        }

        public void setRight(PatriciaNode<V> patriciaNode) {
            this.right = patriciaNode;
        }

        public void setValue(V v) {
            this.value = v;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("key: " + this.key);
            sb.append(", ");
            sb.append("bit: " + this.bit);
            sb.append(", ");
            sb.append("value: " + this.value);
            sb.append(", ");
            if (this.left != null) {
                sb.append("left: " + this.left.getKey());
            } else {
                sb.append("left: null");
            }
            sb.append(", ");
            if (this.right != null) {
                sb.append("right: " + this.right.getKey());
            } else {
                sb.append("right: null");
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class StringKeyMapper implements KeyMapper<String> {
        private int length(String str) {
            if (str == null) {
                return 0;
            }
            return str.length() * 16;
        }

        @Override // com.atilika.kuromoji.trie.PatriciaTrie.KeyMapper
        public boolean isSet(int i, String str) {
            if (str == null) {
                return false;
            }
            return i >= length(str) || (Character.codePointAt(str, i / 16) & (1 << (15 - (i % 16)))) != 0;
        }

        @Override // com.atilika.kuromoji.trie.PatriciaTrie.KeyMapper
        public String toBitString(String str) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < length(str)) {
                if (isSet(i, str)) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                int i2 = i + 1;
                if (i2 % 4 == 0 && i < length(str)) {
                    sb.append(ServerSentEventKt.SPACE);
                }
                i = i2;
            }
            return sb.toString();
        }
    }

    public PatriciaTrie() {
        clear();
    }

    private void entriesR(PatriciaNode<V> patriciaNode, int i, Map<String, V> map) {
        if (patriciaNode.getBit() <= i) {
            return;
        }
        entriesR(patriciaNode.getLeft(), patriciaNode.getBit(), map);
        entriesR(patriciaNode.getRight(), patriciaNode.getBit(), map);
        map.put(patriciaNode.getKey(), patriciaNode.getValue());
    }

    private int findFirstDifferingBit(String str, String str2) {
        int i = 0;
        while (this.keyMapper.isSet(i, str) == this.keyMapper.isSet(i, str2)) {
            i++;
        }
        return i;
    }

    private PatriciaNode<V> findNearestNode(String str) {
        PatriciaNode<V> left = this.root.getLeft();
        PatriciaNode<V> patriciaNode = this.root;
        while (patriciaNode.getBit() < left.getBit()) {
            patriciaNode = left;
            left = !this.keyMapper.isSet(left.getBit(), str) ? left.getLeft() : left.getRight();
        }
        return left;
    }

    private void insertNode(PatriciaNode<V> patriciaNode) {
        PatriciaNode<V> left = this.root.getLeft();
        PatriciaNode<V> patriciaNode2 = this.root;
        while (patriciaNode2.getBit() < left.getBit() && left.getBit() < patriciaNode.getBit()) {
            patriciaNode2 = left;
            left = !this.keyMapper.isSet(left.getBit(), patriciaNode.getKey()) ? left.getLeft() : left.getRight();
        }
        if (this.keyMapper.isSet(patriciaNode.getBit(), patriciaNode.getKey())) {
            patriciaNode.setLeft(left);
            patriciaNode.setRight(patriciaNode);
        } else {
            patriciaNode.setLeft(patriciaNode);
            patriciaNode.setRight(left);
        }
        if (this.keyMapper.isSet(patriciaNode2.getBit(), patriciaNode.getKey())) {
            patriciaNode2.setRight(patriciaNode);
        } else {
            patriciaNode2.setLeft(patriciaNode);
        }
    }

    private void keysR(PatriciaNode<V> patriciaNode, int i, Set<String> set) {
        if (patriciaNode.getBit() <= i) {
            return;
        }
        keysR(patriciaNode.getLeft(), patriciaNode.getBit(), set);
        keysR(patriciaNode.getRight(), patriciaNode.getBit(), set);
        set.add(patriciaNode.getKey());
    }

    private void valuesR(PatriciaNode<V> patriciaNode, int i, List<V> list) {
        if (patriciaNode.getBit() <= i) {
            return;
        }
        valuesR(patriciaNode.getLeft(), patriciaNode.getBit(), list);
        valuesR(patriciaNode.getRight(), patriciaNode.getBit(), list);
        list.add(patriciaNode.getValue());
    }

    @Override // java.util.Map
    public void clear() {
        PatriciaNode<V> patriciaNode = new PatriciaNode<>(null, null, -1);
        this.root = patriciaNode;
        patriciaNode.setLeft(patriciaNode);
        this.entries = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Key can not be null");
            return false;
        }
        if (obj instanceof String) {
            return get(obj) != null;
        }
        throw new ClassCastException("Only String keys are supported -- got " + obj.getClass());
    }

    public boolean containsKeyPrefix(String str) {
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Prefix key can not be null");
            return false;
        }
        if (str.equals("")) {
            return true;
        }
        PatriciaNode<V> patriciaNodeFindNearestNode = findNearestNode(str);
        if (patriciaNodeFindNearestNode == null || patriciaNodeFindNearestNode.getKey() == null) {
            return false;
        }
        return patriciaNodeFindNearestNode.getKey().startsWith(str);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Iterator<V> it = values().iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, V>> entrySet() {
        HashMap map = new HashMap();
        entriesR(this.root.getLeft(), -1, map);
        return map.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Key can not be null");
            return null;
        }
        if (!(obj instanceof String)) {
            throw new ClassCastException("Only String keys are supported -- got " + obj.getClass());
        }
        if (obj.equals("")) {
            if (this.root.getRight() == null) {
                return null;
            }
            return this.root.getRight().getValue();
        }
        PatriciaNode<V> patriciaNodeFindNearestNode = findNearestNode((String) obj);
        if (obj.equals(patriciaNodeFindNearestNode.getKey())) {
            return patriciaNodeFindNearestNode.getValue();
        }
        return null;
    }

    public KeyMapper<String> getKeyMapper() {
        return this.keyMapper;
    }

    public PatriciaNode<V> getRoot() {
        return this.root;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.entries == 0;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        keysR(this.root.getLeft(), -1, hashSet);
        return hashSet;
    }

    @Override // java.util.Map
    public V put(String str, V v) {
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Key can not be null");
            return null;
        }
        if (str.equals("")) {
            PatriciaNode<V> patriciaNode = new PatriciaNode<>(str, v, -1);
            patriciaNode.setValue(v);
            this.root.setRight(patriciaNode);
            this.entries++;
            return v;
        }
        PatriciaNode<V> patriciaNodeFindNearestNode = findNearestNode(str);
        if (str.equals(patriciaNodeFindNearestNode.getKey())) {
            patriciaNodeFindNearestNode.setValue(v);
            return v;
        }
        insertNode(new PatriciaNode<>(str, v, findFirstDifferingBit(str, patriciaNodeFindNearestNode.getKey())));
        this.entries++;
        return v;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> map) {
        for (Map.Entry<? extends String, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), (Object) entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Remove is currently unsupported");
    }

    @Override // java.util.Map
    public int size() {
        return this.entries;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayList arrayList = new ArrayList();
        valuesR(this.root.getLeft(), -1, arrayList);
        return arrayList;
    }
}
