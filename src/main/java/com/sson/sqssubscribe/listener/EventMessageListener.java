package com.sson.sqssubscribe.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventMessageListener {
    private static final String ACCOUNT_EVENT_SQS_NAME = "kr-dv-hrp-account-create";

    /**
     * DeletionPolicy
     *  ALWAYS
     *      리스너 메서드에 의한 메시지 처리 중 성공(예외 발생 없음) 또는 실패(예외 발생)시 항상 메세지 삭제
     *  NEVER
     *      메시지를 자동으로 삭제하지 않음.
     *      수신확인(Acknowledgment)로 명시적으로 삭제 가능
     *  NO_REDRIVE
     *      Redrive Policy(DeadLetterQueue)가 정의되지 않은 경우 메시지를 삭제
     *  ON_SUCCESS
     *      리스너 메서드에 의해 성공적으로 실행되면 메세지 삭제
     * @param message
     */
    @SqsListener(value = ACCOUNT_EVENT_SQS_NAME, deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void listen(Object message){
        log.info("listen message : {}", message.toString());
    }
}
