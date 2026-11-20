package com.metrolist.innertube.pages;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChartsPage {
    public final String continuation;
    public final ArrayList sections;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChartSection {
        public final ChartType chartType;
        public final ArrayList items;
        public final String title;

        public ChartSection(String str, ArrayList arrayList, ChartType chartType) {
            str.getClass();
            this.title = str;
            this.items = arrayList;
            this.chartType = chartType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChartSection)) {
                return false;
            }
            ChartSection chartSection = (ChartSection) obj;
            return Intrinsics.areEqual(this.title, chartSection.title) && this.items.equals(chartSection.items) && this.chartType == chartSection.chartType;
        }

        public final int hashCode() {
            return this.chartType.hashCode() + ((this.items.hashCode() + (this.title.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "ChartSection(title=" + this.title + ", items=" + this.items + ", chartType=" + this.chartType + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChartType {
        public static final /* synthetic */ ChartType[] $VALUES;
        public static final ChartType GENRE;
        public static final ChartType NEW_RELEASES;
        public static final ChartType TOP;
        public static final ChartType TRENDING;

        static {
            ChartType chartType = new ChartType("TRENDING", 0);
            TRENDING = chartType;
            ChartType chartType2 = new ChartType("TOP", 1);
            TOP = chartType2;
            ChartType chartType3 = new ChartType("GENRE", 2);
            GENRE = chartType3;
            ChartType chartType4 = new ChartType("NEW_RELEASES", 3);
            NEW_RELEASES = chartType4;
            $VALUES = new ChartType[]{chartType, chartType2, chartType3, chartType4};
        }

        public static ChartType valueOf(String str) {
            return (ChartType) Enum.valueOf(ChartType.class, str);
        }

        public static ChartType[] values() {
            return (ChartType[]) $VALUES.clone();
        }
    }

    public ChartsPage(String str, ArrayList arrayList) {
        this.sections = arrayList;
        this.continuation = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChartsPage)) {
            return false;
        }
        ChartsPage chartsPage = (ChartsPage) obj;
        return this.sections.equals(chartsPage.sections) && Intrinsics.areEqual(this.continuation, chartsPage.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.sections.hashCode() * 31;
        String str = this.continuation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ChartsPage(sections=" + this.sections + ", continuation=" + this.continuation + ")";
    }
}
