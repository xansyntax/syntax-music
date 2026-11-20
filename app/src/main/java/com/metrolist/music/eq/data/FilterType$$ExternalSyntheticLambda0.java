package com.metrolist.music.eq.data;

import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilterType$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ FilterType$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                FilterType[] filterTypeArrValues = FilterType.values();
                filterTypeArrValues.getClass();
                return new EnumSerializer("com.metrolist.music.eq.data.FilterType", filterTypeArrValues);
            case 1:
                GitHubAutoEqSearch$GitHubTreeResponse.Companion companion = GitHubAutoEqSearch$GitHubTreeResponse.Companion;
                return new HashSetSerializer(GitHubAutoEqSearch$GitHubTreeNode$$serializer.INSTANCE, (byte) 1);
            case 2:
                ParametricEQ.Companion companion2 = ParametricEQ.Companion;
                return new HashSetSerializer(ParametricEQBand$$serializer.INSTANCE, (byte) 1);
            case 3:
                ParametricEQ.Companion companion3 = ParametricEQ.Companion;
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                return new HashMapSerializer(stringSerializer, stringSerializer, (byte) 1);
            case 4:
                ParametricEQBand.Companion companion4 = ParametricEQBand.INSTANCE;
                return FilterType.INSTANCE.serializer();
            default:
                SavedEQProfile.Companion companion5 = SavedEQProfile.INSTANCE;
                return new HashSetSerializer(ParametricEQBand$$serializer.INSTANCE, (byte) 1);
        }
    }
}
