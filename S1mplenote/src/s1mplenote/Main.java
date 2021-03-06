package s1mplenote;

import s1mplenote.entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Annotation> annotations = new ArrayList<Annotation>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        boolean loginMenu = true;
        while (loginMenu) {
            printLoginMenu();
            int loginOption = in.nextInt();
            in.nextLine();
            switch (loginOption) {
                case 1:
                    String loginEmail;
                    String loginPassword;

                    System.out.println("Email: ");
                    loginEmail = in.next();

                    System.out.println("Senha: ");
                    loginPassword = in.next();

                    in.nextLine();

                    for (int i = 0; i < users.size(); i++) {

                        if (loginEmail.contentEquals(users.get(i).getEmail()) && loginPassword.contentEquals(users.get(i).getPassword())) {

                            User user = users.get(i);

                            System.out.println("Bem-vindo ao S1mplenote");
                            boolean mainMenu = true;
                            while (mainMenu) {
                                printMainMenu();
                                int mainOption = in.nextInt();
                                in.nextLine();
                                switch (mainOption) {
                                    case 1:
                                        boolean noteMenu = true;
                                        while (noteMenu) {
                                            printNoteMenu();
                                            int noteOption = in.nextInt();
                                            in.nextLine();
                                            switch (noteOption) {
                                                case 1:

                                                    System.out.println("T??tulo:");
                                                    String title = in.nextLine();

                                                    System.out.println("Texto:");
                                                    String text = in.nextLine();

                                                    Note note = new Note(title, text);
                                                    user.getNotes().add(note);
                                                    annotations.add(note);

                                                    int tagOption = 0;
                                                    while (tagOption > 2 || tagOption < 1){
                                                        System.out.println("Deseja inserir uma tag?");
                                                        System.out.println("-[1] - Sim");
                                                        System.out.println("-[2] - N??o");
                                                        tagOption = in.nextInt();
                                                    }

                                                    if (tagOption == 1){
                                                        in.nextLine();
                                                        System.out.println("Insira a Tag desejada: ");
                                                        String newTag = in.nextLine();

                                                        Tag tag = new Tag(newTag);
                                                        user.getTags().add(tag);// - Problema de L??gica.
                                                    }

                                                    if (tagOption == 2){
                                                        Tag tag = new Tag("");
                                                        user.getTags().add(tag);// - Problema de L??gica.
                                                    }

                                                    System.out.println("Anota????o criada com sucesso.");
                                                    break;

                                                case 2:

                                                    if(user.getNotes().size() < 1){
                                                        System.out.println("Nenhuma anota????o no momento!");
                                                    }

                                                    for (int indexNote = 0; indexNote < user.getNotes().size();indexNote++){
                                                        System.out.println();
                                                        System.out.println("|" + indexNote + "| T??tulo: " + user.getNotes().get(indexNote).getTitle());
                                                        System.out.println("'" + user.getNotes().get(indexNote).getText() + "'");
                                                        System.out.println("TAG:" + user.getTags().get(indexNote).getName());// - Problema de L??gica.
                                                        System.out.println();
                                                    }

                                                    break;

                                                case 3:

                                                    System.out.println("??ndice a ser alterado:");
                                                    int indice = in.nextInt();

                                                    if (indice < user.getNotes().size()) {

                                                        note = user.getNotes().get(indice);

                                                        System.out.println("Deseja atualizar o T??tulo?");
                                                        System.out.println("-[1] - Sim");
                                                        System.out.println("-[2] - N??o");
                                                        int titleOption = in.nextInt();

                                                        if (titleOption > 2 || titleOption < 1) {
                                                            System.out.println("Op????o invalida!");
                                                            System.out.println();
                                                        }
                                                        if (titleOption == 1) {
                                                            System.out.println("T??tulo:");
                                                            title = in.next();

                                                            note.setTitle(title);
                                                            System.out.println("T??tulo alterado com sucesso.");
                                                            System.out.println();
                                                        }

                                                        System.out.println("Deseja atualizar o Texto?");
                                                        System.out.println("-[1] - Sim");
                                                        System.out.println("-[2] - N??o");
                                                        int textOption = in.nextInt();

                                                        if (textOption > 2 || textOption < 1) {
                                                            System.out.println("Op????o invalida!");
                                                            System.out.println();
                                                        }
                                                        if (textOption == 1) {
                                                            System.out.println("Texto:");
                                                            text = in.next();

                                                            note.setText(text);
                                                            System.out.println("Texto alterado com sucesso.");
                                                            System.out.println();
                                                        }
                                                    } else {
                                                        System.out.println("??ndice [" + indice + "] n??o encontrado.");
                                                    }
                                                    break;

                                                case 4:

                                                    System.out.println("??ndice a ser deletado:");
                                                    int indiceTrash = in.nextInt();

                                                    if (indiceTrash < user.getNotes().size()) {
                                                        Trash trash = new Trash();


                                                        //user.getNotesDeleted().add(user.getNotes());
                                                        //annotations.add(user.getNotesDeleted());

                                                        //user.getTrash().getNotesDeleted().add((user.getNotes().get(indiceTrash)));// - Problema de L??gica.

                                                        //user.getNotesDeleted().add(user.getNotes().get(indiceTrash));// - Problema de L??gica.

                                                        user.getNotes().remove(indiceTrash);
                                                        user.getTags().remove(indiceTrash);// - Problema de L??gica.

                                                        user.getTrash().setEmpty(false);

                                                        System.out.println("??ndice [" + indiceTrash + "] apagado.");

                                                    } else {
                                                        System.out.println("??ndice [" + indiceTrash + "] n??o encontrado.");
                                                    }
                                                    break;

                                                case 5:
                                                    noteMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        boolean trashMenu = true;
                                        while (trashMenu) {
                                            printTrashMenu();
                                            int trashOption = in.nextInt();
                                            in.nextLine();
                                            switch (trashOption) {
                                                case 1:
                                                    if(user.getTrash().getNotesDeleted().size() < 1){
                                                        System.out.println("Lixeira vazia!");
                                                    }

                                                    for (int indexTrash = 0; indexTrash < user.getTrash().getNotesDeleted().size();indexTrash++){
                                                        System.out.println();
                                                        System.out.println("|" + indexTrash + "| T??tulo: " + user.getTrash().getNotesDeleted().get(indexTrash).getTitle());
                                                        System.out.println("'" + user.getTrash().getNotesDeleted().get(indexTrash).getText() + "'");
                                                        System.out.println();

                                                    }

                                                    break;

                                                case 2:

                                                    for (int indexTrash = 0;indexTrash < user.getTrash().getNotesDeleted().size();indexTrash++){
                                                        user.getTrash().getNotesDeleted().remove(indexTrash);

                                                    }

                                                    user.getTrash().setEmpty(true);
                                                    System.out.println("Lixeira vazia!");

                                                    break;

                                                case 3:
                                                    trashMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 3:
                                        boolean tagMenu = true;
                                        while (tagMenu) {
                                            printTagMenu();
                                            int tagOption = in.nextInt();
                                            in.nextLine();
                                            switch (tagOption) {
                                                case 1:
                                                    for (int tagList = 0; tagList<user.getTags().size(); tagList++){
                                                        System.out.println("TAG:" + user.getTags().get(tagList).getName());
                                                        System.out.println();
                                                    }

                                                    //System.out.println("Existem " + user.getTags().size() + " Tag's cadastradas no momento!");// - Problema de L??gica.
                                                    break;

                                                case 2:
                                                    tagMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        boolean settingsMenu = true;
                                        while (settingsMenu) {
                                            printSettingsMenu();
                                            int settingsOption = in.nextInt();
                                            in.nextLine();
                                            switch (settingsOption) {
                                                case 1:

                                                    System.out.println("---------- Informa????es Pessoais ----------");
                                                    System.out.println("Email: " + user.getEmail());
                                                    System.out.println("Senha: " + user.getPassword());
                                                    System.out.println("---------- Configura????es Gerais ----------");
                                                    System.out.println("Ordenar:" + user.getSettings().getSort());
                                                    System.out.println("Sincronizar:" + user.getSettings().getSync());

                                                    break;

                                                case 2:
                                                    int sortOption = 0;
                                                    while (sortOption > 2 || sortOption < 1){
                                                        System.out.println("Ordenar?");
                                                        System.out.println("-[1] - Sim");
                                                        System.out.println("-[2] - N??o");
                                                        sortOption = in.nextInt();
                                                    }
                                                    if (sortOption == 1){
                                                        user.getSettings().setSort(true);
                                                    }
                                                    if (sortOption == 2){
                                                        user.getSettings().setSort(false);
                                                    }

                                                    int syncOption = 0;
                                                    while (syncOption > 2 || syncOption < 1){
                                                        System.out.println("Sincronizar?");
                                                        System.out.println("-[1] - Sim");
                                                        System.out.println("-[2] - N??o");
                                                        syncOption = in.nextInt();
                                                    }
                                                    if (syncOption == 1){
                                                        user.getSettings().setSync(true);
                                                    }
                                                    if (syncOption == 2){
                                                        user.getSettings().setSync(false);
                                                    }

                                                    break;

                                                case 3:
                                                    settingsMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 5:
                                        mainMenu = false;
                                        break;

                                    default:
                                        System.out.println("Op????o invalida!");
                                        break;
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("Email para cadastro: ");
                    String email = in.next();
                    System.out.println("Senha para cadastro: ");
                    String password = in.next();
                    User user = new User(email, password);
                    users.add(user);
                    System.out.println("Cadastro realizado com sucesso!");
                    break;

                case 3:
                    loginMenu = false;
                    System.out.println("At?? a pr??xima.");
                    break;

                default:
                    System.out.println("Op????o invalida!");
                    break;
            }
        }
    }

    static void printLoginMenu() {
        System.out.println("---------------------");
        System.out.println("-[1] - Fa??a seu login");
        System.out.println("-[2] - Cadastre-se");
        System.out.println("-[3] - Sair");
        System.out.println("---------------------");
    }

    static void printMainMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Anota????es");
        System.out.println("-[2] - Lixeira");
        System.out.println("-[3] - Tags");
        System.out.println("-[4] - Configura????es");
        System.out.println("-[5] - Sair");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printNoteMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Nova anota????o");
        System.out.println("-[2] - Mostrar anota????es");
        System.out.println("-[3] - Atualizar anota????o");
        System.out.println("-[4] - Apagar anota????o");
        System.out.println("-[5] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printTrashMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar Lixeira");
        System.out.println("-[2] - Esvaziar lixeira  ");
        System.out.println("-[3] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printTagMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar TAGS");
        System.out.println("-[2] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printSettingsMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar configura????es");
        System.out.println("-[2] - Alterar configura????es");
        System.out.println("-[3] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }
}