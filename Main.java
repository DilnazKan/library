public class Main {
    public static void main(String[] args) {
        ILibrary library = createLibrary();
        Menu menu = new Menu(library);
        menu.run();
    }

    public static ILibrary createLibrary() {
        return new FakeLibrary();
    }
}
