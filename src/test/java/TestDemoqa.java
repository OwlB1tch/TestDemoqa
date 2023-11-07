import ext.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.BooksPage;
import page.ProfilePage;

@ExtendWith({
        ChromeDriverExt.class,
        AuthExt.class,
        BookPageResolver.class,
        ProfilePageResolver.class})
public class TestDemoqa {

    @Test
    public void testEmptyProfileCollection(ProfilePage profilePage) {
        // Сценарий 1.  (проверка, что в профиле нет книг)
        assert profilePage
                .getBooksCount() == 0;
    }

    @Test
    public void testCheckDeleteBooks(ProfilePage profilePage, BooksPage booksPage) {
        // Сценарий 3. (добавить 2 книги и удалить, проверить , что в профиле нет книг)
        int[] booksN = new int[]{1, 2};
        profilePage.gotoStore();
        booksPage.addBooks(booksN);
        int booksInProfile = profilePage
                .openPage()
                .getBooksCount();
        assert profilePage
                .deleteAllBooks()
                .getBooksCount() == 0;
        assert booksN.length == booksInProfile;
    }

    @Test
    @ExtendWith(ClearProfileCollectionExt.class)
    public void testCheckCountBooks(ProfilePage profilePage, BooksPage booksPage) {
        // Сценарий 2. (добавить 6 книг и проверить их количество в профиле)
        int[] booksN = new int[]{0, 1, 2, 3, 4, 5};
        profilePage.gotoStore();
        booksPage.openPage().addBooks(booksN);
        int booksInProfile = profilePage
                .openPage()
                .setCountRowsPerPage("10")
                .getBooksCount();
        assert booksN.length == booksInProfile;
    }

}
