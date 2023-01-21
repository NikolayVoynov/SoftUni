package core;

import models.Message;

import java.util.*;
import java.util.stream.Collectors;

public class DiscordImpl implements Discord {
    private Map<String, Message> messagesById;
    private Map<String, Set<Message>> messagesByChannel;

    public DiscordImpl() {
        this.messagesById = new LinkedHashMap<>();
        this.messagesByChannel = new HashMap<>();
    }

    @Override
    public void sendMessage(Message message) {
        this.messagesById.put(message.getId(), message);

        if (!this.messagesByChannel.containsKey(message.getChannel())) {
            this.messagesByChannel.put(message.getChannel(), new LinkedHashSet<>());
        }

        this.messagesByChannel.get(message.getChannel()).add(message);
    }

    @Override
    public boolean contains(Message message) {
        return this.messagesById.containsKey(message.getId());
    }

    @Override
    public int size() {
        return this.messagesById.size();
    }

    @Override
    public Message getMessage(String messageId) {
        if (!this.messagesById.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }

        return this.messagesById.get(messageId);
    }

    @Override
    public void deleteMessage(String messageId) {
        if (!this.messagesById.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }

        Message message = this.messagesById.remove(messageId);
        this.messagesByChannel.get(message.getChannel()).remove(message);
    }

    @Override
    public void reactToMessage(String messageId, String reaction) {
        if (!this.messagesById.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }

        this.messagesById.get(messageId).getReactions().add(reaction);
    }

    @Override
    public Iterable<Message> getChannelMessages(String channel) {
//        List<Message> messagesInChannel = this.messagesById
//                .values()
//                .stream()
//                .filter(m -> m.getChannel().equals(channel))
//                .collect(Collectors.toList());

        Set<Message> messagesInChannel = this.messagesByChannel.get(channel);

        if (messagesInChannel == null) {
            throw new IllegalArgumentException();
        }

        return messagesInChannel;
    }

    @Override
    public Iterable<Message> getMessagesByReactions(List<String> reactions) {
        return this.messagesById
                .values()
                .stream()
                .filter(m -> m.getReactions().containsAll(reactions))
                .sorted((f, s) -> {
                    int fCount = f.getReactions().size();
                    int sCount = s.getReactions().size();

                    if (fCount != sCount) {
                        return sCount - fCount;
                    }

                    return f.getTimestamp() - s.getTimestamp();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getMessageInTimeRange(Integer lowerBound, Integer upperBound) {
        return this.messagesById
                .values()
                .stream()
                .filter(m -> lowerBound <= m.getTimestamp() && upperBound >= m.getTimestamp())
                .sorted((f, s) -> {
                    int fChannelMessages = this.messagesByChannel.get(f.getChannel()).size();
                    int sChannelMessages = this.messagesByChannel.get(s.getChannel()).size();

                    return sChannelMessages - fChannelMessages;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getTop3MostReactedMessages() {
        return this.messagesById
                .values()
                .stream()
                .sorted((f, s) -> s.getReactions().size() - f.getReactions().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent() {
        return this.messagesById
                .values()
                .stream()
                .sorted((f, s) -> {
                            int fCountReactions = f.getReactions().size();
                            int sCountReactions = s.getReactions().size();

                            if (fCountReactions != sCountReactions) {
                                return sCountReactions - fCountReactions;
                            }

                            if (f.getTimestamp() != s.getTimestamp()) {
                                return f.getTimestamp() - s.getTimestamp();
                            }

                            return f.getContent().length() - s.getContent().length();
                        }
                )
                .collect(Collectors.toList());
    }
}
