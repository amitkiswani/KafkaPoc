package org.example;

public class Approval<V> {
    @Deprecated public int version;
    @Deprecated public long triggerTime;
    @Deprecated public boolean deleted;
    @Deprecated public long id;
    @Deprecated public long orgId;

    /** The parent organization id */
    @Deprecated public java.lang.Long parentOrgId;

    @Deprecated public java.lang.String createdBy;
    @Deprecated public java.lang.String modifiedBy;
    @Deprecated public long creationTime;
    @Deprecated public long modificationTime;

    /** accountType can be AGENCY, DEVELOPER */
    @Deprecated public java.lang.String accountType;

    /** orgServiceLevel can be SELF_SERVICE, CLIENT_SUPPORTED */
    @Deprecated public java.lang.String orgServiceLevel;

    @Deprecated public java.lang.Long adamId;
    @Deprecated public java.lang.Long appMetaVersion;
    @Deprecated public java.lang.String storefront;

    /** approvalType can be ACCOUNT, APP, PRODUCT_PAGE */
    @Deprecated public java.lang.String approvalType;

    @Deprecated public java.util.List<org.example.ApprovalDoc> documents;

    /** approval state can be PENDING_REVIEW, UNDER_REVIEW, APPROVED, INFECTED, REJECTED, EXPIRED */
    @Deprecated public java.lang.String state;

    @Deprecated public java.lang.String rejectReason;
    @Deprecated public java.lang.String approverNotes;
    @Deprecated public java.lang.String history;
    @Deprecated public boolean reviewRequired;
    @Deprecated public boolean appChanged;
    @Deprecated public long cpid;
    @Deprecated public java.lang.Long lastSubmissionTime;

    /** ownershipType can be ORGANIZATION, INDIVIDUAL, UNANSWERED */
    @Deprecated public java.lang.String ownershipType;

    @Deprecated public java.lang.Long lenModificationTime;
    @Deprecated public java.lang.String productPageId;
    @Deprecated public java.util.List<java.lang.String> stateReasons;
    @Deprecated public java.lang.Boolean required;

    public Approval(
            java.lang.Integer version,
            java.lang.Long triggerTime,
            java.lang.Boolean deleted,
            java.lang.Long id,
            java.lang.Long orgId,
            java.lang.Long parentOrgId,
            java.lang.String createdBy,
            java.lang.String modifiedBy,
            java.lang.Long creationTime,
            java.lang.Long modificationTime,
            java.lang.String accountType,
            java.lang.String orgServiceLevel,
            java.lang.Long adamId,
            java.lang.Long appMetaVersion,
            java.lang.String storefront,
            java.lang.String approvalType,
            java.util.List<org.example.ApprovalDoc> documents,
            java.lang.String state,
            java.lang.String rejectReason,
            java.lang.String approverNotes,
            java.lang.String history,
            java.lang.Boolean reviewRequired,
            java.lang.Boolean appChanged,
            java.lang.Long cpid,
            java.lang.Long lastSubmissionTime,
            java.lang.String ownershipType,
            java.lang.Long lenModificationTime,
            java.lang.String productPageId,
            java.util.List<java.lang.String> stateReasons,
            java.lang.Boolean required) {
        this.version = version;
        this.triggerTime = triggerTime;
        this.deleted = deleted;
        this.id = id;
        this.orgId = orgId;
        this.parentOrgId = parentOrgId;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.creationTime = creationTime;
        this.modificationTime = modificationTime;
        this.accountType = accountType;
        this.orgServiceLevel = orgServiceLevel;
        this.adamId = adamId;
        this.appMetaVersion = appMetaVersion;
        this.storefront = storefront;
        this.approvalType = approvalType;
        this.documents = documents;
        this.state = state;
        this.rejectReason = rejectReason;
        this.approverNotes = approverNotes;
        this.history = history;
        this.reviewRequired = reviewRequired;
        this.appChanged = appChanged;
        this.cpid = cpid;
        this.lastSubmissionTime = lastSubmissionTime;
        this.ownershipType = ownershipType;
        this.lenModificationTime = lenModificationTime;
        this.productPageId = productPageId;
        this.stateReasons = stateReasons;
        this.required = required;
    }

    public Approval() {}
}
