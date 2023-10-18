package com.quangminh.searchviaspecifications.builder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public final class Condition {
    public enum LogicalOperatorType {

        AND, OR, END
    }

    public enum OperationType {

        EQUAL, NOT_EQUAL, GREATER_THAN, LESS_THAN, LIKE
    }

    private final String leftHand;
    private final String rightHand;
    private final OperationType operation;
    private final LogicalOperatorType operator;

}
