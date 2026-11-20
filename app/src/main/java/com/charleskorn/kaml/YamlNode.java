package com.charleskorn.kaml;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/charleskorn/kaml/YamlNode;", "", "Companion", "Lcom/charleskorn/kaml/YamlList;", "Lcom/charleskorn/kaml/YamlMap;", "Lcom/charleskorn/kaml/YamlNull;", "Lcom/charleskorn/kaml/YamlScalar;", "kaml"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = YamlNodeSerializer.class)
public abstract class YamlNode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/charleskorn/kaml/YamlNode$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/charleskorn/kaml/YamlNode;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kaml"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return YamlNodeSerializer.INSTANCE;
        }
    }
}
