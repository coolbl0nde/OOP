
public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();

        User user1 = new User("Masha", "Mihalevich", "+375294575445", "coolbl0nde", "364674537", dataBase);
        User user2 = new User("Ilya", "Mihalevich", "+375295748934", "ilfkdg", "kkfjfdjglgjf", dataBase);

        System.out.println("Данные первого пользователя: " + user1.getName() + " " + user1.getSurname() + " " + user1.getUsername() + " " + user1.getPhoneNumber());
        System.out.println("Данные второго пользователя: " + user2.getName() + " " + user2.getSurname());

        /*System.out.println("Меняем имя у 1 пользователя.");
        user1.setName("Lera");
        System.out.println("Новое имя: " + user1.getName());*/

        //Message message = new Message("привет", user1.getId(), dataBase);
        //System.out.println("Текст сообщения: " + message.getText() + " Дата: " + message.getDate() + " Время: " + message.getTime());

        Chat chat = new Chat(user1.getId(), user2.getId(), dataBase);
        System.out.println("Создан чат 1 и 2 пользователя");
        chat.sendMessage("как дела", user1.getId(), dataBase);
        chat.sendMessage("норм", user2.getId(), dataBase);
        System.out.println("Список сообщений: " + chat.messagesList());

        GroupChat groupChat = new GroupChat(user1.getId(), user2.getId(), "group", dataBase);
        groupChat.sendMessage("пока", user2.getId(), dataBase);

        User user3 = new User("Vlada", "Mihalevich", "+375295748949", "coolbl0nde", "364674537", dataBase);

        System.out.println("id user1 = " + user1.getId() + " id user2 = " + user2.getId() + " id user3 = " + user3.getId());

        groupChat.addUser(user3.getId());

        System.out.println("Список пользователей в группе: " + groupChat.getNameOfUsers());

        groupChat.deleteUser(user1.getId());

        System.out.println("Список с удаленным пользователем: " + groupChat.getNameOfUsers());

        groupChat.sendMessage("привет всем", user2.getId(), dataBase);
        groupChat.sendMessage("приветики", user3.getId(), dataBase);
        System.out.println("Сообщения группового чата: " + groupChat.messagesList());

        System.out.println("Список чатов: " + Chat.listOfChats());
        Chat.deleteChat(chat.getId());
        System.out.println("Удаляем первый чат. Новый список чатов: " + groupChat.listOfChats());
    }
}