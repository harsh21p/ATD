package com.atd.atdmobileapp.models.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jb\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00060"}, d2 = {"Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;", "", "locationnumber", "", "quoteid", "consumerinfo", "Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;", "quotestatus", "quotecomment", "sendemailtoconsumer", "", "deletereason", "(Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getConsumerinfo", "()Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;", "setConsumerinfo", "(Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;)V", "getDeletereason", "()Ljava/lang/String;", "setDeletereason", "(Ljava/lang/String;)V", "getLocationnumber", "setLocationnumber", "getQuotecomment", "setQuotecomment", "getQuoteid", "setQuoteid", "getQuotestatus", "setQuotestatus", "getSendemailtoconsumer", "()Ljava/lang/Boolean;", "setSendemailtoconsumer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class UpdateRequestBody {
    @org.jetbrains.annotations.Nullable
    private java.lang.String locationnumber;
    @org.jetbrains.annotations.Nullable
    private java.lang.String quoteid;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo;
    @org.jetbrains.annotations.Nullable
    private java.lang.String quotestatus;
    @org.jetbrains.annotations.Nullable
    private java.lang.String quotecomment;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean sendemailtoconsumer;
    @org.jetbrains.annotations.Nullable
    private java.lang.String deletereason;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.UpdateRequestBody copy(@org.jetbrains.annotations.Nullable
    java.lang.String locationnumber, @org.jetbrains.annotations.Nullable
    java.lang.String quoteid, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo, @org.jetbrains.annotations.Nullable
    java.lang.String quotestatus, @org.jetbrains.annotations.Nullable
    java.lang.String quotecomment, @org.jetbrains.annotations.Nullable
    java.lang.Boolean sendemailtoconsumer, @org.jetbrains.annotations.Nullable
    java.lang.String deletereason) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public UpdateRequestBody() {
        super();
    }
    
    public UpdateRequestBody(@org.jetbrains.annotations.Nullable
    java.lang.String locationnumber, @org.jetbrains.annotations.Nullable
    java.lang.String quoteid, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo, @org.jetbrains.annotations.Nullable
    java.lang.String quotestatus, @org.jetbrains.annotations.Nullable
    java.lang.String quotecomment, @org.jetbrains.annotations.Nullable
    java.lang.Boolean sendemailtoconsumer, @org.jetbrains.annotations.Nullable
    java.lang.String deletereason) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocationnumber() {
        return null;
    }
    
    public final void setLocationnumber(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getQuoteid() {
        return null;
    }
    
    public final void setQuoteid(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.myquotes.Consumerinfo component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.myquotes.Consumerinfo getConsumerinfo() {
        return null;
    }
    
    public final void setConsumerinfo(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.Consumerinfo p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getQuotestatus() {
        return null;
    }
    
    public final void setQuotestatus(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getQuotecomment() {
        return null;
    }
    
    public final void setQuotecomment(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getSendemailtoconsumer() {
        return null;
    }
    
    public final void setSendemailtoconsumer(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDeletereason() {
        return null;
    }
    
    public final void setDeletereason(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}