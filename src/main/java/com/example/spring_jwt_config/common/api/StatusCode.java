package com.example.spring_jwt_config.common.api;

import lombok.Getter;

@Getter
public enum StatusCode {

    SUCCESS(200, "Success"),
    USER_NOT_FOUND(453, "User is not found"),
    USER_DISABLED(453, "Biller account was deactivated. Please contact: 093 815 074"),
    BAD_CREDENTIALS(452, "Password is incorrect"),
    SECRET_INVALID(452, "Secret is incorrect"),
    CLIENT_NOT_FOUND(453, "Client is not found"),
    CLIENT_DISABLED(400, "Client is disabled"),
    CURRENT_PASSWORD(452, "Current password is incorrect"),
    PASSWORD_INCORRECT(452, "Password is incorrect"),
    NEW_PASSWORD(452, "New password must be different from current password"),
    USER_LOCKED(400, "User account is locked"),
    SERVICE_PLAN_ID_NOT_FOUND(404, "Service Plan id is not found"),
    USER_ID_EXIST(409, "User ID already exist"),
    // 401 Unauthorized
    UNAUTHORIZED(401, "Unauthorized"),

    // 404 Not Found
    NOT_FOUND(404, "Not Found"),
    BAD_REQUEST(400, "Bad Request"),

    //409  Conflict
    BILLER_EXIST(409, "Biller already exist"),

    BILLER_ALREADY_SUBSCRIBE(409, "Biller already subscribe"),
    USERNAME_EXIST(409, "Username already exist"),
    GROUP_EXIST(409, "Group is already exist"),
    FLOOR_EXIST(409, "Floor is already exist"),
    ROOM_EXIST(409, "Room is already exist"),
    ACCOUNT_NUMBER(409, "Parent account is already exist"),

    PARENT_ACCOUNT_IS_ACTIVE(409, "Parent account is being used"),
    UTILITY_RATE_EXIST(409, "Utility rate is already exist"),
    SERVICE_TITLE_EXIST(409, "Service title is already exist"),

    IMAGE_CANNOT_BE_EMPTY(400, "Image cannot be empty"),

    //403 Forbidden
    FORBIDDEN(403, "You are not authorized to perform this action"),

    VIRTUAL_ACCOUNT_NOT_FOUND(404, "Virtual account not found"),
    ISS_DMT_GREATER_THAN_NOW(400, "IssueDateTime must be greater than now"),

    NEW_ISS_DMT_EQUAL_OR_GREATER_OLD_ISS_DMT(400, "IssueDateTime must be equal or greater than the old one"),

    DUE_DTM_GREATER_THAN_ISSUE_DTM(400, "DueDateTime must be greater than IssueDateTime"),

    NEW_DUE_DTM_EQUAL_OR_GREATER_THAN_NOW (400, "DueDateTime must be equal or greater than now"),

    OVER_AMOUNT_LESS_THAN_TOTAL_AMOUNT(400, "OverAmount must be greater than TotalAmount"),

    INVALID_REFERENCE_NUMBER(400, "Invalid reference number"),
    INVALID_BILL_NO(400, "Invalid bill number"),
    BILL_IN_PROGRESS(400, "Bill is in progress"),
    INVALID_CURRENCY(400, "Currency is invalid"),
    PARENT_ACCOUNT_NOT_FOUND(404, "Parent account not found"),
    PARENT_ACCOUNT_NOT_TRUST(404, "Parent account is not Trusted yet"),
    BILLER_CONTRACT_NOT_FOUND(400, "Biller contract not found"),
    BILLER_NOT_FOUND(400, "Biller not found"),
    EMPLOYEE_NOT_FOUND(400, "Employee not found"),

    GROUP_NOT_FOUND(404, "Group is not found [{0}]"),

    EMAIL_IS_NUll(404, "Email is null"),

    EMAIL_OR_PHONE_INVALID(400, "Email or Phone is invalid"),

    PHONE_IS_NUll(404, "Phone is null"),

    TELEGRAM_ID_IS_NUll(404, "Telegram Id is null"),

    NOTIFICATION_TYPE_IS_FOUND(404, "Notification Type is not found"),

    NOTIFICATION_NOT_FOUND(404, "Notification is not found"),

    TRANSACTION_NOT_FOUND(404, "Transaction not found"),

    PAYER_NOT_FOUND(404, "Payer not found"),
    PAYER_ACCOUNT_NOT_FOUND(404, "Payer account not found"),
    PAYER_ACCOUNT_ITEM_NOT_FOUND(404, "Payer item not found"),

    PAYER_CANNOT_DELETE(400, "Payer cannot deleted"),
    PAYER_EXIST(409, "Payer is already exist"),

    PASSWORD_MUST_BE_ENCRYPTED(400, "Password must be encrypted"),
    BILL_NOT_PAID(400, "Payer have not paid the previous bill yet"),

