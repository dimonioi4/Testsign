import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {

        @Test
        public void avtorization (String[] args) {
            var playwright = Playwright.create();

            var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            var browserContext = browser.newContext();

            var page = browserContext.newPage();
            page.navigate("https://dev.lk.tr-line.ru/sign-in");

            page.fill("#input-18", "admin");
            page.fill("#input-22", "password");
            page.click("button.v-btn:nth-child(2) > span:nth-child(1)");


            String text = page.innerText(".selected");
            assertEquals("Неудачная попытка авторизоваться", text);

            browser.close();
        }

    @Test
            public void registration (String[] args) {
    var playwright = Playwright.create();

    var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    var browserContext = browser.newContext();

    var page = browserContext.newPage();

            page.navigate("https://dev.lk.tr-line.ru/sign-in");

            page.click("a.v-btn:nth-child(3) > span:nth-child(1)");
            page.fill("#email-input", "ivan@yandex.ru");
            page.fill("#input-143", "88005553535");
            page.click("button.v-btn > span:nth-child(1)");
            page.fill("#input-163", "Иванов");
            page.fill("#input-166", "Иван");
            page.fill("#input-169", "Иванович");
            page.click(".v-btn--is-elevated > span:nth-child(1)");

        String text = page.innerText(".selected");
        assertEquals("Пользователь успешно зарегистрирован", text);


    browser.close();
}

@Test
    public void recoverPassword  (String[] args) {
        var playwright = Playwright.create();

        var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        var browserContext = browser.newContext();

        var page = browserContext.newPage();
        page.navigate("https://dev.lk.tr-line.ru/sign-in");

        page.click("a.v-btn:nth-child(1) > span:nth-child(1)");
        page.fill("#input-38", "ivan@yandex.ru");
        page.click(".v-btn");
        String text = page.innerText(".selected");
        assertEquals("Пользователя с такими данными не существует.", text);

        browser.close();

    }

}