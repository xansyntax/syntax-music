package androidx.emoji2.text;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataRepo$Node {
    public final SparseArray mChildren;
    public TypefaceEmojiRasterizer mData;

    public MetadataRepo$Node(int i) {
        this.mChildren = new SparseArray(i);
    }

    public final void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i, int i2) {
        int codepointAt = typefaceEmojiRasterizer.getCodepointAt(i);
        SparseArray sparseArray = this.mChildren;
        MetadataRepo$Node metadataRepo$Node = (MetadataRepo$Node) sparseArray.get(codepointAt);
        if (metadataRepo$Node == null) {
            metadataRepo$Node = new MetadataRepo$Node(1);
            sparseArray.put(typefaceEmojiRasterizer.getCodepointAt(i), metadataRepo$Node);
        }
        if (i2 > i) {
            metadataRepo$Node.put(typefaceEmojiRasterizer, i + 1, i2);
        } else {
            metadataRepo$Node.mData = typefaceEmojiRasterizer;
        }
    }
}
