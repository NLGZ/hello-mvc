package com.sh.mvc.notification.model.service;

import com.sh.mvc.notification.model.entity.Notification;
import com.sh.mvc.notification.model.entity.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        this.notificationService = new NotificationService();
    }

    @DisplayName("한행의 알림 데이터를 기록한다.")
    @ParameterizedTest
    @CsvSource({
            "qwerty,NEW_COMMENT,마약시작하면바로끝 게시글에 댓글이 달렸습니다,false",
            "abcde,NEW_COMMENT,안녕하계세요~여러분 게시글에 댓글이 달렸습니다,true"})
    void test1(String memberId, Type type, String content, Boolean checked) {
        // given
        assertThat(memberId).isNotNull();
        assertThat(type).isNotNull();
        assertThat(content).isNotNull();
        assertThat(checked).isNotNull();
        // when
        Notification noti = new Notification();
        noti.setMemberId(memberId);
        noti.setType(type);
        noti.setContent(content);
        noti.setChecked(checked);
        int result = notificationService.insertNotification(noti);
        // then
        assertThat(result).isGreaterThan(0);
    }
}