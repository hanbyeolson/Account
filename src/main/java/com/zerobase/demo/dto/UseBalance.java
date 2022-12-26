package com.zerobase.demo.dto;

import com.zerobase.demo.type.TransactionResultType;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UseBalance {
    /**
     * {
     *     "userId:1,
     *     "accountNumber":"10000000000",
     *     "amount":1000
     * }
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        @NotNull
        @Min(1)
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    /**
     * {
     *     "accountNumber:"1234567890",
     *     "transactionResult":"s",
     *     "transactionId:"c12343235123d1235425gds3421231",
     *     "amount":10000,
     *     "transactedAt":"2022-06-01T23:26:14.671859"
     * }
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;


        public static Response from(TransactionDto transactionDto) {
            return Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}

