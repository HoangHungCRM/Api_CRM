package com.resdii.crm.user.enums;

public enum ApprovalStatus {
    APPROVED(1),
    WAITING_APPROVE(2),
    REJECT(3);

    public int value;
    ApprovalStatus(int value){
        this.value = value;
    }

    public static boolean isApprovedStatus(Integer value){
        return value != null && value == APPROVED.value;
    }

    public static boolean isWaitingApprovedStatus(Integer value){
        return value != null && value == WAITING_APPROVE.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
