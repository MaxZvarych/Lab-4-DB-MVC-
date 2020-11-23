package ua.lviv.iot.view;

import ua.lviv.iot.businesslogic.model.*;
import ua.lviv.iot.controller.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private final Scanner input;

    private final DiscordController discordController;
    private final AudioFileController audioFileController;
    private final ChatController chatController;
    private final ChatMessageController chatMessageController;
    private final ChatStyleController chatStyleController;
    private final MediaFileController mediaFileController;
    private final MessageController messageController;
    private final UserChatController userChatController;
    private final UserController userController;

    public View() throws SQLException, IOException {
        input = new Scanner(System.in, StandardCharsets.UTF_8);

        discordController = new DiscordController();
        audioFileController = new AudioFileController();
        chatController = new ChatController();
        chatMessageController = new ChatMessageController();
        chatStyleController = new ChatStyleController();
        mediaFileController = new MediaFileController();
        messageController = new MessageController();
        userChatController = new UserChatController();
        userController = new UserController();

        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("A", "A-Select all tables");

        methodsMenu.put("A", this::printAllTables);

        //Menu for AudioFile
        menu.put("1", "1-Table:AudioFile");
        menu.put("11", "11-Find all audio files");
        menu.put("12", "12-Find audio file by id");
        menu.put("13", "13-Create audio file");
        menu.put("14", "14-Update audio file");
        menu.put("15", "15-Delete audio file");

        methodsMenu.put("11", this::printAudioFileTable);
        methodsMenu.put("12", this::printRowFromAudioFileByID);
        methodsMenu.put("13", this::createNewAudioFile);
        methodsMenu.put("14", this::updateAudioFile);
        methodsMenu.put("15", this::deleteAudioFile);

        //Menu for Chat
        menu.put("2", "2-Table:Chat");
        menu.put("21", "21-Find all chats");
        menu.put("22", "22-Find chat id");
        menu.put("23", "23-Create chat");
        menu.put("24", "24-Update chat");
        menu.put("25", "25-Delete chat");

        methodsMenu.put("21", this::printChatTable);
        methodsMenu.put("22", this::printRowFromChatByID);
        methodsMenu.put("23", this::createNewChat);
        methodsMenu.put("24", this::updateChat);
        methodsMenu.put("25", this::deleteChat);

        //Menu for ChatMessage
        menu.put("3", "3-Table:ChatMessage");
        menu.put("31", "31-Find all chat_messages");
        menu.put("32", "32-Find chat_message id");
        menu.put("33", "33-Create chat_message");
        menu.put("34", "34-Update chat_message");
        menu.put("35", "35-Delete chat_message");

        methodsMenu.put("31", this::printChatMessageTable);
        methodsMenu.put("32", this::printRowFromChatMessageByID);
        methodsMenu.put("33", this::createNewChatMessage);
        methodsMenu.put("34", this::updateChatMessage);
        methodsMenu.put("35", this::deleteChatMessage);

        //Menu for ChatStyle
        menu.put("4", "4-Table:ChatStyle");
        menu.put("41", "41-Find all chat_styles");
        menu.put("42", "42-Find chat_style id");
        menu.put("43", "43-Create chat_style");
        menu.put("44", "44-Update chat_style");
        menu.put("45", "45-Delete chat_style");

        methodsMenu.put("41", this::printChatStyleTable);
        methodsMenu.put("42", this::printRowFromChatStyleByID);
        methodsMenu.put("43", this::createNewChatStyle);
        methodsMenu.put("44", this::updateChatStyle);
        methodsMenu.put("45", this::deleteChatStyle);

        //Menu for Discord
        menu.put("5", "5-Table:Discord");
        menu.put("51", "51-Find all discords");
        menu.put("52", "52-Find discord by id");
        menu.put("53", "53-Create discord");
        menu.put("54", "54-Update discord");
        menu.put("55", "55-Delete discord");

        methodsMenu.put("51", this::printDiscordTable);
        methodsMenu.put("52", this::printRowFromDiscordByVersion);
        methodsMenu.put("53", this::createNewDiscord);
        methodsMenu.put("54", this::updateDiscord);
        methodsMenu.put("55", this::deleteDiscord);

        //Menu for MediaFile
        menu.put("6", "6-Table:MediaFile");
        menu.put("61", "61-Find all audio files");
        menu.put("62", "62-Find audio file by id");
        menu.put("63", "63-Create audio file");
        menu.put("64", "64-Update audio file");
        menu.put("65", "65-Delete audio file");

        methodsMenu.put("61", this::printMediaFileTable);
        methodsMenu.put("62", this::printRowFromMediaFileByID);
        methodsMenu.put("63", this::createNewMediaFile);
        methodsMenu.put("64", this::updateMediaFile);
        methodsMenu.put("65", this::deleteMediaFile);

        //Menu for Message
        menu.put("7", "7-Table:Message");
        menu.put("71", "71-Find all messages");
        menu.put("72", "72-Find message id");
        menu.put("73", "73-Create message");
        menu.put("74", "74-Update message");
        menu.put("75", "75-Delete message");

        methodsMenu.put("71", this::printMessageTable);
        methodsMenu.put("72", this::printRowFromMessageByID);
        methodsMenu.put("73", this::createNewMessage);
        methodsMenu.put("74", this::updateMessage);
        methodsMenu.put("75", this::deleteMessage);

        //Menu for UserChat
        menu.put("8", "8-Table:UserChat");
        menu.put("81", "81-Find all user_chats");
        menu.put("82", "82-Find user_chat id");
        menu.put("83", "83-Create user_chat");
        menu.put("84", "84-Update user_chat");
        menu.put("85", "85-Delete user_chat");

        methodsMenu.put("81", this::printUserChatTable);
        methodsMenu.put("82", this::printRowFromUserChatByID);
        methodsMenu.put("83", this::createNewUserChat);
        methodsMenu.put("84", this::updateUserChat);
        methodsMenu.put("85", this::deleteUserChat);

        //Menu for User
        menu.put("9", "9-Table:User");
        menu.put("91", "91-Find all users");
        menu.put("92", "92-Find user id");
        menu.put("93", "93-Create user");
        menu.put("94", "94-Update user");
        menu.put("95", "95-Delete user");

        methodsMenu.put("91", this::printUserTable);
        methodsMenu.put("92", this::printRowFromUserByID);
        methodsMenu.put("93", this::createNewUser);
        methodsMenu.put("94", this::updateUser);
        methodsMenu.put("95", this::deleteUser);

        menu.put("L", "L-go back");
        menu.put("Q", "Q-exit");
    }

    public void show() {

        String keyMenu;

        do {
            printMenu();
            System.out.println("Please, select point:");
            keyMenu = input.nextLine().toUpperCase();
            while (keyMenu.equals("")) {
                keyMenu = input.nextLine().toUpperCase();
            }

            if (keyMenu.matches("(^\\d)|(^B)")) {
                printSubMenu(keyMenu);
                System.out.println("Please select point of menu:");
                keyMenu = input.nextLine().toUpperCase();
                while (keyMenu.equals("")) {
                    keyMenu = input.nextLine().toUpperCase();
                }
            }

            if (keyMenu.equals("L")) {
                continue;
            }
            if (keyMenu.equals("Q")) {
                break;
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception throwables) {
                System.out.println("Can't execute command");
                System.out.println("Expresion is " + throwables.getMessage());
            }

        } while (true);

    }

    private void printMenu() {
        System.out.print("\n\nMenu:\n");
        for (Map.Entry<String, String> item : menu.entrySet()) {
            if (item.getKey().length() == 1 && !item.getValue().equals("L")) {
                System.out.println(item.getValue());
            }
        }
    }

    private void printSubMenu(String fig) {
        System.out.println("\n\nSubMenu:\n");
        for (Map.Entry<String, String> item : menu.entrySet()) {
            if (item.getValue().length() != 1 && item.getValue().substring(0, 1).equals(fig)
                    || item.getValue().equals("L") || item.getValue().equals("Q")) {
                System.out.println(item.getValue());
            }
        }
    }


    private Discord readDiscord() {


        System.out.println("Please write settings:");
        final String inputSettings = input.nextLine();

        System.out.println("Please write if update is available(yes-true, no-false):");
        final Boolean inputUpdateAvailable = input.nextBoolean();
        return new Discord(0, inputUpdateAvailable, inputSettings);

    }

    private int readDiscordVersion() {
        System.out.println("\nPlease write version of Discord:");
        return input.nextInt();
    }

    private void printDiscordTable() throws SQLException {
        List<Discord> discords = discordController.getDiscords();
        System.out.print("\n\nDiscord\n");
        System.out
                .format("%8s    %-22s %-22s %n", "version", "update_available", "settings");
        for (Discord discord : discords) {
            System.out.print(discord);
        }

    }

    private void printRowFromDiscordByVersion() throws SQLException {
        int inputVersion = readDiscordVersion();
        System.out.print("\n\nDiscord\n");
        System.out
                .format("%8s    %-22s %-22s %n", "version", "update_available", "settings");
        System.out.println(discordController.getDiscord(inputVersion));
    }

    private void createNewDiscord() throws SQLException {
        Discord discord = readDiscord();
        discordController.setDiscord(discord);
    }

    private void updateDiscord() throws SQLException {
        Discord discord = readDiscord();

        Integer inputVersion = readDiscordVersion();
        discord.setVersion(inputVersion);

        discordController.putDiscord(discord);
    }

    private void deleteDiscord() throws SQLException {
        discordController.removeDiscord(readDiscordVersion());

    }

    private AudioFile readAudioFile() {


        System.out.println("Please write if it is voice message(true-yes,false-no):");
        final Boolean inputIsVoice = input.nextBoolean();

        System.out.println("Please write audio fule id:");
        final Integer inputAudioFileID = input.nextInt();
        return new AudioFile(0, inputIsVoice, inputAudioFileID);

    }

    private int readAudioFileID() {
        System.out.println("\nPlease write id of audio file:");
        return input.nextInt();
    }

    private void printAudioFileTable() throws SQLException {
        List<AudioFile> audioFiles = audioFileController.getAudioFiles();
        System.out.print("\n\nAudioFile\n");
        System.out
                .format("%8s    %-22s %-22s %n", "id", "is_voice_message", "chat_id");
        for (AudioFile audioFile : audioFiles) {
            System.out.print(audioFile);
        }

    }

    private void printRowFromAudioFileByID() throws SQLException {
        int inputVersion = readAudioFileID();
        System.out.print("\n\nAudioFile\n");
        System.out
                .format("%8s    %-22s %-22s %n", "id", "is_voice_message", "chat_id");
        System.out.println(audioFileController.getAudioFile(inputVersion));
    }

    private void createNewAudioFile() throws SQLException {
        AudioFile audioFile = readAudioFile();
        audioFileController.setAudioFile(audioFile);
    }

    private void updateAudioFile() throws SQLException {
        AudioFile audioFile = readAudioFile();

        Integer inputID = readAudioFileID();
        audioFile.setId(inputID);
        System.out.println(audioFile);
        audioFileController.putAudioFile(audioFile);
    }

    private void deleteAudioFile() throws SQLException {
        audioFileController.removeAudioFile(readAudioFileID());

    }

    private MediaFile readMediaFile() {


        System.out.println("Please write file type:");
        final String inputFileType = input.nextLine();

        System.out.println("Please write chat id:");
        final Integer inputChatID = input.nextInt();
        return new MediaFile(0, inputFileType, inputChatID);

    }

    private int readMediaFileID() {
        System.out.println("\nPlease write id of media file:");
        return input.nextInt();
    }

    private void printMediaFileTable() throws SQLException {
        List<MediaFile> mediaFiles = mediaFileController.getMediaFiles();
        System.out.print("\n\nMediaFile\n");
        System.out
                .format("%8s    %-22s %-22s %n", "id", "file_type", "chat_id");
        for (MediaFile mediaFile : mediaFiles) {
            System.out.print(mediaFile);
        }

    }

    private void printRowFromMediaFileByID() throws SQLException {
        int inputVersion = readMediaFileID();
        System.out.print("\n\nMediaFile\n");
        System.out
                .format("%8s    %-22s %-22s %n", "id", "file_type", "chat_id");
        System.out.println(mediaFileController.getMediaFile(inputVersion));
    }

    private void createNewMediaFile() throws SQLException {
        MediaFile mediaFile = readMediaFile();
        mediaFileController.setMediaFile(mediaFile);
    }

    private void updateMediaFile() throws SQLException {
        MediaFile mediaFile = readMediaFile();

        Integer inputID = readMediaFileID();
        mediaFile.setId(inputID);
        System.out.println(mediaFile);
        mediaFileController.putMediaFile(mediaFile);
    }

    private void deleteMediaFile() throws SQLException {
        mediaFileController.removeMediaFile(readMediaFileID());

    }

    private Chat readChat() {

        PK_Chat pk = new PK_Chat(0, "private");

        System.out.println("Please write chat name:");
        final String inputName = input.nextLine();

        System.out.println("Please write chat region:");
        final String inputRegion = input.nextLine();

        System.out.println("Please write discord version:");
        final Integer inputDiscordVersion = input.nextInt();

        return new Chat(pk, inputName, inputRegion, inputDiscordVersion);

    }

    private int readChatID() {
        System.out.println("\nPlease write id of Chat:");
        return input.nextInt();
    }

    private void printChatTable() throws SQLException {
        List<Chat> chats = chatController.getChats();
        System.out.print("\n\nChat\n");
        System.out
                .format("%8s    %-22s %-22s %-22s %-22s %n", "id", "chat_style_name", "name", "region", "Discord_version");
        for (Chat chat : chats) {
            System.out.print(chat);
        }

    }

    private void printRowFromChatByID() throws SQLException {
        int inputVersion = readChatID();
        System.out.print("\n\nChat\n");
        System.out
                .format("%8s    %-22s %-22s %-22s %-22s %n", "id", "chat_style_name", "name", "region", "Discord_version");
        System.out.println(chatController.getChat(inputVersion));
    }

    private void createNewChat() throws SQLException {
        Chat chat = readChat();
        chatController.setChat(chat);
    }

    private void updateChat() throws SQLException {
        Chat chat = readChat();

        Integer inputID = readChatID();
        chat.getPk().setId(inputID);
        System.out.println(chat);
        chatController.putChat(chat);
    }

    private void deleteChat() throws SQLException {
        chatController.removeChat(readChatID());

    }

    private ChatMessage readChatMessage() {



        System.out.println("Please write chat name:");
        final String inputName = input.nextLine();
        System.out.println("Please write chat style name:");
        final String inputChatStyleName = input.nextLine();


        System.out.println("Please write message id:");
        final Integer inputMessageID = input.nextInt();

        System.out.println("Please write chat id:");
        final Integer inputChatID = input.nextInt();


        PK_ChatMessage pk = new PK_ChatMessage(inputChatID, inputMessageID, inputChatStyleName);

        return new ChatMessage(pk, inputName);

    }

    private int readChatMessageID() {
        System.out.println("\nPlease write message id of ChatMessage:");
        return input.nextInt();
    }

    private void printChatMessageTable() throws SQLException {
        List<ChatMessage> chats = chatMessageController.getChatMessages();
        System.out.print("\n\nChatMessage\n");
        System.out
                .format("%8s    %-22s %-22s %-22s  %n", "message_id", "chat_name", "chat_id", "chat_style_name");
        for (ChatMessage chat : chats) {
            System.out.print(chat);
        }

    }

    private void printRowFromChatMessageByID() throws SQLException {
        int inputVersion = readChatMessageID();
        System.out.print("\n\nChatMessage\n");
        System.out
                .format("%8s    %-22s %-22s %-22s  %n", "message_id", "chat_name", "chat_id", "chat_style_name");
        System.out.println(chatMessageController.getChatMessage(inputVersion));
    }

    private void createNewChatMessage() throws SQLException {
        ChatMessage chatMessage = readChatMessage();
        chatMessageController.setChatMessage(chatMessage);
    }

    private void updateChatMessage() throws SQLException {
        ChatMessage chatMessage = readChatMessage();

        Integer inputID = readChatMessageID();
        chatMessage.getPk().setMessageID(inputID);
        System.out.println(chatMessage);
        chatMessageController.putChatMessage(chatMessage);
    }

    private void deleteChatMessage() throws SQLException {
        chatMessageController.removeChatMessage(readChatMessageID());

    }

    private ChatStyle readChatStyle() {

        System.out.println("Please write chat_style name:");
        final String inputName = input.nextLine();

        return new ChatStyle(inputName);

    }

    private String readChatStyleName() {
        System.out.println("\nPlease write name of Chat_style:");
        return input.nextLine();
    }

    private void printChatStyleTable() throws SQLException {
        List<ChatStyle> chatStyles = chatStyleController.getChatStyles();
        System.out.print("\n\nChatStyle\n");
        System.out
                .format("%20s   ", "name");
        for (ChatStyle chatStyle : chatStyles) {
            System.out.print(chatStyle);
        }

    }

    private void printRowFromChatStyleByID() throws SQLException {
        String inputVersion = readChatStyleName();
        System.out.print("\n\nChat\n");
        System.out
                .format("%20s   ", "name");
        System.out.println(chatStyleController.getChatStyle(inputVersion));
    }

    private void createNewChatStyle() throws SQLException {
        ChatStyle chatStyle = readChatStyle();
        chatStyleController.setChatStyle(chatStyle);
    }

    private void updateChatStyle() throws SQLException {
        ChatStyle chatStyle = readChatStyle();

        String inputName = readChatStyleName();
        chatStyle.setName(inputName);
        System.out.println(chatStyle);
        chatStyleController.putChatStyle(chatStyle);
    }

    private void deleteChatStyle() throws SQLException {
        chatStyleController.removeChatStyle(readChatStyleName());

    }

    private Message readMessage() {


        System.out.println("Please write message addressee:");
        final String inputMessageAddressee = input.nextLine();

        PK_Message pk = new PK_Message(11, inputMessageAddressee);

        return new Message(pk);

    }

    private int readMessageID() {
        System.out.println("\nPlease write id of Message:");
        return input.nextInt();
    }

    private void printMessageTable() throws SQLException {
        List<Message> messages = messageController.getMessages();
        System.out.print("\n\nMessage\n");
        System.out
                .format("%8s %-22s %n", "id", "addressee");
        for (Message message : messages) {
            System.out.print(message);
        }

    }

    private void printRowFromMessageByID() throws SQLException {
        int inputVersion = readMessageID();
        System.out.print("\n\nMessage\n");
        System.out
                .format("%8s %-22s %n", "id", "addressee");
        System.out.println(messageController.getMessage(inputVersion));
    }

    private void createNewMessage() throws SQLException {
        Message message = readMessage();
        messageController.setMessage(message);
    }

    private void updateMessage() throws SQLException {
        Message message = readMessage();

        Integer inputID = readMessageID();
        message.getPk().setId(inputID);
        System.out.println(message);
        messageController.putMessage(message);
    }

    private void deleteMessage() throws SQLException {
        messageController.removeMessage(readMessageID());

    }

    private UserChat readUserChat() {



        System.out.println("Please write chat style name:");
        final String inputChatStyleName = input.nextLine();

        System.out.println("Please write user nickname:");
        final String inputUserNickName = input.nextLine();

        System.out.println("Please write chat name:");
        final String inputChatName = input.nextLine();

        System.out.println("Please write user id:");
        final Integer inputUserID = input.nextInt();

        System.out.println("Please write chat id:");
        final Integer inputChatID = input.nextInt();



        PK_UserChat pk = new PK_UserChat(inputChatID, inputChatStyleName, inputUserID, inputUserNickName);

        return new UserChat(pk,inputChatName);

    }

    private int readUserChatID() {
        System.out.println("\nPlease write user_chat id :");
        return input.nextInt();
    }

    private void printUserChatTable() throws SQLException {
        List<UserChat> userChats = userChatController.getUserChats();
        System.out.print("\n\nUserChat\n");
        System.out
                .format("%8s    %-22s %-8s %-22s  %n", "chat_id", "chat_style_name", "user_id", "user_nickname");
        for (UserChat userChat : userChats) {
            System.out.print(userChat);
        }

    }

    private void printRowFromUserChatByID() throws SQLException {
        int inputVersion = readUserChatID();
        System.out.print("\n\nUserChat\n");
        System.out
                .format("%8s    %-22s %-8s %-22s  %n", "chat_id", "chat_style_name", "user_id", "user_nickname");
        System.out.println(userChatController.getUserChat(inputVersion));
    }

    private void createNewUserChat() throws SQLException {
        UserChat userChat = readUserChat();
        userChatController.setUserChat(userChat);
    }

    private void updateUserChat() throws SQLException {
        UserChat userChat = readUserChat();

        Integer inputID = readUserChatID();
        userChat.getPk().setUserID(inputID);
        System.out.println(userChat);
        userChatController.putUserChat(userChat);
    }

    private void deleteUserChat() throws SQLException {
        userChatController.removeUserChat(readUserChatID());

    }

    private User readUser() {


        System.out.println("Please write User nickname:");
        final String inputUserNickName = input.nextLine();

        System.out.println("Please write Discord version:");
        final Integer inputDiscordVersion = input.nextInt();

        System.out.println("Please write user id:");
        final Integer inputUserID = input.nextInt();

        PK_User pk = new PK_User(inputUserID, inputUserNickName);

        return new User(pk, inputDiscordVersion);

    }

    private int readUserID() {
        System.out.println("\nPlease write id of User:");
        return input.nextInt();
    }

    private void printUserTable() throws SQLException {
        List<User> users = userController.getUsers();
        System.out.print("\n\nUser\n");
        System.out
                .format("%8s    %-22s %-22s  %n", "id", "nickname", "Discord_version");
        for (User user : users) {
            System.out.print(user);
        }

    }

    private void printRowFromUserByID() throws SQLException {
        int inputVersion = readUserID();
        System.out.print("\n\nUser\n");
        System.out
                .format("%8s    %-22s %-22s  %n", "id", "nickname", "Discord_version");
        System.out.println(userController.getUser(inputVersion));
    }

    private void createNewUser() throws SQLException {
        User user = readUser();
        userController.setUser(user);
    }

    private void updateUser() throws SQLException {
        User user = readUser();

        Integer inputID = readUserID();
        user.getPk().setId(inputID);
        System.out.println(user);
        userController.putUser(user);
    }

    private void deleteUser() throws SQLException {
        userController.removeUser(readUserID());

    }

    private void printAllTables() throws SQLException {
        printDiscordTable();
        printAudioFileTable();
        printMediaFileTable();
        printChatTable();
        printChatMessageTable();
        printChatStyleTable();
        printMessageTable();
        printUserChatTable();
        printUserTable();
    }
}