    BILL_IS_CLOSE(400, "Bill is closed"),
    UN_SUPPORTED_OPERATION(400, "Unsupported operation"),
    BILL_NOT_FOUND(404, "Bill is not found"),
    INVOICE_NOT_FOUND(404, "Invoice is not found"),
    DISABLE_VERIFY_OTP_CODE(400, "Verify otp code is disabled"),
    BANK_NOT_FOUND(404, "Bank not found"),
    COMMON_CODE_NOT_FOUND(404, "Common code not found [{0}]"),
    SERVICE_CODE_NOT_FOUNT(404, "Service code not found"),

    UTILITY_RATE_NOT_FOUNT(404, "Utility rate not found"),

    BIll_CANNOT_DELETE(400, "Bill cannot be deleted"),
    BIll_CANNOT_UPDATE(400, "Bill cannot be updated"),
    SECURITY_KEY_NOT_FOUND(404, "Security key was not found"),
    SECURITY_CODE_INCORRECT(400, "Security code incorrect"),
    DISABLE_SENT_OTP_CODE_FOR_5_MINUTES(400, "Disabled send OTP code for 5 minutes."),
    DISABLE_SENT_OTP_CODE(400, "Disabled send OTP code for 15 minutes."),
    SECURITY_CODE_EXPIRED(400,"Security code is expired." ),
    BILL_REQUEST(401,"Please wait PPCB approve your requested." ),
    BILL_REVIEW(402,"Please wait PPCB approve your requested." ),
    ADMIN_REJECT(403,"Your request is being rejected." ),
    ADMIN_APPROVE(404,"Your request is being approved." ),
    BILLER_ACCOUNT_NOT_FOUND(400, "Biller account not found"),
    VIRTUAL_USD_NOT_ENOUGH(400, "Virtual account USD not enough"),
    VIRTUAL_KHR_NOT_ENOUGH(400, "Virtual account KHR not enough"),

    INVALID_PHONE(400,"Invalid phone number"),
    PHONENUMBER_ISEXIST(400, "Phone number is already exist"),
    CUSTOMER_NAME_EXIST(400, "This customer is already exist in this phone number"),

    PHONENUMBER_MORE_THEN_ONE(400, "Phone number has been used more than one"),

    PHONENUMBER_ISEXIST_BLLR(400, "Phone number is already exist in this biller"),
    EMAIL_IS_NULL(400, "Email is null"),
    EMAIL_NOT_VALID(400, "Email is not valid"),
    NOTIFY_METHOD_NOT_FOUND(404, "Notify method not found." ),
    PHONE_NUMBER_INVALID(400, "Phone number or Email must be encrypted"),
    SECURITY_CODE_MUST_BE_ENCRYPTED(400,"Security code must be encrypted"),
    SECURITY_KEY_MUST_BE_ENCRYPTED(400,"Security key must be encrypted"),
    SECURITY_CODE_NOT_FOUND(404, "Security code was not found"),
    ITEM_NOT_FOUND(404, "Item not found."),
    USERNAME_EXISTED(404, "Username is already existed."),
    USAGE_NAME_EXISTED(404, "Usage name is already existed."),
    BILL_RECURRING_NOT_FOUND(404, "Bill recurring not found."),
    WABOOKS_SEND_INVOICE_FAILED(400, "Send invoice failed."),

    EFILING_NOT_FOUND(404, "E-Filing not found"),

    FLOOR_NOT_FOUND(404, "Floor not found"),
    ROOM_NOT_FOUND(404, "Room not found"),

    FLOOR_CANNOT_DELETE(400, "Floor has room cannot be deleted"),
    UTILITY_USAGE_ITEM_NOT_FOUND(404, "Utility usage item not found"),
    UTILITY_TYPE_NOT_FOUND(404, "Utility type not found"),
    APARTMENT_NOT_FOUND(404, "Apartment not found"),
    BASIC_USAGE_NOT_FOUND(404, "Basic usage not found"),
    UTILITY_RATE_NOT_FOUND(404, "Utility rate not found"),
    ROLE_NOT_FOUND(404, "Role not found"),
    BILL_NOT_FOUNT(400, "Bill not found"),

    BILL_ALREADY_PAID(400,"Bill already paid" ),
    BILL_SCHEDULED(400,"Bill in schedule" ),
    BILL_OVERDUE(400, "Bill is overdue" ),
    SEND_OTP_FAILED(503, "sent otp failed"),
    INVOICE_NO_EXIST(403, "Invoice no exist"),
    TRIAL_VERSION(400, "Trial version" ),
    DUPLICATE_MONTH(400,"Month cannot duplicate" );

    private final String message;
    private final int code;

    StatusCode(final int code, final String message) {

        this.message = message;
        this.code = code;
    }

    public String getMessage() {

        return this.message;

    }

    public int getCode() {

        return code;

    }
}
