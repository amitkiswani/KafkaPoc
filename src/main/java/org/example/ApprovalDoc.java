package org.example;

public class ApprovalDoc {

     public int version;
     public long triggerTime;
     public boolean deleted;
     public long id;
     public long approvalId;
     public long documentId;

    /** state can be PENDING_REVIEW, APPROVED, REJECTED, EXPIRED, INFECTED */
     public java.lang.String state;

     public java.lang.String stateReasons;
     public java.lang.String history;
     public java.lang.String createdBy;
     public java.lang.String modifiedBy;
     public boolean required;
     public long creationTime;
     public long modificationTime;

    public ApprovalDoc() {}
}
