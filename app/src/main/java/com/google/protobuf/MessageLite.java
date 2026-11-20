package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite buildPartial();
    }

    int getSerializedSize();

    Builder newBuilderForType();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream);
}
