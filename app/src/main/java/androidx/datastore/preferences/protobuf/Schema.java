package androidx.datastore.preferences.protobuf;

import androidx.compose.ui.text.input.GapBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Schema {
    boolean equals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2);

    int getSerializedSize(GeneratedMessageLite generatedMessageLite);

    int hashCode(GeneratedMessageLite generatedMessageLite);

    boolean isInitialized(Object obj);

    void makeImmutable(Object obj);

    void mergeFrom(Object obj, GapBuffer gapBuffer, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(Object obj, Object obj2);

    GeneratedMessageLite newInstance();

    void writeTo(Object obj, ManifestSchemaFactory manifestSchemaFactory);
}
