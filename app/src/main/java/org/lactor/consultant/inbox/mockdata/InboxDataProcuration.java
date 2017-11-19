package org.lactor.consultant.inbox.mockdata;

import org.lactor.consultant.inbox.model.InboxMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Matthew Page
 * @Date 11/18/17
 */

public class InboxDataProcuration {
    public static List<InboxMessage> procureMockMessageList() {
        List<InboxMessage> messages = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            messages.add(procureMockMessage());
        }
        return messages;
    }

    public static InboxMessage procureMockMessage() {
        return  new InboxMessage(
                "Daniel Williams",
                "Oscar Brown",
                System.currentTimeMillis(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sit amet mauris bibendum, volutpat arcu a, volutpat justo. Nullam elementum interdum turpis, et sodales tellus laoreet et. Suspendisse potenti. Maecenas dolor orci, pulvinar id placerat eget, facilisis eu ipsum. Quisque dui nisi, aliquet at dictum at, tempor et justo. Aenean a nisl quis leo lobortis congue. Phasellus fringilla ipsum placerat, maximus orci ac, porta eros."
        );
    }
}
